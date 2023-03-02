package net.fabricmc.example.mixin;

import net.fabricmc.example.conf.config;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "net/minecraft/client/util/InputUtil.isKeyPressed(JI)Z", ordinal = 5), cancellable = true)
    private void onKey(long windowPointer, int key, int code, int action, int mods, CallbackInfo callbackInfo) {
        // k = 75
        // i = 73
        // p = 80

        if (action == 1) {
            if (key == 75) {
                config.setSize((config.getSize() + 0.05));
            } if (key == 73) {
                config.setSize((config.getSize() - 0.05));
            } if (key == 80) {
                config.setPanic(true);
            }
        }
    }
}
