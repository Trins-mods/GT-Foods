package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.blocks.BlockCropWaterlogged;
import trinsdar.gt_foods.items.ItemBerry;
import trinsdar.gt_foods.items.ItemFood;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GTFData {
    private static final Map<ResourceLocation, Block> blockIdList = new LinkedHashMap<>();

    public static final Block BLUEBERRY_BUSH =new BlockCropBerry("blueberry_bush", "blueberry");
    public static final Block GOOSEBERRY_BUSH = new BlockCropBerry("gooseberry_bush", "gooseberry");
    public static final Block BLACKBERRY_BUSH = new BlockCropBerry("blackberry_bush", "blackberry");
    public static final Block RASPBERRY_BUSH =new BlockCropBerry("raspberry_bush", "raspberry");
    public static final Block STRAWBERRY_BUSH = new BlockCropBerry("strawberry_bush", "strawberry");
    public static final Block CRANBERRY_CROP = new BlockCropWaterlogged("cranberry", "cranberry", 3);

    public static final Material StainlessSteel = AntimatterAPI.register(Material.class, new Material(Ref.ID, "stainless_steel", 0xc8c8dc, TextureSet.NONE)).flags(muramasa.antimatter.Data.RING, muramasa.antimatter.Data.ROD, muramasa.antimatter.Data.PLATE_TINY);

    public static final ItemBasic<?> SlicerBladeFrame = new ItemBasic<>(GTFoods.MODID, "slicer_blade_frame");
    public static final ItemBasic<?> FlatSlicerBlades = new ItemBasic<>(GTFoods.MODID, "flat_slicer_blades");
    public static final ItemBasic<?> GridSlicerBlades = new ItemBasic<>(GTFoods.MODID, "grid_slicer_blades");
    public static final ItemBasic<?> EigthsSlicerBlades = new ItemBasic<>(GTFoods.MODID, "eigths_slicer_blades");
    public static final ItemBasic<?> SplitSlicerBlades = new ItemBasic<>(GTFoods.MODID, "split_slicer_blades");
    public static final ItemBasic<?> HollowQuartersSlicerBlades = new ItemBasic<>(GTFoods.MODID, "hollow_quarters_slicer_blades");

    public static final Item BLUEBERRY = registerBerry("blueberry", BLUEBERRY_BUSH, 2, 0.3F);
    public static final Item GOOSEBERRY = registerBerry("gooseberry", GOOSEBERRY_BUSH, 2, 0.3F);
    public static final Item BLACKBERRY = registerBerry("blackberry", BLACKBERRY_BUSH, 2, 0.3F);
    public static final Item RASPBERRY = registerBerry("raspberry", RASPBERRY_BUSH, 2, 0.3F);
    public static final Item STRAWBERRY = registerBerry("strawberry", STRAWBERRY_BUSH, 2, 0.3F);
    public static final Item CRANBERRY = registerBerry("cranberry", CRANBERRY_CROP, 2, 0.3F);


    /** Food */
    public static final Item LEMON = registerFoodItem("lemon", 1, 0.3F);
    public static final Item LEMON_SLICE = registerFoodItem("lemon_slice", new Food.Builder().hunger(0).saturation(0.075F).fastToEat().build());
    public static final Item TOMATO = registerFoodItem("tomato", 1, 0.3F);
    public static final Item TOMATO_SLICE = registerFoodItem("tomato_slice", new Food.Builder().hunger(0).saturation(0.075F).fastToEat().build());
    public static final Item MAX_TOMATO = registerFoodItem("max_tomato", new Food.Builder().hunger(9).saturation(0.5F).effect(() -> new EffectInstance(Effects.REGENERATION, 2), 1.0F).build());
    public static final Item ONION = registerFoodItem("onion", 1, 0.6F);
    public static final Item ONION_SLICE = registerFoodItem("onion_slice", new Food.Builder().hunger(0).saturation(0.15F).fastToEat().build());
    public static final Item CUCUMBER = registerFoodItem("cucumber", 1, 0.6F);
    public static final Item CUCUMBER_SLICE = registerFoodItem("cucumber_slice", new Food.Builder().hunger(0).saturation(0.15F).fastToEat().build());
    public static final Item PICKLE = registerFoodItem("pickle", 1, 0.6F);
    public static final Item PICKLE_SLICE = registerFoodItem("pickle_slice", new Food.Builder().hunger(0).saturation(0.15F).fastToEat().build());
    public static final Item CHILI_PEPPER = registerFoodItem("chili_pepper", 1, 0.6F);
    public static final Item GREEN_GRAPES = registerFoodItem("green_grapes", 1, 0.3F);
    public static final Item GREEN_RAISINS = registerFoodItem("green_raisins", 2, 0.3F);
    public static final Item WHITE_GRAPES = registerFoodItem("white_grapes", 1, 0.3F);
    public static final Item WHITE_RAISINS = registerFoodItem("white_raisins", 2, 0.3F);
    public static final Item RED_GRAPES = registerFoodItem("red_grapes", 1, 0.3F);
    public static final Item RED_RAISINS = registerFoodItem("red_raisins", 2, 0.3F);
    public static final Item PURPLE_GRAPES = registerFoodItem("purple_grapes", 1, 0.3F);
    public static final Item PURPLE_RAISINS = registerFoodItem("purple_raisins", 2, 0.3F);
    public static final Item CHOCOLATE_RAISINS = registerFoodItem("chocolate_raisins", 3, 0.6F);
    public static final Item CARROT_SLICE = registerFoodItem("carrot_slice", new Food.Builder().hunger(0).saturation(0.15F).fastToEat().build());
    public static final Item BANANA = registerFoodItem("banana", 1, 0.3F);
    public static final Item BANANA_SLICE = registerFoodItem("banana_slice", new Food.Builder().hunger(0).saturation(0.075F).fastToEat().build());
    public static final Item POMEGRANATE = registerFoodItem("pomegranate", 1, 0.3F);
    public static final Item POMERAISINS = registerFoodItem("pomeraisins", 2, 0.3F);
    public static final Item CANDLEBERRY = registerFoodItem("candleberry", 1, 0.3F);
    public static final Item BLACK_CURRANTS = registerFoodItem("black_currants", 1, 0.3F);
    public static final Item RED_CURRANTS = registerFoodItem("red_currants", 1, 0.3F);
    public static final Item WHITE_CURRANTS = registerFoodItem("white_currants", 1, 0.3F);
    public static final Item APPLE_SLICE = registerFoodItem("apple_slice", 1, 0.15F);
    public static final Item PEANUT = registerFoodItem("peanut", 2, 0.15F);
    public static final Item HAZELNUT = registerFoodItem("hazelnut", 2, 0.15F);
    public static final Item PINEAPPLE = registerFoodItem("pineapple", 4, 0.15F);
    public static final Item PINEAPPLE_SLICE = registerFoodItem("pineapple_slice", new Food.Builder().hunger(1).saturation(0.15F).fastToEat().build());
    public static final Item CINNAMON_BARK = registerFoodItem("cinnamon_bark", 2, 0.15F);
    public static final Item COCONUT = registerFoodItem("coconut", 2, 0.15F);
    public static final Item CHEESE = registerFoodItem("cheese", 2, 0.6F);
    public static final Item CHEESE_SLICE = registerFoodItem("cheese_slice", 1, 0.3F);
    public static final Item BOILED_EGG = registerFoodItem("boiled_egg", 2, 0.6f);
    public static final Item FRIED_EGG = registerFoodItem("fried_egg", 2, 0.6F);
    public static final Item SCRAMBLED_EGG = registerFoodItem("scrambled_egg", 2, 0.6F);
    public static final Item SLICED_EGG = registerFoodItem("sliced_egg", 1, 0.3F);
    public static final Item EGG_YOLK = registerFoodItem("egg_yolk", 1, 0.6F);
    public static final Item EGG_WHITE = registerFoodItem("egg_white", 1, 0.6F);
    public static final Item RAW_HAM = registerMeatItem("raw_ham", 3, 0.3F);
    public static final Item COOKED_HAM = registerMeatItem("cooked_ham", 10, 0.8F);
    public static final Item RAW_HAM_SLICE = registerMeatItem("raw_ham_slice", 1, 0.3F);
    public static final Item COOKED_HAM_SLICE = registerMeatItem("cooked_ham_slice", 3, 0.8F);
    public static final Item RAW_BACON = registerMeatItem("raw_bacon", 1, 0.45F);
    public static final Item COOKED_BACON = registerMeatItem("cooked_bacon", 3, 0.9F);
    public static final Item RAW_RIBS = registerMeatItem("raw_ribs", 3, 0.3F);
    public static final Item GRILLED_RIBS = registerMeatItem("grilled_ribs", 10, 0.8F);
    public static final Item BARBECUE_RIBS = registerMeatItem("barbecue_ribs", 10, 0.8F);
    public static final Item RAW_RIB_EYE_STEAK = registerMeatItem("raw_rib_eye_steak", 3, 0.3F);
    public static final Item GRILLED_RIB_EYE_STEAK = registerMeatItem("grilled_rib_eye_steak", 10, 0.8F);
    public static final Item RAW_DOGMEAT = registerFoodItem("raw_dogmeat", 2, 0.3F);
    public static final Item GRILLED_DOGMEAT = registerFoodItem("grilled_dogmeat", 8, 0.8F);
    public static final Item RAW_HORSEMEAT = registerMeatItem("raw_horsemeat", 2, 0.3F);
    public static final Item GRILLED_HORSEMEAT = registerMeatItem("grilled_horsemeat", 8, 0.8F);
    public static final Item RAW_MULEMEAT = registerMeatItem("raw_mulemeat", 3, 0.4F);
    public static final Item GRILLED_MULEMEAT = registerMeatItem("grilled_mulemeat", 10, 0.9F);
    public static final Item RAW_DONKEYMEAT = registerMeatItem("raw_donkeymeat", 2, 0.3F);
    public static final Item GRILLED_DONKEYMEAT = registerMeatItem("grilled_donkeymeat", 8, 0.8F);
    public static final Item DOUGH = registerFoodItem("dough", 1, 0.5F);
    public static final Item SUGARY_DOUGH = registerFoodItem("sugary_dough", 1, 0.5F);
    public static final Item CHOCOLATE_DOUGH = registerFoodItem("chocolate_dough", 1, 0.5F);
    public static final Item EGG_DOUGH = registerFoodItem("egg_dough", 1, 0.5F);
    public static final Item SUGARY_RAISIN_DOUGH = registerFoodItem("sugary_raisin_dough", 1, 0.5F);
    public static final Item SUGARY_CHOCOLATE_RAISIN_DOUGH = registerFoodItem("sugary_chocolate_raisin_dough", 1, 0.5F);
    public static final Item COOKIE_SHAPED_DOUGH = registerFoodItem("cookie_shaped_dough", 1, 0.1F);
    public static final Item COOKIE_SHAPED_RAISIN_DOUGH = registerFoodItem("cookie_shaped_raisin_dough", 1, 0.1F);
    public static final Item COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH = registerFoodItem("cookie_shaped_chocolate_raisin_dough", 1, 0.1F);
    public static final Item RAW_CAKE_BOTTOM = registerFoodItem("raw_cake_bottom", 2, 0.1F);
    public static final Item CAKE_BOTTOM = registerFoodItem("cake_bottom", 3, 0.1F);
    public static final Item PIZZA_DOUGH = registerFoodItem("pizza_dough",1, 0.1F);
    public static final Item PIZZA_DOUGH_WITH_SAUCE = registerFoodItem("pizza_dough_with_sauce",1, 0.1F);
    public static final Item FLATTENED_PASTA_DOUGH = registerFoodItem("flattened_pasta_dough", 1, 0.3F);
    public static final Item BUN_DOUGH = registerFoodItem("bun_dough", 1, 0.3F);
    public static final Item BAGUETTE_DOUGH = registerFoodItem("baguette_dough", 1, 0.3F);
    public static final Item BREAD_DOUGH = registerFoodItem("bread_dough", 1, 0.3F);
    public static final Item TOFU_BAR = registerFoodItem("tofu_bar", 2, 0.7F);
    public static final Item SOYLENT_BAR = registerFoodItem("soylent_bar", 3, 0.7F);
    public static final Item CHOCOLATE_BAR = registerFoodItem("chocolate_bar", 4, 0.4F);
    public static final Item CHEESE_BAR = registerFoodItem("cheese_bar", 2, 0.6F);
    public static final Item BUTTER = registerFoodItem("butter", 1, 2.0F);
    public static final Item SALTED_BUTTER = registerFoodItem("salted_butter", 1, 2.0F);
    public static final Item RAISIN_COOKIE = registerFoodItem("raisin_cookie", 2, 0.1F);
    public static final Item CHOCOLATE_RAISIN_COOKIE = registerFoodItem("chocolate_raisin_cookie", 2, 0.1F);
    public static final Item RAW_MARGHERITA_PIZZA = registerFoodItem("raw_margherita_pizza", 2, 0.15F);
    public static final Item RAW_MINCEMEAT_PIZZA = registerFoodItem("raw_mincemeat_pizza", 2, 0.15F);
    public static final Item RAW_VEGGIE_PIZZA = registerFoodItem("raw_veggie_pizza", 1, 0.15F);
    public static final Item RAW_HAWAIIN_PIZZA = registerFoodItem("raw_hawaiin_pizza", 2, 0.15F);
    public static final Item MARGHERITA_PIZZA = registerFoodItem("margherita_pizza", 6, 0.6F);
    public static final Item MINCEMEAT_PIZZA = registerFoodItem("mincemeat_pizza", 7, 0.6F);
    public static final Item VEGGIE_PIZZA = registerFoodItem("veggie_pizza", 5, 0.6F);
    public static final Item HAWAIIN_PIZZA = registerFoodItem("hawaiin_pizza", 7, 0.6F);
    public static final Item BUN = registerFoodItem("bun", 2, 0.6F);
    public static final Item SLICED_BUN = registerFoodItem("sliced_bun", 1, 0.6F);
    public static final Item BUN_SLICES = registerFoodItem("bun_slices", 2, 0.6F);
    public static final Item VEGGIE_BURGER = registerFoodItem("veggie_burger", 4, 0.6F);
    public static final Item CHEESE_BURGER = registerFoodItem("cheese_burger", 4, 0.7F);
    public static final Item HAMBURGER = registerFoodItem("hamburger", 6, 0.8F);
    public static final Item TOFU_BURGER = registerFoodItem("tofu_burger", 4, 0.7F);
    public static final Item SOYLENT_BURGER = registerFoodItem("soylent_burger", 5, 0.7F);
    public static final Item FISH_BURGER = registerFoodItem("fish_burger", 6, 0.8F);
    public static final Item SLICED_BREAD = registerFoodItem("sliced_bread", 2, 0.6F);
    public static final Item BREAD_SLICES = registerFoodItem("bread_slices", 5, 0.6F);
    public static final Item VEGGIE_SANDWICH = registerFoodItem("veggie_sandwich", 7, 0.6F);
    public static final Item CHEESE_SANDWICH = registerFoodItem("cheese_sandwich", 7, 0.7F);
    public static final Item BACON_SANDWICH = registerFoodItem("bacon_sandwich", 10, 0.9F);
    public static final Item STEAK_SANDWICH = registerFoodItem("steak_sandwich", 10, 0.8F);
    public static final Item BAGUETTE = registerFoodItem("baguette", 8, 0.6F);
    public static final Item SLICED_BAGUETTE = registerFoodItem("sliced_baguette", 4, 0.6F);
    public static final Item BAGUETTE_SLICES = registerFoodItem("baguette_slices", 8, 0.6F);
    public static final Item LARGE_VEGGIE_SANDWICH = registerFoodItem("large_veggie_sandwich", 15, 1.1F);
    public static final Item LARGE_CHEESE_SANDWICH = registerFoodItem("large_cheese_sandwich", 15, 1.2F);
    public static final Item LARGE_BACON_SANDWICH = registerFoodItem("large_bacon_sandwich", 20, 1.4F);
    public static final Item LARGE_STEAK_SANDWICH = registerFoodItem("large_steak_sandwich", 20, 1.3F);
    public static final Item RAW_FRIES = registerFoodItem("raw_fries", 1, 0.6F);
    public static final Item FRIES = registerFoodItem("fries", 7, 0.6F);
    public static final Item RAW_POTATO_CHIPS = registerFoodItem("raw_potato_chips", 1, 0.6F);
    public static final Item POTATO_CHIPS = registerFoodItem("potato_chips", 7, 0.6F);
    public static final Item CHILI_CHIPS = registerFoodItem("chili_chips", 7, 0.6F);
    //todo icecream and juice

    /** Food ingredients*/
    public static final Item TOMATO_SAUCE = registerIngredient("tomato_sauce");

    static Item registerFoodItem(String id, int hunger, float saturation) {
        return registerFoodItem(id, new Food.Builder().hunger(hunger).saturation(saturation).build());
    }

    static Item registerFoodItem(String id, Food food) {
        return new ItemFood(GTFoods.MODID, id, new Item.Properties().group(GTFoods.CREATIVE_TAB).food(food));
    }

    static Item registerMeatItem(String id, int hunger, float saturation) {
        return registerFoodItem(id, new Food.Builder().hunger(hunger).saturation(saturation).meat().build());
    }

    static BlockNamedItem registerBerry(String id, Block block, int hunger, float saturation) {
        return new ItemBerry(GTFoods.MODID, id, block, new Item.Properties().group(GTFoods.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).fastToEat().build()));
    }

    static Item registerIngredient(String id){
        return new ItemBasic<>(GTFoods.MODID, id, new Item.Properties().group(GTFoods.CREATIVE_TAB));
    }

    public static void init(){

    }
}
