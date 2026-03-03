package com.alfakynz.wildlight.compat;

import com.alfakynz.wildlight.WildLightClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.Screen;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import java.util.concurrent.atomic.AtomicBoolean;

public class UsefulBackpacks implements ClientModInitializer {

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

                    if (!isBackpackKeyPressed(key, scancode)) return;

                    Screen screen = Minecraft.getInstance().screen;

                    if (isBackpackScreen(screen)) {
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
                    }
                });
                callbackInstalled.set(true);
            } catch (Throwable t) {
                WildLightClient.LOGGER.error("Error installing UsefulBackpack callback", t);
            }
        });
    }

    private boolean isBackpackScreen(Screen screen) {
        return screen != null && "info.u_team.useful_backpacks.screen.BackpackScreen".equals(screen.getClass().getName());
    }

    private boolean isBackpackKeyPressed(int key, int scancode) {
        try {
            Minecraft mc = Minecraft.getInstance();
            for (KeyMapping mapping : mc.options.keyMappings) {
                if ("key.usefulbackpacks.slotmodintegration.open_backpack.description".equals(mapping.getName())) {
                    return mapping.matches(key, scancode);
                }
            }
        } catch (Throwable ignored) {
        }
        return false;
    }
}
