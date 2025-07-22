package net.skross.patchworks.datagen;

import com.llamalad7.mixinextras.lib.apache.commons.ObjectUtils;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.skross.patchworks.block.ModBlocks;
import net.skross.patchworks.block.custom.BlueberryBushBlock;
import net.skross.patchworks.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvidor extends BlockLootSubProvider {
    protected ModBlockLootTableProvidor(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RECALLITE_BLOCK.get());
        dropSelf(ModBlocks.BLACK_GEM_BLOCK.get());

        this.add(ModBlocks.RECALLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.RECALLITE_ORE.get(), ModItems.RECALLITE.get()));
        this.add(ModBlocks.DEEPSLATE_RECALLITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_RECALLITE_ORE.get(), ModItems.RECALLITE.get()));

        LootItemCondition lootItemCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlueberryBushBlock.AGE, 3)).build();
        this.add(ModBlocks.BLUEBERRY_BUSH.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                .when((LootItemCondition.Builder) lootItemCondition).add(LootItem.lootTableItem(ModItems.BLUEBERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
