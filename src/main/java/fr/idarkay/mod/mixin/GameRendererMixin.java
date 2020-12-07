package fr.idarkay.mod.mixin;

import fr.idarkay.mod.client.render.TelescopeRender;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * File <b>GameRendererMixin</b> located on fr.idarkay.mod.mixin
 * GameRendererMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 21:23
 */
@Mixin(GameRenderer.class)
public class GameRendererMixin
{

    @Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", at = @At(value = "FIELD", target = "Lnet/minecraft/client/options/GameOptions;fov:D"), cancellable = true)
    private void getFov(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> ci)
    {
        if(TelescopeRender.isTelescopeEnable())
        {
            ci.setReturnValue(TelescopeRender.getEditedFov());
            ci.cancel();
        }
    }

}
