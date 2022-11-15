package com.an12854.leanmod.fluid;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.ModBlocks;
import com.an12854.leanmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Leanmod.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_LEAN_WATER = FLUIDS.register("lean_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.LEAN_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LEAN_WATER = FLUIDS.register("flowing_lean",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.LEAN_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LEAN_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.LEAN_FLUID_TYPE, SOURCE_LEAN_WATER, FLOWING_LEAN_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.LEAN_WATER_BLOCK)
            .bucket(ModItems.LEAN_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
