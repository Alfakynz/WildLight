package com.alfakynz.wildlight.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import eu.midnightdust.visualoverhaul.block.model.FurnaceWoodenPlanksModel;
import eu.midnightdust.visualoverhaul.block.renderer.FurnaceBlockEntityRenderer;
import eu.midnightdust.visualoverhaul.config.VOConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.AxisAngle4f;
import org.joml.Math;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(FurnaceBlockEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class VisualOverhaulCompatMixin<E extends AbstractFurnaceBlockEntity> {

    @Unique
    private static final Quaternionf degrees90x = new Quaternionf(new AxisAngle4f(Math.toRadians(90), 1, 0, 0));

    @Unique
    private FurnaceWoodenPlanksModel planks;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(BlockEntityRendererProvider.Context ctx, CallbackInfo ci) {
        this.planks = new FurnaceWoodenPlanksModel(ctx.bakeLayer(FurnaceWoodenPlanksModel.WOODEN_PLANKS_MODEL_LAYER));
    }

    @Inject(method = "render*", at = @At("HEAD"), cancellable = true)
    private void onRender(E blockEntity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (!VOConfig.furnace || blockEntity == null) return;

        BlockState blockState = blockEntity.getBlockState();
        int lightAtBlock = LevelRenderer.getLightColor(Objects.requireNonNull(blockEntity.getLevel()), blockEntity.getBlockPos().offset(blockState.getValue(AbstractFurnaceBlock.FACING).getNormal()));
        ItemStack input = blockEntity.getItem(0);
        ItemStack fuel = blockEntity.getItem(1);
        ItemStack output = blockEntity.getItem(2);
        float angle = blockState.getValue(AbstractFurnaceBlock.FACING).toYRot();

        if (!input.isEmpty() || !output.isEmpty()) {
            matrices.pushPose();
            matrices.translate(0.5f, 0.58f, 0.5f);

            if (blockEntity.getBlockState().getBlock().equals(Blocks.SMOKER)) matrices.translate(0f, -0.06f, 0f);
            if (blockEntity.getBlockState().getBlock().equals(Blocks.BLAST_FURNACE)) matrices.translate(0f, -0.25f, 0f);

            matrices.scale(1f, 1f, 1f);
            matrices.mulPose(new Quaternionf(new AxisAngle4f(Math.toRadians(angle * 3 + 180), 0, 1, 0)));
            matrices.translate(0.0f, 0.0f, -0.4f);
            matrices.mulPose(degrees90x);

            Minecraft.getInstance().getItemRenderer().renderStatic(input.isEmpty() ? output : input, ItemDisplayContext.GROUND, lightAtBlock, overlay, matrices, vertexConsumers, blockEntity.getLevel(), 0);

            matrices.popPose();
        }

        if (!fuel.isEmpty() && !fuel.is(ItemTags.LOGS_THAT_BURN) && !fuel.is(ItemTags.PLANKS)) {
            matrices.pushPose();
            matrices.translate(0.5f, 0.08f, 0.5f);
            if (blockEntity.getBlockState().getBlock().equals(Blocks.SMOKER)) matrices.translate(0f, 0.06f, 0f);
            if (blockEntity.getBlockState().getBlock().equals(Blocks.BLAST_FURNACE)) matrices.translate(0f, 0.24f, 0f);
            matrices.scale(1f, 1f, 1f);
            matrices.mulPose(new Quaternionf(new AxisAngle4f(Math.toRadians(angle * 3 + 180), 0, 1, 0)));
            matrices.translate(0.0f, 0.0f, -0.4f);
            matrices.mulPose(degrees90x);

            Minecraft.getInstance().getItemRenderer().renderStatic(fuel, ItemDisplayContext.GROUND, lightAtBlock, overlay, matrices, vertexConsumers, blockEntity.getLevel(), 0);

            matrices.popPose();
        } else if (!fuel.isEmpty()) {
            matrices.pushPose();
            Block block = Block.byItem(fuel.getItem());
            ResourceLocation blockId = Objects.requireNonNull(Minecraft.getInstance().getConnection())
                    .registryAccess()
                    .registryOrThrow(Registries.BLOCK)
                    .getKey(block);
            assert blockId != null;
            ResourceLocation texture = ResourceLocation.tryBuild(blockId.getNamespace(), "textures/block/" + blockId.getPath() + ".png");

            assert texture != null;
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(texture));

            matrices.translate(0.5f, -1.3f, 0.5f);
            if (blockState.getBlock().equals(Blocks.SMOKER)) matrices.translate(0f, 0.06f, 0f);
            if (blockState.getBlock().equals(Blocks.BLAST_FURNACE)) matrices.translate(0f, 0.2f, 0f);
            matrices.scale(1f, 1f, 1f);
            matrices.mulPose(new Quaternionf(new AxisAngle4f(Math.toRadians(angle * 3 + 180), 0, 1, 0)));
            planks.getPart().render(matrices, vertexConsumer, lightAtBlock, overlay);
            matrices.popPose();
        }

        ci.cancel();
    }
}