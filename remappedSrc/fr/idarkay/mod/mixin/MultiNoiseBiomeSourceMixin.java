package fr.idarkay.mod.mixin;

import com.mojang.datafixers.util.Pair;
import fr.idarkay.mod.world.MixedNoisePointExtender;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * File <b>MultiNoiseBiomeSourceMixin</b> located on fr.idarkay.mod.mixin
 * MultiNoiseBiomeSourceMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 16:50
 */
@Mixin(MultiNoiseBiomeSource.class)
public class MultiNoiseBiomeSourceMixin
{

    @Mutable
    @Shadow @Final private boolean threeDimensionalSampling;

    @Shadow @Final private List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomePoints;

    @Shadow @Final private DoublePerlinNoiseSampler temperatureNoise;

    @Shadow @Final private DoublePerlinNoiseSampler humidityNoise;

    @Shadow @Final private DoublePerlinNoiseSampler altitudeNoise;

    @Shadow @Final private DoublePerlinNoiseSampler weirdnessNoise;

    @Inject(at = @At("RETURN"), method = "<init>(JLjava/util/List;Ljava/util/Optional;)V")
    public void init(long seed, List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomePoints, Optional<Pair<Registry<Biome>, MultiNoiseBiomeSource.Preset>> instance, CallbackInfo ci)
    {
        this.threeDimensionalSampling = true;
    }

    /**
     * @author ME
     * @reason me
     */
    @Overwrite()
    public Biome getBiomeForNoiseGen(int biomeX,int biomeY, int biomeZ)
    {
        System.out.println(biomeY);
        Biome.MixedNoisePoint mixedNoisePoint = new Biome.MixedNoisePoint((float)this.temperatureNoise.sample((double)biomeX, (double) biomeY, (double)biomeZ), (float)this.humidityNoise.sample((double)biomeX, (double) biomeY, (double)biomeZ), (float)this.altitudeNoise.sample((double)biomeX, (double) biomeY, (double)biomeZ), (float)this.weirdnessNoise.sample((double)biomeX, (double) biomeY, (double)biomeZ), 0.0F);
        return this.biomePoints.stream()
                .filter(b -> checkY(b.getFirst(), biomeY))
                .min(Comparator.comparing((pair) -> pair.getFirst().calculateDistanceTo(mixedNoisePoint)))
                .map(Pair::getSecond).map(Supplier::get)
                .orElse(BuiltinBiomes.THE_VOID);
    }

    private boolean checkY(Biome.MixedNoisePoint point, int biomeY)
    {
        return  ((MixedNoisePointExtender) point).getMinY() <= biomeY &&  ((MixedNoisePointExtender) point).getMaxY() >= biomeY;
    }

}
