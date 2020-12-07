package fr.idarkay.mod;

import fr.idarkay.mod.block.Blocks_1_17;
import fr.idarkay.mod.item.Items_1_17;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.render.RenderLayer;

/**
 * File <b>Mod_1_17</b> located on fr.idarkay.mod
 * Mod_1_17 is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 31/10/2020 at 18:12
 */
public class Mod_1_17 implements ModInitializer
{




    static {
        Blocks_1_17.force();
        Items_1_17.force();
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_1_17.AMETHYST_CRYSTAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_1_17.BLACK_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_1_17.WHITE_CANDLE, RenderLayer.getCutout());
        ((Block) null) instanceof FallingBlock
    }


    @Override
    public void onInitialize()
    {
        force();
    }

    public static boolean force()
    {
        return true;
    }




}
