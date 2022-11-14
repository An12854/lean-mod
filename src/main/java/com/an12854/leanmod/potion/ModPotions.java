package com.an12854.leanmod.potion;

import com.an12854.leanmod.Leanmod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Leanmod.MODID);

    public static final RegistryObject<Potion> LEAN_POTION = POTIONS.register("lean_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.CONFUSION, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.BLINDNESS, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.WEAKNESS, 9600, 4, false, true),
                    new MobEffectInstance(MobEffects.HUNGER, 9600, 4, false, true)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
