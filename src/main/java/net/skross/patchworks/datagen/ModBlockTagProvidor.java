package net.skross.patchworks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvidor extends BlockTagsProvider {
    public ModBlockTagProvidor(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Patchworks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLACK_GEM_BLOCK.get())
                .add(ModBlocks.RECALLITE_BLOCK.get())
                .add(ModBlocks.RECALLITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_RECALLITE_ORE.get());
    this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACK_GEM_BLOCK.get())
                .add(ModBlocks.RECALLITE_BLOCK.get())
                .add(ModBlocks.RECALLITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_RECALLITE_ORE.get());
    }
}
