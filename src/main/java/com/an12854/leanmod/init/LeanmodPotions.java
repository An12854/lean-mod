package com.an12854.leanmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.an12854.leanmod.Leanmod;
public class LeanmodPotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, Leanmod.MODID);
    public static final RegistryObject<Potion> LEAN = REGISTRY.register("lean",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.CONFUSION, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.BLINDNESS, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.WEAKNESS, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.HUNGER, 9600, 4, false, true)));
}
