package fr.idarkay.mod.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.idarkay.mod.Mod_1_17;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

/**
 * File <b>TelescopeRend</b> located on fr.idarkay.mod.client.render
 * TelescopeRend is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 21:22
 */
@Environment(EnvType.CLIENT)
public class TelescopeRender
{
    private static final Identifier TELESCOPE_VIEW = new Identifier("mod_1_17", "textures/misc/telescope_view.png");
    private static final double MIN_FOV = 10;
    private static double editedFov = 70;
    private static boolean telescopeEnable = false;


    public static void runTelescopeCheck(MinecraftClient client)
    {
        if(telescopeEnable)
        {
            boolean cut = true;
            for (Hand hand : Hand.values())
            {
                ItemStack it = client.player.getStackInHand(hand);
                if(it != null && it.getItem().equals(Mod_1_17.TELESCOPE)) cut = false;
            }
            if(cut) switchStatus();
        }
    }

    public static void renderHUD(MinecraftClient client)
    {
        if(telescopeEnable)
        {
            // FOV
            if(editedFov > MIN_FOV)
            {
                editedFov = Math.max(MIN_FOV, editedFov - 5);
            }

            double scaledWidth = client.getWindow().getScaledWidth();
            double scaledHeight = client.getWindow().getScaledHeight();

            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.defaultBlendFunc();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableAlphaTest();
            client.getTextureManager().bindTexture(TELESCOPE_VIEW);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tessellator.getBuffer();

            bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
            bufferBuilder.vertex(0.0D, scaledHeight, -90.0D).texture(0.0F, 1.0F).next();
            bufferBuilder.vertex(scaledWidth, scaledHeight, -90.0D).texture(1.0F, 1.0F).next();
            bufferBuilder.vertex(scaledWidth, 0.0D, -90.0D).texture(1.0F, 0.0F).next();
            bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
            tessellator.draw();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableAlphaTest();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);


        }
    }

    public static void switchStatus()
    {
        telescopeEnable = !telescopeEnable;
        System.out.println("Switch " + telescopeEnable);
        editedFov = MinecraftClient.getInstance().options.fov;
    }

    public static double getEditedFov()
    {
        return editedFov;
    }

    public static boolean isTelescopeEnable()
    {
        return telescopeEnable;
    }
}
