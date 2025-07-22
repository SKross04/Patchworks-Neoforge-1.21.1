package net.skross.patchworks.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skross.patchworks.Patchworks;
import net.skross.patchworks.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Patchworks.MOD_ID);

    public static final DeferredItem<Item> BLACK_GEM = ITEMS.registerSimpleItem("black_gem");
    public static final DeferredItem<Item> BLACK_FEATHER = ITEMS.registerSimpleItem("black_feather");
    public static final DeferredItem<Item> RECALLITE = ITEMS.registerSimpleItem("recallite");

    public static final DeferredItem<Item> MACARON =
            ITEMS.registerItem("macaron", Item::new, new Item.Properties().food(ModFoodProperties.MACARON));
    public static final DeferredItem<Item> PIGEON =
            ITEMS.registerItem("pigeon", Item::new, new Item.Properties().food(ModFoodProperties.PIGEON));
    public static final DeferredItem<Item> COOKED_PIGEON =
            ITEMS.registerItem("cooked_pigeon", Item::new, new Item.Properties().food(ModFoodProperties.COOKED_PIGEON));

    public static final DeferredItem<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties()));

    public static final DeferredItem<Item> RECALLITE_KNIFE = ITEMS.register("recallite_knife",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON,3,-1.8f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
