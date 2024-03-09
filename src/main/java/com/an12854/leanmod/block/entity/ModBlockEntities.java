package com.an12854.leanmod.block.entity;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.ModBlocks;
import com.an12854.leanmod.block.entity.custom.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Leanmod.MODID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.LEAN_WALL_SIGN.get(),
                            ModBlocks.LEAN_SIGN.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
