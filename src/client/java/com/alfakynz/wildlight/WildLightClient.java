package com.alfakynz.wildlight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class WildLightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModContainer container = FabricLoader.getInstance().getModContainer("wildlight").orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(
                ResourceLocation.fromNamespaceAndPath("wildlight", "wildlight"),
                container,
                Component.literal("WildLight Resources"),
                ResourcePackActivationType.DEFAULT_ENABLED
        );
    }
}