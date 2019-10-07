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
import trinsdar.additional_food.blocks.BlockCropBerry;
import trinsdar.additional_food.items.ItemFood;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = AdditionalFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
    private static List<Item> toRegister = new ArrayList<>();
    private static List<Block> toRegisterBlock = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AdditionalFood.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AdditionalFood.MODID);

    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", () -> new BlockCropBerry("blueberry"));
    public static final RegistryObject<Block> GOOSEBERRY_BUSH = BLOCKS.register("gooseberry_bush", () -> new BlockCropBerry("gooseberry"));
    public static final RegistryObject<Block> BLACKBERRY_BUSH = BLOCKS.register("blackberry_bush", () -> new BlockCropBerry("blackberry"));
    public static final RegistryObject<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush", () -> new BlockCropBerry("raspberry"));
    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new BlockCropBerry("strawberry"));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> registerBerry(BLUEBERRY_BUSH.get(), 1, 0.6F));
    public static final RegistryObject<Item> GOOSEBERRY = ITEMS.register("gooseberry", () -> registerBerry(GOOSEBERRY_BUSH.get(),  1, 0.6F));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry", () -> registerBerry(BLACKBERRY_BUSH.get(), 1, 0.6F));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry", () -> registerBerry(RASPBERRY_BUSH.get(), 1, 0.6F));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> registerBerry(STRAWBERRY_BUSH.get(), 1, 0.6F));

    public static final ItemFood LEMON = registerFoodItem("lemon", 1, 0.6F);
    public static final ItemFood LEMON_SLICE = registerFoodItem("lemon_slice", 0, 0.15F);
    public static final ItemFood TOMATO = registerFoodItem("tomato", 1, 0.6F);
    public static final ItemFood TOMATO_SLICE = registerFoodItem("tomato_slice", 0, 0.15F);
    public static final ItemFood MAX_TOMATO = registerFoodItem("max_tomato", 9, 1.0F);
    public static final ItemFood ONION = registerFoodItem("onion", 1, 1.2F);
    public static final ItemFood ONION_SLICE = registerFoodItem("onion_slice", 0, 0.3F);
    public static final ItemFood CUCUMBER = registerFoodItem("cucumber", 1, 1.2F);
    public static final ItemFood CUCUMBER_SLICE = registerFoodItem("cucumber_slice", 0, 0.3F);
    public static final ItemFood CHILI_PEPPER = registerFoodItem("chili_pepper", 1, 1.2F);
    public static final ItemFood GREEN_GRAPES = registerFoodItem("green_grapes", 1, 0.6F);
    public static final ItemFood GREEN_RAISINS = registerFoodItem("green_raisins", 2, 0.6F);
    public static final ItemFood WHITE_GRAPES = registerFoodItem("white_grapes", 1, 0.6F);
    public static final ItemFood WHITE_RAISINS = registerFoodItem("white_raisins", 2, 0.6F);
    public static final ItemFood RED_GRAPES = registerFoodItem("red_grapes", 1, 0.6F);
    public static final ItemFood RED_RAISINS = registerFoodItem("red_raisins", 2, 0.6F);
    public static final ItemFood PURPLE_GRAPES = registerFoodItem("purple_grapes", 1, 0.6F);
    public static final ItemFood PURPLE_RAISINS = registerFoodItem("purple_raisins", 2, 0.6F);
    public static final ItemFood CHOCOLATE_RAISINS = registerFoodItem("chocolate_raisins", 3, 1.2F);
    public static final ItemFood CARROT_SLICE = registerFoodItem("carrot_slice", 0, 0.3F);
    public static final ItemFood BANANA = registerFoodItem("banana", 1, 0.6F);
    public static final ItemFood BANANA_SLICE = registerFoodItem("banana_slice",0, 0.15F);
    public static final ItemFood POMEGRANATE = registerFoodItem("pomegranate", 1, 0.6F);
    public static final ItemFood POMERAISINS =registerFoodItem("pomeraisins", 2, 0.6F);
    public static final ItemFood CANDLEBERRY = registerFoodItem("candleberry", 1, 0.6F);
    public static final ItemFood CRANBERRY = registerFoodItem("cranberry", 1, 0.6F);
    public static final ItemFood BLACK_CURRANTS = registerFoodItem("black_currants", 1, 0.6F);
    public static final ItemFood RED_CURRANTS = registerFoodItem("red_currants", 1, 0.6F);
    public static final ItemFood WHITE_CURRANTS = registerFoodItem("white_currants", 1, 0.6F);
    public static final ItemFood APPLE_SLICE = registerFoodItem("apple_slice", 1, 0.3F);
    public static final ItemFood PEANUT = registerFoodItem("peanut", 2, 0.3F);
    public static final ItemFood HAZELNUT = registerFoodItem("hazelnut", 2, 0.3F);
    public static final ItemFood ANANAS = registerFoodItem("ananas", 4, 0.3F);
    public static final ItemFood ANANAS_SLICE = registerFoodItem("ananas_slice", 1, 0.3F);
    public static final ItemFood CINNAMON_BARK = registerFoodItem("cinnamon_bark", 2, 0.3F);
    public static final ItemFood CHEESE = registerFoodItem("cheese", 2, 1.2F);
    public static final ItemFood CHEESE_SLICE = registerFoodItem("cheese_slice", 1, 0.6F);
    public static final ItemFood RAW_HAM = registerFoodItem("raw_ham", 3, 0.6F);
    public static final ItemFood COOKED_HAM = registerFoodItem("cooked_ham", 10, 1.6F);
    public static final ItemFood RAW_HAM_SLICE = registerFoodItem("raw_ham_slice", 1, 0.6F);
    public static final ItemFood COOKED_HAM_SLICE = registerFoodItem("cooked_ham_slice", 3, 1.6F);
    public static final ItemFood RAW_BACON = registerFoodItem("raw_bacon", 1, 0.9F);
    public static final ItemFood COOKED_BACON = registerFoodItem("cooked_bacon", 3, 1.8F);
    public static final ItemFood RAW_RIBS = registerFoodItem("raw_ribs", 3, 0.6F);
    public static final ItemFood COOKED_RIBS = registerFoodItem("cooked_ribs", 10, 1.6F);
    public static final ItemFood RAW_RIB_EYE_STEAK = registerFoodItem("raw_rib_eye_steak", 3, 0.6F);
    public static final ItemFood COOKED_RIB_EYE_STEAK = registerFoodItem("cooked_rib_eye_steak", 10, 1.6F);
    public static final ItemFood RAW_DOGMEAT = registerFoodItem("raw_dogmeat", 2, 0.6F);
    public static final ItemFood COOKED_DOGMEAT = registerFoodItem("cooked_dogmeat", 8, 1.6F);
    public static final ItemFood RAW_HORSEMEAT = registerFoodItem("raw_horsemeat", 2, 0.6F);
    public static final ItemFood COOKED_HORSEMEAT = registerFoodItem("cooked_horsemeat", 8, 1.6F);
    public static final ItemFood RAW_MULEMEAT = registerFoodItem("raw_mulemeat", 3, 0.8F);
    public static final ItemFood COOKED_MULEMEAT = registerFoodItem("cooked_mulemeat", 10, 1.8F);
    public static final ItemFood RAW_DONKEYMEAT = registerFoodItem("raw_donkeymeat", 2, 0.6F);
    public static final ItemFood COOKED_DONKEYMEAT = registerFoodItem("cooked_donkeymeat", 8, 1.6F);
    public static final ItemFood RAISIN_COOKIE = registerFoodItem("raisin_cookie", 2, 0.2F);
    public static final ItemFood CHOCOLATE_RAISIN_COOKIE = registerFoodItem("chocolate_raisin_cookie", 2, 0.2F);
    public static final ItemFood MARGHERITA_PIZZA = registerFoodItem("margherita_pizza", 6, 1.2F);
    public static final ItemFood MINCEMEAT_PIZZA = registerFoodItem("mincemeat_pizza", 7, 1.2F);
    public static final ItemFood VEGGIE_PIZZA = registerFoodItem("veggie_pizza", 5, 1.2F);
    public static final ItemFood HAWAIIN_PIZZA = registerFoodItem("hawaiin_pizza", 7, 1.2F);
    public static final ItemFood BUN = registerFoodItem("bun",2, 1.2F);
    public static final ItemFood SLICED_BUN = registerFoodItem("sliced_bun", 1, 1.2F);
    public static final ItemFood BUN_SLICES = registerFoodItem("bun_slices", 2, 1.2F);
    public static final ItemFood VEGGIE_BURGER = registerFoodItem("veggie_burger", 4, 1.2F);
    public static final ItemFood CHEESE_BURGER = registerFoodItem("cheese_burger", 4, 1.4F);
    public static final ItemFood HAMBURGER = registerFoodItem("hamburger", 6, 1.6F);
    public static final ItemFood TOFU_BURGER = registerFoodItem("tofu_burger", 4, 1.4F);
    public static final ItemFood SOYLENT_BURGER = registerFoodItem("soylent_burger", 5, 1.4F);
    public static final ItemFood FISH_BURGER = registerFoodItem("fish_burger", 6, 1.6F);
    public static final ItemFood SLICED_BREAD = registerFoodItem("sliced_bread", 2, 1.2F);
    public static final ItemFood BREAD_SLICES = registerFoodItem("bread_slices", 5, 1.2F);
    public static final ItemFood VEGGIE_SANDWICH = registerFoodItem("veggie_sandwich", 7, 1.2F);
    public static final ItemFood CHEESE_SANDWICH = registerFoodItem("cheese_sandwich", 7, 1.4F);
    public static final ItemFood BACON_SANDWICH = registerFoodItem("bacon_sandwich", 10, 1.8F);
    public static final ItemFood STEAK_SANDWICH = registerFoodItem("steak_sandwich", 10, 1.6F);
    public static final ItemFood BAGUETTE = registerFoodItem("baguette", 8, 1.2F);
    public static final ItemFood SLICED_BAGUETTE = registerFoodItem("sliced_baguette", 4, 1.2F);
    public static final ItemFood BAGUETTE_SLICES = registerFoodItem("baguette_slices", 8, 1.2F);
    public static final ItemFood LARGE_VEGGIE_SANDWICH = registerFoodItem("large_veggie_sandwich", 15, 2.2F);
    public static final ItemFood LARGE_CHEESE_SANDWICH = registerFoodItem("large_cheese_sandwich", 15, 2.4F);
    public static final ItemFood LARGE_BACON_SANDWICH = registerFoodItem("large_bacon_sandwich", 20, 2.8F);
    public static final ItemFood LARGE_STEAK_SANDWICH = registerFoodItem("large_steak_sandwich", 20, 2.6F);
    public static final ItemFood RAW_FRIES = registerFoodItem("raw_fries", 1, 1.2F);
    public static final ItemFood FRIES = registerFoodItem("fries", 7, 1.2F);
    public static final ItemFood RAW_POTATO_CHIPS = registerFoodItem("raw_potato_chips", 1, 1.2F);
    public static final ItemFood POTATO_CHIPS = registerFoodItem("potato_chips", 7, 1.2F);
    public static final ItemFood CHILI_CHIPS = registerFoodItem("chili_chips", 7, 1.2F);

    static <T extends Block> T registerBlock(T block) {
        toRegisterBlock.add(block);
        return block;
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        for (Item item : toRegister){
            event.getRegistry().register(item);
        }
    }

    static ItemFood registerFoodItem(String id, int hunger, float saturation){
        return registerItem(new ItemFood(id, hunger, saturation));
    }

    static BlockNamedItem registerBerry(Block block, int hunger, float saturation){
        return new BlockNamedItem(block, new Item.Properties().group(AdditionalFood.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build()));
    }

    static <T extends Item> T registerItem(T item) {
        toRegister.add(item);
        return item;
    }

    public static List<Item> getToRegister() {
        return toRegister;
    }
}
