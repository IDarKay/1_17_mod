package fr.idarkay.mod.mixin;

import fr.idarkay.mod.client.render.TelescopeRender;
import fr.idarkay.mod.item.Telescope;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * File <b>MinecraftClientMixin</b> located on fr.idarkay.mod.mixin
 * MinecraftClientMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 19:41
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin
{
    @Inject(method = "tick()V", at = @At("RETURN"))
    public void tick(CallbackInfo ci)
    {
        TelescopeRender.runTelescopeCheck(MinecraftClient.getInstance());
    }

//
//    private void render(boolean tick, CallbackInfo ci)
//    {
//
//    }

}
