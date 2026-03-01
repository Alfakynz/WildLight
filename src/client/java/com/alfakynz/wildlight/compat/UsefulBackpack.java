package com.alfakynz.wildlight.compat;

import com.alfakynz.wildlight.WildLightClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import java.util.concurrent.atomic.AtomicBoolean;

public class UsefulBackpack implements ClientModInitializer {

    private static final long OPEN_THRESHOLD_NS = 500_000_000L;
    private volatile KeyEventSnapshot lastKey = KeyEventSnapshot.NONE;
    private volatile KeyEventSnapshot openerKey = KeyEventSnapshot.NONE;
    private GLFWKeyCallbackI previousCallback;
    private final AtomicBoolean callbackInstalled = new AtomicBoolean(false);

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("usefulbackpacks") && FabricLoader.getInstance().isModLoaded("trinkets")) {
            setupBackpackKeys();
        }
    }

    private void setupBackpackKeys() {
        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            if (callbackInstalled.get()) return;
            try {
                long window = Minecraft.getInstance().getWindow().getWindow();
                previousCallback = GLFW.glfwSetKeyCallback(window, (win, key, scancode, action, mods) -> {
                    if (previousCallback != null) previousCallback.invoke(win, key, scancode, action, mods);
                    if (action != GLFW.GLFW_PRESS) return;
                    lastKey = new KeyEventSnapshot(key, scancode, mods, System.nanoTime());
                    Screen screen = Minecraft.getInstance().screen;
                    if (isBackpackScreen(screen)) {
                        if (openerKey != KeyEventSnapshot.NONE && openerKey.equalsKey(lastKey)) {
                            Minecraft.getInstance().execute(() -> {
                                try {
                                    if (Minecraft.getInstance().player != null)
                                        Minecraft.getInstance().player.closeContainer();
                                    else if (Minecraft.getInstance().screen != null)
                                        Minecraft.getInstance().setScreen(null);
                                } catch (Throwable t) {
                                    if (Minecraft.getInstance().screen != null)
                                        Minecraft.getInstance().setScreen(null);
                                }
                            });
                        } else openerKey = lastKey;
                    } else openerKey = KeyEventSnapshot.NONE;
                });
                callbackInstalled.set(true);
            } catch (Throwable t) {
                WildLightClient.LOGGER.error("Error installing UsefulBackpack callback", t);
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            try {
                Screen screen = mc.screen;
                if (isBackpackScreen(screen) && lastKey != KeyEventSnapshot.NONE &&
                        System.nanoTime() - lastKey.timeNs <= OPEN_THRESHOLD_NS) openerKey = lastKey;
            } catch (Throwable t) {
                WildLightClient.LOGGER.error("Error in UsefulBackpack tick", t);
            }
        });
    }

    private boolean isBackpackScreen(Screen screen) {
        return screen != null && "info.u_team.useful_backpacks.screen.BackpackScreen".equals(screen.getClass().getName());
    }

    private record KeyEventSnapshot(int key, int scancode, int mods, long timeNs) {
        static final KeyEventSnapshot NONE = new KeyEventSnapshot(-1, -1, 0, 0L);
        boolean equalsKey(KeyEventSnapshot o) { return key == o.key && scancode == o.scancode && mods == o.mods; }
    }
}
