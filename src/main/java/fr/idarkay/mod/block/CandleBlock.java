package fr.idarkay.mod.block;

import fr.idarkay.mod.state.Properties;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

/**
 * File <b>CandleBlock</b> located on fr.idarkay.mod.block
 * CandleBlock is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 04/11/2020 at 17:47
 */
public class CandleBlock extends Block
{
    
    public static final IntProperty CANDLE = Properties.CANDLE;
    
    protected static final VoxelShape ONE_CANDLE_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 6.0D, 10.0D);
    protected static final VoxelShape TWO_CANDLE_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D);
    protected static final VoxelShape THREE_CANDLE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final VoxelShape FOUR_CANDLE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);
    private static final ParticleEffect particle = ParticleTypes.FLAME;

    public CandleBlock(Settings settings)
    {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(CANDLE, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(CANDLE);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().getItem() == this.asItem() && (Integer)state.get(CANDLE) < 4 ? true : super.canReplace(state, context);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this))
            return (BlockState)blockState.with(CANDLE, Math.min(4, (Integer)blockState.get(CANDLE) + 1));
        else
            return this.getDefaultState();
    }
    
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(CANDLE)) {
            case 1:
            default:
                return ONE_CANDLE_SHAPE;
            case 2:
                return TWO_CANDLE_SHAPE;
            case 3:
                return THREE_CANDLE_SHAPE;
            case 4:
                return FOUR_CANDLE_SHAPE;
        }
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        //todo change for CANDLE
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D;
        double f = (double)pos.getZ() + 0.5D;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(this.particle, d, e, f, 0.0D, 0.0D, 0.0D);
    }
    
}
