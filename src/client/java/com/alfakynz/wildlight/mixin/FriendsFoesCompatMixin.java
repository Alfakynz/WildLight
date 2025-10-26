package com.alfakynz.wildlight.mixin;

import com.faboslav.friendsandfoes.common.entity.WildfireEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WildfireEntity.class)
public class FriendsFoesCompatMixin {
     @Inject(method = "emitGroundParticles", at = @At("HEAD"), cancellable = true, remap = false)
     private void wildlight$removeGroundParticles(int i, CallbackInfo ci) {
         ci.cancel();
     }
}