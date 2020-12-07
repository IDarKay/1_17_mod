package fr.idarkay.mod.mixin;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.idarkay.mod.world.WorldUtils;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;

/**
 * File <b>PresetMixin</b> located on fr.idarkay.mod.mixin
 * PresetMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 15:55
 */
@Mixin(MultiNoiseBiomeSource.Preset.class)
public class PresetMixin
{

    @Mutable
    @Shadow
    @Final
    public static final MultiNoiseBiomeSource.Preset NETHER;

    static {
        NETHER = new MultiNoiseBiomeSource.Preset(
                new Identifier("nether"),
                (preset, registry, long_) -> MultiNoiseBiomeSourceInvoker.invokeMultiNoiseBiomeSource(long_,
                        ImmutableList.of(
                                Pair.of(WorldUtils.createFullMixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0, 60),
                                        () -> registry.getOrThrow(BiomeKeys.NETHER_WASTES)),
                                Pair.of(WorldUtils.createFullMixedNoisePoint(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0, 60),
                                        () -> registry.getOrThrow(BiomeKeys.SOUL_SAND_VALLEY)),
                                Pair.of(WorldUtils.createFullMixedNoisePoint(0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 70,255),
                                        () -> registry.getOrThrow(BiomeKeys.CRIMSON_FOREST)),
                                Pair.of(WorldUtils.createFullMixedNoisePoint(0.0F, 0.5F, 0.5F, 0.0F, 0.375F,60 ,255),
                                        () -> registry.getOrThrow(BiomeKeys.WARPED_FOREST)),
                                Pair.of(WorldUtils.createFullMixedNoisePoint(-0.5F, 0.0F, 0.0F, 0.0F, 0.175F,0 ,60),
                                        () -> registry.getOrThrow(BiomeKeys.BASALT_DELTAS))
                        ),
                        Optional.of(Pair.of(registry, preset))));
    }

}
