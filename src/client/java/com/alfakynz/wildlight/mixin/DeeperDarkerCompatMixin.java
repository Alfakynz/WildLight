package com.alfakynz.wildlight.mixin;

import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OthersidePortalBlock.class)
public abstract class DeeperDarkerCompatMixin extends CustomPortalBlock {

    public DeeperDarkerCompatMixin(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Inject(method = "animateTick", at = @At("HEAD"), cancellable = true)
    @Environment(EnvType.CLIENT)
    private void afterAnimateTick(BlockState state, Level world, BlockPos pos, RandomSource random, CallbackInfo ci) {
        ci.cancel();

        for (int i = 0; i < 1; i++) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.8;
            double y = pos.getY() + random.nextDouble() * 0.5;
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.8;
            world.addParticle(
                new net.minecraft.core.particles.DustParticleOptions(
                    new Vec3(0.0, 0.95, 0.85).toVector3f(), 0.75f
                ),
                x, y, z,
                0.0, 0.0, 0.0
            );
        }
    }
}