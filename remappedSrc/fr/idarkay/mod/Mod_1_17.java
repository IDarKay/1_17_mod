package fr.idarkay.mod;

import fr.idarkay.mod.block.AmethystBlock;
import fr.idarkay.mod.block.AmethystCrystal;
import fr.idarkay.mod.item.Telescope;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

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

    public static final Material CRYSTAL = new Material(MaterialColor.PURPLE, false, false, true, false, false, false, PistonBehavior.NORMAL);
    public static final Block AMETHYST_BLOCK = register(Registry.BLOCK, "amethyst_block",  new AmethystBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.PURPLE).requiresTool().ticksRandomly().strength(1.5F, 6.0F)));
    public static final Block AMETHYST_CRYSTAL = register(Registry.BLOCK, "amethyst_crystal",  new AmethystCrystal(AbstractBlock.Settings.of(Material.PLANT, MaterialColor.PURPLE).nonOpaque().requiresTool().strength(1.5F, 6.0F)));

    public static final Item AMETHYST_BLOCK_ITEM = register(AMETHYST_BLOCK, ItemGroup.BUILDING_BLOCKS);
    public static final Item AMETHYST_CRYSTAL_ITEM = register(AMETHYST_CRYSTAL, ItemGroup.BUILDING_BLOCKS);
    public static final Item TELESCOPE = register("telescope", new Telescope(
            new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.RARE).maxCount(1)
    ));

    static {
        BlockRenderLayerMap.INSTANCE.putBlock(AMETHYST_CRYSTAL, RenderLayer.getCutout());
    }


    @Override
    public void onInitialize()
    {

    }

    private static <T> T register(@NotNull Registry<T> registry, @NotNull String id, @NotNull T item)
    {
        return Registry.register(registry, new Identifier("mod_1_17", id), item);
    }


    private static Item register(Block block, ItemGroup group) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)));
    }

    private static Item register(BlockItem item) {
        return register((Block)item.getBlock(), (Item)item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return register(new Identifier("mod_1_17", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registry.ITEM, (Identifier)id, item);
    }

}
