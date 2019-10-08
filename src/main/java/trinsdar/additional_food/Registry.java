package trinsdar.additional_food;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import org.lwjgl.system.CallbackI;
import trinsdar.additional_food.blocks.BlockCropBerry;
import trinsdar.additional_food.blocks.BlockCropWaterlogged;
import trinsdar.additional_food.items.ItemFood;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = AdditionalFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
    private static List<Item> itemIdList = new ArrayList<>();
    private static List<Block> blockIdList = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AdditionalFood.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AdditionalFood.MODID);

    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", () -> registerBlock(new BlockCropBerry("blueberry")));
    public static final RegistryObject<Block> GOOSEBERRY_BUSH = BLOCKS.register("gooseberry_bush", () -> registerBlock(new BlockCropBerry("gooseberry")));
    public static final RegistryObject<Block> BLACKBERRY_BUSH = BLOCKS.register("blackberry_bush", () -> registerBlock(new BlockCropBerry("blackberry")));
    public static final RegistryObject<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush", () -> registerBlock(new BlockCropBerry("raspberry")));
    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> registerBlock(new BlockCropBerry("strawberry")));
    public static final RegistryObject<Block> CRANBERRY_CROP = BLOCKS.register("cranberry_crop", () -> registerBlock(new BlockCropWaterlogged()));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> registerBerry(BLUEBERRY_BUSH.get(), 2, 0.6F));
    public static final RegistryObject<Item> GOOSEBERRY = ITEMS.register("gooseberry", () -> registerBerry(GOOSEBERRY_BUSH.get(),  2, 0.6F));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry", () -> registerBerry(BLACKBERRY_BUSH.get(), 2, 0.6F));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry", () -> registerBerry(RASPBERRY_BUSH.get(), 2, 0.6F));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> registerBerry(STRAWBERRY_BUSH.get(), 2, 0.6F));
    public static final RegistryObject<Item> CRANBERRY = ITEMS.register("cranberry", () -> registerBerry(CRANBERRY_CROP.get(), 2, 0.6F));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> LEMON_SLICE = ITEMS.register("lemon_slice", () -> registerFoodItem( 0, 0.15F));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> TOMATO_SLICE = ITEMS.register("tomato_slice", () -> registerFoodItem( 0, 0.15F));
    public static final RegistryObject<Item> MAX_TOMATO = ITEMS.register("max_tomato", () -> registerFoodItem( 9, 1.0F));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> ONION_SLICE = ITEMS.register("onion_slice", () -> registerFoodItem( 0, 0.3F));
    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> CUCUMBER_SLICE = ITEMS.register("cucumber_slice", () -> registerFoodItem( 0, 0.3F));
    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> GREEN_GRAPES = ITEMS.register("green_grapes", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> GREEN_RAISINS = ITEMS.register("green_raisins", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> WHITE_GRAPES = ITEMS.register("white_grapes", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> WHITE_RAISINS = ITEMS.register("white_raisins", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> RED_GRAPES = ITEMS.register("red_grapes", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> RED_RAISINS = ITEMS.register("red_raisins", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> PURPLE_GRAPES = ITEMS.register("purple_grapes", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> PURPLE_RAISINS = ITEMS.register("purple_raisins", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> CHOCOLATE_RAISINS = ITEMS.register("chocolate_raisins", () -> registerFoodItem( 3, 1.2F));
    public static final RegistryObject<Item> CARROT_SLICE = ITEMS.register("carrot_slice", () -> registerFoodItem( 0, 0.3F));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> BANANA_SLICE = ITEMS.register("banana_slice", () -> registerFoodItem(0, 0.15F));
    public static final RegistryObject<Item> POMEGRANATE = ITEMS.register("pomegranate", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> POMERAISINS =ITEMS.register("pomeraisins", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> CANDLEBERRY = ITEMS.register("candleberry", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> BLACK_CURRANTS = ITEMS.register("black_currants", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> RED_CURRANTS = ITEMS.register("red_currants", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> WHITE_CURRANTS = ITEMS.register("white_currants", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> APPLE_SLICE = ITEMS.register("apple_slice", () -> registerFoodItem( 1, 0.3F));
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut", () -> registerFoodItem( 2, 0.3F));
    public static final RegistryObject<Item> HAZELNUT = ITEMS.register("hazelnut", () -> registerFoodItem( 2, 0.3F));
    public static final RegistryObject<Item> ANANAS = ITEMS.register("ananas", () -> registerFoodItem( 4, 0.3F));
    public static final RegistryObject<Item> ANANAS_SLICE = ITEMS.register("ananas_slice", () -> registerFoodItem( 1, 0.3F));
    public static final RegistryObject<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark", () -> registerFoodItem( 2, 0.3F));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> registerFoodItem( 2, 1.2F));
    public static final RegistryObject<Item> CHEESE_SLICE = ITEMS.register("cheese_slice", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> RAW_HAM = ITEMS.register("raw_ham", () -> registerFoodItem( 3, 0.6F));
    public static final RegistryObject<Item> COOKED_HAM = ITEMS.register("cooked_ham", () -> registerFoodItem( 10, 1.6F));
    public static final RegistryObject<Item> RAW_HAM_SLICE = ITEMS.register("raw_ham_slice", () -> registerFoodItem( 1, 0.6F));
    public static final RegistryObject<Item> COOKED_HAM_SLICE = ITEMS.register("cooked_ham_slice", () -> registerFoodItem( 3, 1.6F));
    public static final RegistryObject<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> registerFoodItem( 1, 0.9F));
    public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> registerFoodItem( 3, 1.8F));
    public static final RegistryObject<Item> RAW_RIBS = ITEMS.register("raw_ribs", () -> registerFoodItem( 3, 0.6F));
    public static final RegistryObject<Item> COOKED_RIBS = ITEMS.register("cooked_ribs", () -> registerFoodItem( 10, 1.6F));
    public static final RegistryObject<Item> RAW_RIB_EYE_STEAK = ITEMS.register("raw_rib_eye_steak", () -> registerFoodItem( 3, 0.6F));
    public static final RegistryObject<Item> COOKED_RIB_EYE_STEAK = ITEMS.register("cooked_rib_eye_steak", () -> registerFoodItem( 10, 1.6F));
    public static final RegistryObject<Item> RAW_DOGMEAT = ITEMS.register("raw_dogmeat", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> COOKED_DOGMEAT = ITEMS.register("cooked_dogmeat", () -> registerFoodItem( 8, 1.6F));
    public static final RegistryObject<Item> RAW_HORSEMEAT = ITEMS.register("raw_horsemeat", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> COOKED_HORSEMEAT = ITEMS.register("cooked_horsemeat", () -> registerFoodItem( 8, 1.6F));
    public static final RegistryObject<Item> RAW_MULEMEAT = ITEMS.register("raw_mulemeat", () -> registerFoodItem( 3, 0.8F));
    public static final RegistryObject<Item> COOKED_MULEMEAT = ITEMS.register("cooked_mulemeat", () -> registerFoodItem( 10, 1.8F));
    public static final RegistryObject<Item> RAW_DONKEYMEAT = ITEMS.register("raw_donkeymeat", () -> registerFoodItem( 2, 0.6F));
    public static final RegistryObject<Item> COOKED_DONKEYMEAT = ITEMS.register("cooked_donkeymeat", () -> registerFoodItem( 8, 1.6F));
    public static final RegistryObject<Item> RAISIN_COOKIE = ITEMS.register("raisin_cookie", () -> registerFoodItem( 2, 0.2F));
    public static final RegistryObject<Item> CHOCOLATE_RAISIN_COOKIE = ITEMS.register("chocolate_raisin_cookie", () -> registerFoodItem( 2, 0.2F));
    public static final RegistryObject<Item> MARGHERITA_PIZZA = ITEMS.register("margherita_pizza", () -> registerFoodItem( 6, 1.2F));
    public static final RegistryObject<Item> MINCEMEAT_PIZZA = ITEMS.register("mincemeat_pizza", () -> registerFoodItem( 7, 1.2F));
    public static final RegistryObject<Item> VEGGIE_PIZZA = ITEMS.register("veggie_pizza", () -> registerFoodItem( 5, 1.2F));
    public static final RegistryObject<Item> HAWAIIN_PIZZA = ITEMS.register("hawaiin_pizza", () -> registerFoodItem( 7, 1.2F));
    public static final RegistryObject<Item> BUN = ITEMS.register("bun", () -> registerFoodItem(2, 1.2F));
    public static final RegistryObject<Item> SLICED_BUN = ITEMS.register("sliced_bun", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> BUN_SLICES = ITEMS.register("bun_slices", () -> registerFoodItem( 2, 1.2F));
    public static final RegistryObject<Item> VEGGIE_BURGER = ITEMS.register("veggie_burger", () -> registerFoodItem( 4, 1.2F));
    public static final RegistryObject<Item> CHEESE_BURGER = ITEMS.register("cheese_burger", () -> registerFoodItem( 4, 1.4F));
    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger", () -> registerFoodItem( 6, 1.6F));
    public static final RegistryObject<Item> TOFU_BURGER = ITEMS.register("tofu_burger", () -> registerFoodItem( 4, 1.4F));
    public static final RegistryObject<Item> SOYLENT_BURGER = ITEMS.register("soylent_burger", () -> registerFoodItem( 5, 1.4F));
    public static final RegistryObject<Item> FISH_BURGER = ITEMS.register("fish_burger", () -> registerFoodItem( 6, 1.6F));
    public static final RegistryObject<Item> SLICED_BREAD = ITEMS.register("sliced_bread", () -> registerFoodItem( 2, 1.2F));
    public static final RegistryObject<Item> BREAD_SLICES = ITEMS.register("bread_slices", () -> registerFoodItem( 5, 1.2F));
    public static final RegistryObject<Item> VEGGIE_SANDWICH = ITEMS.register("veggie_sandwich", () -> registerFoodItem( 7, 1.2F));
    public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich", () -> registerFoodItem( 7, 1.4F));
    public static final RegistryObject<Item> BACON_SANDWICH = ITEMS.register("bacon_sandwich", () -> registerFoodItem( 10, 1.8F));
    public static final RegistryObject<Item> STEAK_SANDWICH = ITEMS.register("steak_sandwich", () -> registerFoodItem( 10, 1.6F));
    public static final RegistryObject<Item> BAGUETTE = ITEMS.register("baguette", () -> registerFoodItem( 8, 1.2F));
    public static final RegistryObject<Item> SLICED_BAGUETTE = ITEMS.register("sliced_baguette", () -> registerFoodItem( 4, 1.2F));
    public static final RegistryObject<Item> BAGUETTE_SLICES = ITEMS.register("baguette_slices", () -> registerFoodItem( 8, 1.2F));
    public static final RegistryObject<Item> LARGE_VEGGIE_SANDWICH = ITEMS.register("large_veggie_sandwich", () -> registerFoodItem( 15, 2.2F));
    public static final RegistryObject<Item> LARGE_CHEESE_SANDWICH = ITEMS.register("large_cheese_sandwich", () -> registerFoodItem( 15, 2.4F));
    public static final RegistryObject<Item> LARGE_BACON_SANDWICH = ITEMS.register("large_bacon_sandwich", () -> registerFoodItem( 20, 2.8F));
    public static final RegistryObject<Item> LARGE_STEAK_SANDWICH = ITEMS.register("large_steak_sandwich", () -> registerFoodItem( 20, 2.6F));
    public static final RegistryObject<Item> RAW_FRIES = ITEMS.register("raw_fries", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> registerFoodItem( 7, 1.2F));
    public static final RegistryObject<Item> RAW_POTATO_CHIPS = ITEMS.register("raw_potato_chips", () -> registerFoodItem( 1, 1.2F));
    public static final RegistryObject<Item> POTATO_CHIPS = ITEMS.register("potato_chips", () -> registerFoodItem( 7, 1.2F));
    public static final RegistryObject<Item> CHILI_CHIPS = ITEMS.register("chili_chips", () -> registerFoodItem( 7, 1.2F));

    static <T extends Block> T registerBlock(T block) {
        blockIdList.add(block);
        return block;
    }

    static Item registerFoodItem(int hunger, float saturation){
        return registerItem(new Item(new Item.Properties().group(AdditionalFood.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build())));
    }

    static BlockNamedItem registerBerry(Block block, int hunger, float saturation){
        return registerItem(new BlockNamedItem(block, new Item.Properties().group(AdditionalFood.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build())));
    }

    static <T extends Item> T registerItem(T item) {
        itemIdList.add(item);
        return item;
    }

    public static List<Item> getItemIdList() {
        return itemIdList;
    }

    public static List<Block> getBlockIdList() {
        return blockIdList;
    }
}
