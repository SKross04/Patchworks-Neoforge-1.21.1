package net.skross.patchworks.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Patchworks.MOD_ID);

    public static final Supplier<CreativeModeTab> RAVEN_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("raven_items_tab",() -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.patchworks.raven_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_FEATHER.get()))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_FEATHER);
                        pOutput.accept(ModItems.BLACK_GEM);
                        pOutput.accept(ModBlocks.BLACK_GEM_BLOCK);

                    }).build());
    public static final Supplier<CreativeModeTab> RECALLITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("recallite_items_tab",() -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.patchworks.recallite_items_tab"))
                    .icon(() -> new ItemStack(ModItems.RECALLITE.get()))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.RECALLITE);
                        pOutput.accept(ModBlocks.RECALLITE_BLOCK);
                        pOutput.accept(ModBlocks.RECALLITE_ORE);
                        pOutput.accept(ModBlocks.DEEPSLATE_RECALLITE_ORE);
                        pOutput.accept(ModItems.RECALLITE_KNIFE);

                    }).build());
    public static final Supplier<CreativeModeTab> FOOD_PET_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("food_pet_items_tab",() -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.patchworks.food_pet_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLUEBERRY.get()))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLUEBERRY);
                        pOutput.accept(ModItems.MACARON);


                    }).build());
    public static final Supplier<CreativeModeTab> POSTAL_PIGEON_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("postal_pigeon_items_tab",() -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.patchworks.postal_pigeon_items_tab"))
                    .icon(() -> new ItemStack(ModItems.PIGEON.get()))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.PIGEON);
                        pOutput.accept(ModItems.COOKED_PIGEON);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
