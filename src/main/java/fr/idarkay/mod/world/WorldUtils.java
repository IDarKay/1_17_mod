package fr.idarkay.mod.world;

import net.minecraft.world.biome.Biome;

/**
 * File <b>WordlUtils</b> located on fr.idarkay.mod.world
 * WordlUtils is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 18:26
 */
public class WorldUtils
{

    public static Biome.MixedNoisePoint createFullMixedNoisePoint(float temperature, float humidity, float altitude, float weirdness, float weight, int minY, int maxY)
    {
        Biome.MixedNoisePoint mixedNoisePoint = new Biome.MixedNoisePoint(temperature, humidity, 0, weirdness, weight);
        ((MixedNoisePointExtender) mixedNoisePoint).setYaxis(minY, maxY);
        return mixedNoisePoint;
    }

}
