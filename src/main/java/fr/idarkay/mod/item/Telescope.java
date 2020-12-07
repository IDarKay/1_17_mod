package fr.idarkay.mod.item;

import fr.idarkay.mod.client.render.TelescopeRender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * File <b>Telescope</b> located on fr.idarkay.mod.item
 * Telescope is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 31/10/2020 at 19:34
 */
public class Telescope extends Item
{

    private static Long coolDOwn  = System.currentTimeMillis();



    public Telescope(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        long l = System.currentTimeMillis();
        if(l - coolDOwn > 5)
        {
            coolDOwn = l;
            TelescopeRender.switchStatus();
        }

        return super.use(world, user, hand);
    }
}
