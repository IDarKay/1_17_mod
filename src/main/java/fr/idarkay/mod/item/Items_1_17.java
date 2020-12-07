package fr.idarkay.mod.item;

import fr.idarkay.mod.block.Blocks_1_17;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

/**
 * File <b>Items_1_17</b> located on fr.idarkay.mod.item
 * Items_1_17 is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 04/11/2020 at 18:03
 */
public class Items_1_17
{
    public static final Item AMETHYST_BLOCK = register(Blocks_1_17.AMETHYST_BLOCK, ItemGroup.BUILDING_BLOCKS);
    public static final Item AMETHYST_CRYSTAL = register(Blocks_1_17.AMETHYST_CRYSTAL, ItemGroup.BUILDING_BLOCKS);
    public static final Item TELESCOPE = register("telescope", new Telescope(
            new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.RARE).maxCount(1)
    ));
    public static final Item WHITE_CANDLE = register(Blocks_1_17.WHITE_CANDLE, ItemGroup.DECORATIONS);
    public static final Item BLACK_CANDLE = register(Blocks_1_17.BLACK_CANDLE, ItemGroup.DECORATIONS);

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

    public static boolean force()
    {
        return true;
    }

}
