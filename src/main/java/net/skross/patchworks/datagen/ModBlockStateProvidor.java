package net.skross.patchworks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.block.ModBlocks;
import net.skross.patchworks.block.custom.BlueberryBushBlock;

public class ModBlockStateProvidor extends BlockStateProvider {
    public ModBlockStateProvidor(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Patchworks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RECALLITE_BLOCK);
        blockWithItem(ModBlocks.BLACK_GEM_BLOCK);
        blockWithItem(ModBlocks.RECALLITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RECALLITE_ORE);

        getVariantBuilder(ModBlocks.BLUEBERRY_BUSH.get())
                .partialState().with(BlueberryBushBlock.AGE, 0)
                .modelForState().modelFile(models().cross("blueberry_bush_stage0", modLoc("block/blueberry_bush_stage0"))).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 1)
                .modelForState().modelFile(models().cross("blueberry_bush_stage1", modLoc("block/blueberry_bush_stage1"))).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 2)
                .modelForState().modelFile(models().cross("blueberry_bush_stage2", modLoc("block/blueberry_bush_stage2"))).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 3)
                .modelForState().modelFile(models().cross("blueberry_bush_stage3", modLoc("block/blueberry_bush_stage3"))).addModel();
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }


}
