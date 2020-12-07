package fr.idarkay.mod.mixin;

import fr.idarkay.mod.world.MixedNoisePointExtender;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * File <b>MixedNoisePointMixin</b> located on fr.idarkay.mod.mixin
 * MixedNoisePointMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 18:08
 */
@Mixin(Biome.MixedNoisePoint.class)
public class MixedNoisePointMixin implements MixedNoisePointExtender
{

    public int minY = 0;

    public int maxY = 255;

    @Override
    public int getMinY()
    {
        return minY;
    }

    @Override
    public int getMaxY()
    {
        return maxY;
    }

    @Override
    public void setYaxis(int minY, int maxY)
    {
        this.maxY = (int) (maxY / 4.0d);
        this.minY = (int) (minY / 4.0d);
    }
}
