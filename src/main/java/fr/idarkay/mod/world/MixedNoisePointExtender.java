package fr.idarkay.mod.world;

/**
 * File <b>MixedNoisePointExtender</b> located on fr.idarkay.mod.world
 * MixedNoisePointExtender is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 18:21
 */
public interface MixedNoisePointExtender
{
    int getMinY();

    int getMaxY();

    void setYaxis(int minY, int maxY);

}
