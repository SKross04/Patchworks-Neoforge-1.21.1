package net.skross.patchworks.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodProperties MACARON = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodProperties COOKED_PIGEON = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodProperties PIGEON = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).effect(() -> new MobEffectInstance(MobEffects.HUNGER,600),0.3f).build();






}
