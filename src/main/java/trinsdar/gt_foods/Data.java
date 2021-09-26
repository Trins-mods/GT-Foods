package trinsdar.gt_foods;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.blocks.BlockCropWaterlogged;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    private static final Map<ResourceLocation, Item> itemIdList = new LinkedHashMap<>();
    private static final Map<ResourceLocation, Block> blockIdList = new LinkedHashMap<>();

    public static final Block BLUEBERRY_BUSH = registerBlock("blueberry_bush", new BlockCropBerry());
    public static final Block GOOSEBERRY_BUSH = registerBlock("gooseberry_bush", new BlockCropBerry());
    public static final Block BLACKBERRY_BUSH = registerBlock("blackberry_bush", new BlockCropBerry());
    public static final Block RASPBERRY_BUSH = registerBlock("raspberry_bush", new BlockCropBerry());
    public static final Block STRAWBERRY_BUSH = registerBlock("strawberry_bush", new BlockCropBerry());
    public static final Block CRANBERRY_CROP = registerBlock("cranberry_crop", new BlockCropWaterlogged());

    public static final Item BLUEBERRY = registerBerry("blueberry", BLUEBERRY_BUSH, 2, 0.6F);
    public static final Item GOOSEBERRY = registerBerry("gooseberry", GOOSEBERRY_BUSH, 2, 0.6F);
    public static final Item BLACKBERRY = registerBerry("blackberry", BLACKBERRY_BUSH, 2, 0.6F);
    public static final Item RASPBERRY = registerBerry("raspberry", RASPBERRY_BUSH, 2, 0.6F);
    public static final Item STRAWBERRY = registerBerry("strawberry", STRAWBERRY_BUSH, 2, 0.6F);
    public static final Item CRANBERRY = registerBerry("cranberry", CRANBERRY_CROP, 2, 0.6F);

    public static final Item LEMON = registerFoodItem("lemon", 1, 0.6F);
    public static final Item LEMON_SLICE = registerFoodItem("lemon_slice", 0, 0.15F);
    public static final Item TOMATO = registerFoodItem("tomato", 1, 0.6F);
    public static final Item TOMATO_SLICE = registerFoodItem("tomato_slice", 0, 0.15F);
    public static final Item MAX_TOMATO = registerFoodItem("max_tomato", 9, 1.0F);
    public static final Item ONION = registerFoodItem("onion", 1, 1.2F);
    public static final Item ONION_SLICE = registerFoodItem("onion_slice", 0, 0.3F);
    public static final Item CUCUMBER = registerFoodItem("cucumber", 1, 1.2F);
    public static final Item CUCUMBER_SLICE = registerFoodItem("cucumber_slice", 0, 0.3F);
    public static final Item CHILI_PEPPER = registerFoodItem("chili_pepper", 1, 1.2F);
    public static final Item GREEN_GRAPES = registerFoodItem("green_grapes", 1, 0.6F);
    public static final Item GREEN_RAISINS = registerFoodItem("green_raisins", 2, 0.6F);
    public static final Item WHITE_GRAPES = registerFoodItem("white_grapes", 1, 0.6F);
    public static final Item WHITE_RAISINS = registerFoodItem("white_raisins", 2, 0.6F);
    public static final Item RED_GRAPES = registerFoodItem("red_grapes", 1, 0.6F);
    public static final Item RED_RAISINS = registerFoodItem("red_raisins", 2, 0.6F);
    public static final Item PURPLE_GRAPES = registerFoodItem("purple_grapes", 1, 0.6F);
    public static final Item PURPLE_RAISINS = registerFoodItem("purple_raisins", 2, 0.6F);
    public static final Item CHOCOLATE_RAISINS = registerFoodItem("chocolate_raisins", 3, 1.2F);
    public static final Item CARROT_SLICE = registerFoodItem("carrot_slice", 0, 0.3F);
    public static final Item BANANA = registerFoodItem("banana", 1, 0.6F);
    public static final Item BANANA_SLICE = registerFoodItem("banana_slice", 0, 0.15F);
    public static final Item POMEGRANATE = registerFoodItem("pomegranate", 1, 0.6F);
    public static final Item POMERAISINS = registerFoodItem("pomeraisins", 2, 0.6F);
    public static final Item CANDLEBERRY = registerFoodItem("candleberry", 1, 0.6F);
    public static final Item BLACK_CURRANTS = registerFoodItem("black_currants", 1, 0.6F);
    public static final Item RED_CURRANTS = registerFoodItem("red_currants", 1, 0.6F);
    public static final Item WHITE_CURRANTS = registerFoodItem("white_currants", 1, 0.6F);
    public static final Item APPLE_SLICE = registerFoodItem("apple_slice", 1, 0.3F);
    public static final Item PEANUT = registerFoodItem("peanut", 2, 0.3F);
    public static final Item HAZELNUT = registerFoodItem("hazelnut", 2, 0.3F);
    public static final Item PINEAPPLE = registerFoodItem("pineapple", 4, 0.3F);
    public static final Item PINEAPPLE_SLICE = registerFoodItem("pineapple_slice", 1, 0.3F);
    public static final Item CINNAMON_BARK = registerFoodItem("cinnamon_bark", 2, 0.3F);
    public static final Item CHEESE = registerFoodItem("cheese", 2, 1.2F);
    public static final Item CHEESE_SLICE = registerFoodItem("cheese_slice", 1, 0.6F);
    public static final Item RAW_HAM = registerFoodItem("raw_ham", 3, 0.6F);
    public static final Item COOKED_HAM = registerFoodItem("cooked_ham", 10, 1.6F);
    public static final Item RAW_HAM_SLICE = registerFoodItem("raw_ham_slice", 1, 0.6F);
    public static final Item COOKED_HAM_SLICE = registerFoodItem("cooked_ham_slice", 3, 1.6F);
    public static final Item RAW_BACON = registerFoodItem("raw_bacon", 1, 0.9F);
    public static final Item COOKED_BACON = registerFoodItem("cooked_bacon", 3, 1.8F);
    public static final Item RAW_RIBS = registerFoodItem("raw_ribs", 3, 0.6F);
    public static final Item COOKED_RIBS = registerFoodItem("cooked_ribs", 10, 1.6F);
    public static final Item RAW_RIB_EYE_STEAK = registerFoodItem("raw_rib_eye_steak", 3, 0.6F);
    public static final Item COOKED_RIB_EYE_STEAK = registerFoodItem("cooked_rib_eye_steak", 10, 1.6F);
    public static final Item RAW_DOGMEAT = registerFoodItem("raw_dogmeat", 2, 0.6F);
    public static final Item COOKED_DOGMEAT = registerFoodItem("cooked_dogmeat", 8, 1.6F);
    public static final Item RAW_HORSEMEAT = registerFoodItem("raw_horsemeat", 2, 0.6F);
    public static final Item COOKED_HORSEMEAT = registerFoodItem("cooked_horsemeat", 8, 1.6F);
    public static final Item RAW_MULEMEAT = registerFoodItem("raw_mulemeat", 3, 0.8F);
    public static final Item COOKED_MULEMEAT = registerFoodItem("cooked_mulemeat", 10, 1.8F);
    public static final Item RAW_DONKEYMEAT = registerFoodItem("raw_donkeymeat", 2, 0.6F);
    public static final Item COOKED_DONKEYMEAT = registerFoodItem("cooked_donkeymeat", 8, 1.6F);
    public static final Item RAISIN_COOKIE = registerFoodItem("raisin_cookie", 2, 0.2F);
    public static final Item CHOCOLATE_RAISIN_COOKIE = registerFoodItem("chocolate_raisin_cookie", 2, 0.2F);
    public static final Item MARGHERITA_PIZZA = registerFoodItem("margherita_pizza", 6, 1.2F);
    public static final Item MINCEMEAT_PIZZA = registerFoodItem("mincemeat_pizza", 7, 1.2F);
    public static final Item VEGGIE_PIZZA = registerFoodItem("veggie_pizza", 5, 1.2F);
    public static final Item HAWAIIN_PIZZA = registerFoodItem("hawaiin_pizza", 7, 1.2F);
    public static final Item BUN = registerFoodItem("bun", 2, 1.2F);
    public static final Item SLICED_BUN = registerFoodItem("sliced_bun", 1, 1.2F);
    public static final Item BUN_SLICES = registerFoodItem("bun_slices", 2, 1.2F);
    public static final Item VEGGIE_BURGER = registerFoodItem("veggie_burger", 4, 1.2F);
    public static final Item CHEESE_BURGER = registerFoodItem("cheese_burger", 4, 1.4F);
    public static final Item HAMBURGER = registerFoodItem("hamburger", 6, 1.6F);
    public static final Item TOFU_BURGER = registerFoodItem("tofu_burger", 4, 1.4F);
    public static final Item SOYLENT_BURGER = registerFoodItem("soylent_burger", 5, 1.4F);
    public static final Item FISH_BURGER = registerFoodItem("fish_burger", 6, 1.6F);
    public static final Item SLICED_BREAD = registerFoodItem("sliced_bread", 2, 1.2F);
    public static final Item BREAD_SLICES = registerFoodItem("bread_slices", 5, 1.2F);
    public static final Item VEGGIE_SANDWICH = registerFoodItem("veggie_sandwich", 7, 1.2F);
    public static final Item CHEESE_SANDWICH = registerFoodItem("cheese_sandwich", 7, 1.4F);
    public static final Item BACON_SANDWICH = registerFoodItem("bacon_sandwich", 10, 1.8F);
    public static final Item STEAK_SANDWICH = registerFoodItem("steak_sandwich", 10, 1.6F);
    public static final Item BAGUETTE = registerFoodItem("baguette", 8, 1.2F);
    public static final Item SLICED_BAGUETTE = registerFoodItem("sliced_baguette", 4, 1.2F);
    public static final Item BAGUETTE_SLICES = registerFoodItem("baguette_slices", 8, 1.2F);
    public static final Item LARGE_VEGGIE_SANDWICH = registerFoodItem("large_veggie_sandwich", 15, 2.2F);
    public static final Item LARGE_CHEESE_SANDWICH = registerFoodItem("large_cheese_sandwich", 15, 2.4F);
    public static final Item LARGE_BACON_SANDWICH = registerFoodItem("large_bacon_sandwich", 20, 2.8F);
    public static final Item LARGE_STEAK_SANDWICH = registerFoodItem("large_steak_sandwich", 20, 2.6F);
    public static final Item RAW_FRIES = registerFoodItem("raw_fries", 1, 1.2F);
    public static final Item FRIES = registerFoodItem("fries", 7, 1.2F);
    public static final Item RAW_POTATO_CHIPS = registerFoodItem("raw_potato_chips", 1, 1.2F);
    public static final Item POTATO_CHIPS = registerFoodItem("potato_chips", 7, 1.2F);
    public static final Item CHILI_CHIPS = registerFoodItem("chili_chips", 7, 1.2F);

    static <T extends Block> T registerBlock(String id, T block) {
        blockIdList.put(new ResourceLocation(GTFoods.MODID, id), block);
        return block;
    }

    static Item registerFoodItem(String id, int hunger, float saturation) {
        return registerItem(id, new Item(new Item.Properties().group(GTFoods.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build())));
    }

    static BlockNamedItem registerBerry(String id, Block block, int hunger, float saturation) {
        return registerItem(id, new BlockNamedItem(block, new Item.Properties().group(GTFoods.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build())));
    }

    static <T extends Item> T registerItem(String id, T item) {
        itemIdList.put(new ResourceLocation(GTFoods.MODID, id), item);
        return item;
    }

    public static void init(){

    }

    public static Map<ResourceLocation, Item> getItemIdList() {
        return itemIdList;
    }

    public static Map<ResourceLocation, Block> getBlockIdList() {
        return blockIdList;
    }
}
