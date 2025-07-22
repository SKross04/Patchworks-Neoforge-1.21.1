package net.skross.patchworks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.block.ModBlocks;
import net.skross.patchworks.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvidor extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvidor(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> RECALLITE_SMELTABLES = List.of(
                ModBlocks.RECALLITE_ORE, ModBlocks.DEEPSLATE_RECALLITE_ORE);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_GEM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_GEM.get())
                .unlockedBy("has_black_gem", has(ModItems.BLACK_GEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RECALLITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RECALLITE.get())
                .unlockedBy("has_recallite", has(ModItems.RECALLITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RECALLITE_KNIFE.get())
                .pattern("D")
                .pattern("A")
                .pattern("C")
                .define('A', ModItems.RECALLITE.get())
                .define('C', Items.STICK)
                .define('D', Items.IRON_INGOT)
                .unlockedBy("has_recallite", has(ModItems.RECALLITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_GEM.get(),9)
                .requires(ModBlocks.BLACK_GEM_BLOCK.get())
                .unlockedBy("has_black_gem_block", has(ModBlocks.BLACK_GEM_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RECALLITE.get(),9)
                .requires(ModBlocks.RECALLITE_BLOCK.get())
                .unlockedBy("has_black_gem_block", has(ModBlocks.RECALLITE_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, RECALLITE_SMELTABLES, RecipeCategory.MISC, ModItems.RECALLITE.get(),0.25f,200,"recallite");
        oreBlasting(pRecipeOutput, RECALLITE_SMELTABLES, RecipeCategory.MISC, ModItems.RECALLITE.get(),0.25f,200,"recallite");


    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, Patchworks.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }


}


