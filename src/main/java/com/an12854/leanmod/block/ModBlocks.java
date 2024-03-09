package com.an12854.leanmod.block;

import com.an12854.leanmod.Leanmod;
import com.an12854.leanmod.block.entity.ModWoodTypes;
import com.an12854.leanmod.fluid.ModFluids;
import com.an12854.leanmod.item.ModCreativeModeTab;
import com.an12854.leanmod.item.ModItems;
import com.an12854.leanmod.block.custom.*;
import com.an12854.leanmod.world.feature.tree.LeanTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.BlockGetter;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Leanmod.MODID);
    public static final RegistryObject<LiquidBlock> LEAN_WATER_BLOCK = BLOCKS.register("lean_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_LEAN_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> LEAN_LOG = registerBlock("lean_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.LEAN_TAB);
    public static final RegistryObject<Block> LEAN_WOOD = registerBlock("lean_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.LEAN_TAB);
    public static final RegistryObject<Block> STRIPPED_LEAN_LOG = registerBlock("stripped_lean_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.LEAN_TAB);
    public static final RegistryObject<Block> STRIPPED_LEAN_WOOD = registerBlock("stripped_lean_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_PLANKS = registerBlock("lean_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.LEAN_TAB);
    public static final RegistryObject<Block> LEAN_LEAVES = registerBlock("lean_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }


                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }


                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.LEAN_TAB);

    //Idc if it's deprecated, problem for future me
    public static final RegistryObject<Block> LEAN_STAIRS = registerBlock("lean_stairs",
            () -> new StairBlock(LEAN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)) , ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_SLAB = registerBlock("lean_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)) , ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_BUTTON = registerBlock("lean_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)) , ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_FENCE = registerBlock("lean_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_FENCE_GATE = registerBlock("lean_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_PRESSURE_PLATE = registerBlock("lean_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.LEAN_TAB);

    public static final RegistryObject<Block> LEAN_SIGN = registerBlockWithoutBlockItem("lean_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.LEAN));

    public static final RegistryObject<Block> LEAN_WALL_SIGN = registerBlockWithoutBlockItem("lean_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LEAN));

    public static final RegistryObject<Block> LEAN_SAPLING = registerBlock("lean_sapling",
            () -> new SaplingBlock(new LeanTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.LEAN_TAB);

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
