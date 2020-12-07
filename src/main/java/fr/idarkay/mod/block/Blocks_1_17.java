package fr.idarkay.mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

/**
 * File <b>Block_1_17</b> located on fr.idarkay.mod.block
 * Blocks_1_17 is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 04/11/2020 at 18:01
 */
public class Blocks_1_17
{
    public static final Material CRYSTAL = new Material(MaterialColor.PURPLE, false, false, true, false, false, false, PistonBehavior.NORMAL);
    public static final Block AMETHYST_BLOCK = register("amethyst_block",  new AmethystBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.PURPLE).requiresTool().ticksRandomly().strength(1.5F, 6.0F)));
    public static final Block AMETHYST_CRYSTAL = register( "amethyst_crystal",  new AmethystCrystal(AbstractBlock.Settings.of(Material.PLANT, MaterialColor.PURPLE).nonOpaque().requiresTool().strength(1.5F, 6.0F)));
    public static final Block WHITE_CANDLE = register("white_candle", new CandleBlock(
            AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().nonOpaque().breakInstantly()
                    .luminance((state) -> 3 + 3 * state.get(CandleBlock.CANDLE))
    ));
    public static final Block BLACK_CANDLE = register("black_candle", new CandleBlock(
            AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().nonOpaque().breakInstantly()
                    .luminance((state) -> 3 + 3 * state.get(CandleBlock.CANDLE))
    ));

    private static Block register( @NotNull String id, @NotNull Block item)
    {
        return Registry.register(Registry.BLOCK, new Identifier("mod_1_17", id), item);
    }

    public static boolean force()
    {
        return true;
    }

}
