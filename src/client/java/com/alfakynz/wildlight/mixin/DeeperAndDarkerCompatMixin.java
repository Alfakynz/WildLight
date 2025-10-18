package com.alfakynz.wildlight.mixin;

import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Mixin(OthersidePortalBlock.class)
public abstract class DeeperAndDarkerCompatMixin extends CustomPortalBlock {

    public DeeperAndDarkerCompatMixin(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Inject(method = "animateTick", at = @At("HEAD"), cancellable = true)
    @Environment(EnvType.CLIENT)
    private void afterAnimateTick(BlockState state, Level world, BlockPos pos, RandomSource random, CallbackInfo ci) {
        ci.cancel();
    }
}