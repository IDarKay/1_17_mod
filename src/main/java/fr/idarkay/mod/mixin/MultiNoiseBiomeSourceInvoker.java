package fr.idarkay.mod.mixin;


import com.mojang.datafixers.util.Pair;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * File <b>PresetMixin</b> located on fr.idarkay.mod.mixin
 * PresetMixin is a part of 1_17_mod.
 * <p>
 * Copyright (c) 2020 1_17_mod.
 * <p>
 *
 * @author alice. B. (IDarKay),
 * Created the 01/11/2020 at 14:34
 */
@Mixin(MultiNoiseBiomeSource.class)
public interface MultiNoiseBiomeSourceInvoker
{

//    private  void aFunc (long seed, List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomePoints, Optional<Pair<Registry<Biome>, MultiNoiseBiomeSource.Preset>> instance)
//    {
//        new MultiNoiseBiomeSource(seed, biomePoints, instance);
//    }



    @Invoker("<init>")
    public static MultiNoiseBiomeSource invokeMultiNoiseBiomeSource(long seed, List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomePoints, Optional<Pair<Registry<Biome>, MultiNoiseBiomeSource.Preset>> instance)
    {
        throw new AssertionError();
    }

}
