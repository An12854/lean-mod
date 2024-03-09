package com.an12854.leanmod.item;

import com.an12854.leanmod.potion.ModPotions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LEAN_TAB = new CreativeModeTab("leantab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.LEAN_BUCKET.get());}
    };
}
