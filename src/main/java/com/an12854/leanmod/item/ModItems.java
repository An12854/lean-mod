package com.an12854.leanmod.item;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.ModBlocks;
import com.an12854.leanmod.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
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
                    new Item.Properties().tab(ModCreativeModeTab.LEAN_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> LEAN_SIGN = ITEMS.register("lean_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.LEAN_TAB).stacksTo(16), ModBlocks.LEAN_SIGN.get(), ModBlocks.LEAN_WALL_SIGN.get()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
