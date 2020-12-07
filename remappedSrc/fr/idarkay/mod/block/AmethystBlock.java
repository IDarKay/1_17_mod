package fr.idarkay.mod.block;

import fr.idarkay.mod.Mod_1_17;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

/**
 * File <b>AmethystBlock</b> located on fr.idarkay.mod.block
 * AmethystBlock is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 31/10/2020 at 18:51
 */
public class AmethystBlock extends Block
{
    public AmethystBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        if(world.isAir(pos.up()) &&  random.nextDouble() <= 0.01)
        {
            world.setBlockState(pos.up(), Mod_1_17.AMETHYST_CRYSTAL.getDefaultState());
        }
    }
}
