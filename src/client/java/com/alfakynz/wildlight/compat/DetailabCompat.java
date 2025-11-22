package com.alfakynz.wildlight.compat;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.rhm.detailab_compat.DetailArmorBarCompatCommon;
import org.rhm.detailab_compat.DetailArmorBarCompatCommon.CompatInfo;

import java.util.Map;

public class DetailabCompat implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("detailab-compat")) {
            addImmersiveArmorsCompat();
        }
    }

    private void addImmersiveArmorsCompat() {
        Map<ResourceLocation, CompatInfo> map = DetailArmorBarCompatCommon.MOD_COMPATS;

        addSet(map, "bone");
        addSet(map, "divine");
        addSet(map, "heavy");
        addSet(map, "prismarine");
        addSet(map, "robe");
        addSet(map, "slime");
        addSet(map, "steampunk");
        addSet(map, "warrior");
        addSet(map, "wither");
        addSet(map, "wooden");
    }

    private void addSet(Map<ResourceLocation, CompatInfo> map, String set) {
        for (String part : DetailArmorBarCompatCommon.CompatBuilder.EQUIPMENT_TYPES) {
            ResourceLocation tex = ResourceLocation.fromNamespaceAndPath(
                    "detailab_compat",
                    "textures/gui/sprites/hud/immersive_armors/" + set + ".png"
            );
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(
                    "immersive_armors",
                    set + "_" + part
            );

            map.put(id, new CompatInfo.Builder(tex).build());
        }
    }
}