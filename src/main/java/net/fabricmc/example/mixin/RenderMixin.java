package net.fabricmc.example.mixin;

import net.fabricmc.example.conf.config;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class RenderMixin {
    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double tf, double tf1, double tf2, float tf3, MatrixStack matrixStack,
                              VertexConsumerProvider vertexConsumerProvider, CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            if (entity != MinecraftClient.getInstance().player) {
                entity.setBoundingBox(new Box(
                        entity.getX() - (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getBoundingBox().minY,
                        entity.getZ() - (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getX() + (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getBoundingBox().maxY,
                        entity.getZ() + (config.isPanic() ? 0.3F : config.getSize())
                ));
            }
        }
    }
}
