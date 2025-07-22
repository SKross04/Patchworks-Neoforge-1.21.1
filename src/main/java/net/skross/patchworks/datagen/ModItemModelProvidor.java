package net.skross.patchworks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.item.ModItems;

public class ModItemModelProvidor extends ItemModelProvider {
    public ModItemModelProvidor(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Patchworks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RECALLITE.get());
        basicItem(ModItems.BLACK_GEM.get());
        basicItem(ModItems.BLACK_FEATHER.get());
        basicItem(ModItems.BLUEBERRY.get());
        basicItem(ModItems.MACARON.get());
        basicItem(ModItems.PIGEON.get());
        basicItem(ModItems.COOKED_PIGEON.get());

        handheldItem(ModItems.RECALLITE_KNIFE);
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Patchworks.MOD_ID,"item/" + item.getId().getPath()));
    }
}
