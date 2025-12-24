package com.alfakynz.wildlight.mixin;

import net.minecraft.world.entity.monster.breeze.Breeze;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Breeze.class)
public class BreezeCompatMixin {
    @Inject(method = "emitGroundParticles", at = @At("HEAD"), cancellable = true, remap = true)
    private void wildlight$removeGroundParticles(int i, CallbackInfo ci) {
        ci.cancel();
    }
}
