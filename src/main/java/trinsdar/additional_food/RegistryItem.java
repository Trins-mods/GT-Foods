package trinsdar.additional_food;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import trinsdar.additional_food.items.ItemFood;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(AdditionalFood.MODID)
@Mod.EventBusSubscriber(modid = AdditionalFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryItem {
    private static List<Item> toRegister = new ArrayList<>();
    public static final ItemFood lemon = registerFoodItem("lemon", 1, 0.6F);
    public static final ItemFood lemonSlice = registerFoodItem("lemon_slice", 0, 0.15F);
    public static final ItemFood tomato = registerFoodItem("tomato", 1, 0.6F);
    public static final ItemFood tomatoSlice = registerFoodItem("tomato_slice", 0, 0.15F);
    public static final ItemFood maxTomato = registerFoodItem("max_tomato", 9, 1.0F);
    public static final ItemFood onion = registerFoodItem("onion", 1, 1.2F);
    public static final ItemFood onionSlice = registerFoodItem("onion_slice", 0, 0.3F);
    public static final ItemFood cucumber = registerFoodItem("cucumber", 1, 1.2F);
    public static final ItemFood cucumberSlice = registerFoodItem("cucumber_slice", 0, 0.3F);
    public static final ItemFood chiliPepper = registerFoodItem("chili_pepper", 1, 1.2F);
    public static final ItemFood greenGrapes = registerFoodItem("green_grapes", 1, 0.6F);
    public static final ItemFood greenRaisins = registerFoodItem("green_raisins", 2, 0.6F);
    public static final ItemFood whiteGrapes = registerFoodItem("white_grapes", 1, 0.6F);
    public static final ItemFood whiteRaisins = registerFoodItem("white_raisins", 2, 0.6F);
    public static final ItemFood redGrapes = registerFoodItem("red_grapes", 1, 0.6F);
    public static final ItemFood redRaisins = registerFoodItem("red_raisins", 2, 0.6F);
    public static final ItemFood purpleGrapes = registerFoodItem("purple_grapes", 1, 0.6F);
    public static final ItemFood purpleRaisins = registerFoodItem("purple_raisins", 2, 0.6F);
    public static final ItemFood chocolateRaisins = registerFoodItem("chocolate_raisins", 3, 1.2F);
    public static final ItemFood carrotSlice = registerFoodItem("carrot_slice", 0, 0.3F);
    public static final ItemFood banana = registerFoodItem("banana", 1, 0.6F);
    public static final ItemFood bananaSlice = registerFoodItem("banana_slice",0, 0.15F);
    public static final ItemFood pomegranate = registerFoodItem("pomegranate", 1, 0.6F);
    public static final ItemFood pomeraisins =registerFoodItem("pomeraisins", 2, 0.6F);
    public static final ItemFood blueberry = registerFoodItem("blueberry", 1, 0.6F);
    public static final ItemFood gooseberry = registerFoodItem("gooseberry", 1, 0.6F);
    public static final ItemFood candleberry = registerFoodItem("candleberry", 1, 0.6F);
    public static final ItemFood cranberry = registerFoodItem("cranberry", 1, 0.6F);
    public static final ItemFood blackCurrants = registerFoodItem("black_currants", 1, 0.6F);
    public static final ItemFood redCurrants = registerFoodItem("red_currants", 1, 0.6F);
    public static final ItemFood whiteCurrants = registerFoodItem("white_currants", 1, 0.6F);
    public static final ItemFood blackberry = registerFoodItem("blackberry", 1, 0.6F);
    public static final ItemFood raspberry = registerFoodItem("raspberry", 1, 0.6F);
    public static final ItemFood strawberry = registerFoodItem("strawberry", 1, 0.6F);
    public static final ItemFood appleSlice = registerFoodItem("apple_slice", 1, 0.3F);
    public static final ItemFood peanut = registerFoodItem("peanut", 2, 0.3F);
    public static final ItemFood hazelnut = registerFoodItem("hazelnut", 2, 0.3F);
    public static final ItemFood ananas = registerFoodItem("ananas", 4, 0.3F);
    public static final ItemFood ananasSlice = registerFoodItem("ananas_slice", 1, 0.3F);
    public static final ItemFood cinnamonBark = registerFoodItem("cinnamon_bark", 2, 0.3F);
    public static final ItemFood cheese = registerFoodItem("cheese", 2, 1.2F);
    public static final ItemFood cheeseSlice = registerFoodItem("cheese_slice", 1, 0.6F);
    public static final ItemFood rawHam = registerFoodItem("raw_ham", 3, 0.6F);
    public static final ItemFood cookedHam = registerFoodItem("cooked_ham", 10, 1.6F);
    public static final ItemFood rawHamSlice = registerFoodItem("raw_ham_slice", 1, 0.6F);
    public static final ItemFood cookedHamSlice = registerFoodItem("cooked_ham_slice", 3, 1.6F);
    public static final ItemFood rawBacon = registerFoodItem("raw_bacon", 1, 0.9F);
    public static final ItemFood cookedBacon = registerFoodItem("cooked_bacon", 3, 1.8F);
    public static final ItemFood rawRibs = registerFoodItem("raw_ribs", 3, 0.6F);
    public static final ItemFood cookedRibs = registerFoodItem("cooked_ribs", 10, 1.6F);
    public static final ItemFood rawRibEyeSteak = registerFoodItem("raw_rib_eye_steak", 3, 0.6F);
    public static final ItemFood cookedRibEyeSteak = registerFoodItem("cooked_rib_eye_steak", 10, 1.6F);
    public static final ItemFood rawHorsemeat = registerFoodItem("raw_horsemeat", 2, 0.6F);
    public static final ItemFood cookedHorsemeat = registerFoodItem("cooked_horsemeat", 8, 1.6F);
    public static final ItemFood rawMulemeat = registerFoodItem("raw_mulemeat", 3, 0.8F);
    public static final ItemFood cookedMulemeat = registerFoodItem("cooked_mulemeat", 10, 1.8F);
    public static final ItemFood rawDonkeymeat = registerFoodItem("raw_donkeymeat", 2, 0.6F);
    public static final ItemFood cookedDonkeymeat = registerFoodItem("cooked_donkeymeat", 8, 1.6F);
    public static final ItemFood raisinCookie = registerFoodItem("raisin_cookie", 2, 0.2F);
    public static final ItemFood chocolateRaisinCookie = registerFoodItem("chocolate_raisin_cookie", 2, 0.2F);
    public static final ItemFood margheritaPizza = registerFoodItem("margherita_pizza", 6, 1.2F);
    public static final ItemFood mincemeatPizza = registerFoodItem("mincemeat_pizza", 7, 1.2F);
    public static final ItemFood veggiePizza = registerFoodItem("veggie_pizza", 5, 1.2F);
    public static final ItemFood hawaiinPizza = registerFoodItem("hawaiin_pizza", 7, 1.2F);
    public static final ItemFood bun = registerFoodItem("bun",2, 1.2F);
    public static final ItemFood slicedBun = registerFoodItem("sliced_bun", 1, 1.2F);
    public static final ItemFood bunSlices = registerFoodItem("bun_slices", 2, 1.2F);
    public static final ItemFood veggieBurger = registerFoodItem("veggie_burger", 4, 1.2F);
    public static final ItemFood cheeseBurger = registerFoodItem("cheese_burger", 4, 1.4F);
    public static final ItemFood hamBurger = registerFoodItem("hamburger", 6, 1.6F);
    public static final ItemFood tofuBurger = registerFoodItem("tofu_burger", 4, 1.4F);
    public static final ItemFood soylentBurger = registerFoodItem("soylent_burger", 5, 1.4F);
    public static final ItemFood fishBurger = registerFoodItem("fish_burger", 6, 1.6F);
    public static final ItemFood slicedBread = registerFoodItem("sliced_bread", 2, 1.2F);
    public static final ItemFood breadSlices = registerFoodItem("bread_slices", 5, 1.2F);
    public static final ItemFood veggieSandwich = registerFoodItem("veggie_sandwich", 7, 1.2F);
    public static final ItemFood cheeseSandwich = registerFoodItem("cheese_sandwich", 7, 1.4F);
    public static final ItemFood baconSandwich = registerFoodItem("bacon_sandwich", 10, 1.8F);
    public static final ItemFood steakSandwich = registerFoodItem("steak_sandwich", 10, 1.6F);
    public static final ItemFood baguette = registerFoodItem("baguette", 8, 1.2F);
    public static final ItemFood slicedBaguette = registerFoodItem("sliced_baguette", 4, 1.2F);
    public static final ItemFood baguetteSlices = registerFoodItem("baguette_slices", 8, 1.2F);
    public static final ItemFood largeVeggieSandwich = registerFoodItem("large_veggie_sandwich", 15, 2.2F);
    public static final ItemFood largeCheeseSandwich = registerFoodItem("large_cheese_sandwich", 15, 2.4F);
    public static final ItemFood largeBaconSandwich = registerFoodItem("large_bacon_sandwich", 20, 2.8F);
    public static final ItemFood largeSteakSandwich = registerFoodItem("large_steak_sandwich", 20, 2.6F);
    public static final ItemFood rawFries = registerFoodItem("raw_fries", 1, 1.2F);
    public static final ItemFood fries = registerFoodItem("fries", 7, 1.2F);
    public static final ItemFood rawPotatoChips = registerFoodItem("raw_potato_chips", 1, 1.2F);
    public static final ItemFood potatoChips = registerFoodItem("potato_chips", 7, 1.2F);
    public static final ItemFood chiliChips = registerFoodItem("chili_chips", 7, 1.2F);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        for (Item item : toRegister){
            event.getRegistry().register(item);
        }
    }

    static ItemFood registerFoodItem(String id, int hunger, float saturation){
        return registerItem(new ItemFood(id, hunger, saturation));
    }

    static <T extends Item> T registerItem(T item) {
        toRegister.add(item);
        return item;
    }

    public static List<Item> getToRegister() {
        return toRegister;
    }
}
