package com.an12854.leanmod.world.feature;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Leanmod.MODID);


    public static final RegistryObject<PlacedFeature> LEAN_CHECKED = PLACED_FEATURES.register("lean_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.LEAN.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.LEAN_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> LEAN_PLACED = PLACED_FEATURES.register("lean_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LEAN_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}