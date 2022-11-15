package com.an12854.leanmod.item;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.ModBlocks;
import com.an12854.leanmod.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Leanmod.MODID);
    public static final RegistryObject<Item> LEAN_BUCKET = ITEMS.register("lean_bucket",
            () -> new BucketItem(ModFluids.SOURCE_LEAN_WATER,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
