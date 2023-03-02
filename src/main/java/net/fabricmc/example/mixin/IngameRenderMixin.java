package net.fabricmc.example.mixin;

import net.fabricmc.example.conf.config;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(InGameHud.class)
public class IngameRenderMixin {
    @Inject(at = @At(value = "RETURN"), method = "render", cancellable = true)
    public void render(MatrixStack matrixStack, float ttf, CallbackInfo info) {
        if (!config.isPanic()) {
            MinecraftClient.getInstance().inGameHud.getFontRenderer().draw(matrixStack, "Coded by bushrutixxx", 10, 10, new Color(0xFA63FF).getRGB());
        }
    }
}
