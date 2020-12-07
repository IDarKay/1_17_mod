package fr.idarkay.mod.mixin;

import fr.idarkay.mod.client.render.TelescopeRender;
import fr.idarkay.mod.item.Telescope;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * File <b>GameRenderMixin</b> located on fr.idarkay.mod.mixin
 * GameRenderMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 19:49
 */
@Mixin(InGameHud.class)
public class InGameHudMixin
{
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V", at = @At("RETURN"))
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci)
    {
        TelescopeRender.renderHUD(MinecraftClient.getInstance());
    }

}
