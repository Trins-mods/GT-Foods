package trinsdar.gt_foods.loader;

import com.google.common.collect.ImmutableMap;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemCover;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.gti.GregTech;
import muramasa.gti.block.BlockCasing;
import muramasa.gti.data.GregTechData;
import muramasa.gti.data.TierMaps;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;
import trinsdar.gt4r.Ref;
import trinsdar.gt4r.data.CustomTags;
import trinsdar.gt4r.data.GT4RData;
import trinsdar.gt4r.data.Materials;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.ToolTypes;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.KNIFE;
import static muramasa.antimatter.Data.PLATE;
import static muramasa.antimatter.machine.Tier.LV;
import static net.minecraft.item.Items.*;
import static net.minecraft.item.Items.COOKED_BEEF;
import static trinsdar.gt_foods.data.GTFMaterials.StainlessSteel;
import static trinsdar.gt_foods.data.GTFData.*;
import static trinsdar.gt_foods.data.GTFData.RAW_CAKE_BOTTOM;
import static trinsdar.gt_foods.data.GTFData.SUGARY_DOUGH;

public class CraftingTableLoader {
    public static void loadRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        registerFoodCraftingRecipes(consumer, provider);
        registerFoodKnifeRecipes(consumer, provider);
        registerMachineRecipes(consumer, provider);
    }

    protected static void registerFoodKnifeRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        ICriterionInstance knife = provider.hasSafeItem(Data.KNIFE.getForgeTag());
        Function<Item, ImmutableMap<Character, Object>> map = item -> of('I', item, 'K', KNIFE.getForgeTag());
        String array = "KI";
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_apple", "slices", "has_knife", knife, new ItemStack(APPLE_SLICE, 4), map.apply(APPLE), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_banana", "slices", "has_knife", knife, new ItemStack(BANANA_SLICE, 4), map.apply(BANANA), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_carrot", "slices", "has_knife", knife, new ItemStack(CARROT_SLICE, 4), map.apply(CARROT), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_cheese", "slices", "has_knife", knife, new ItemStack(CHEESE_SLICE, 4), map.apply(CHEESE), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_ham_cooked", "slices", "has_knife", knife, new ItemStack(COOKED_HAM_SLICE, 4), map.apply(COOKED_HAM), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "raw_chocolate_raisin_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, 4), map.apply(SUGARY_CHOCOLATE_RAISIN_DOUGH), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "raw_raisin_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_RAISIN_DOUGH, 4), map.apply(SUGARY_RAISIN_DOUGH), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "raw_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_DOUGH, 4), map.apply(CHOCOLATE_DOUGH), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_cucumber", "slices", "has_knife", knife, new ItemStack(CUCUMBER_SLICE, 4), map.apply(CUCUMBER), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_egg", "slices", "has_knife", knife, new ItemStack(SLICED_EGG, 4), map.apply(BOILED_EGG), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_lemon", "slices", "has_knife", knife, new ItemStack(LEMON_SLICE, 4), map.apply(LEMON), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_onion", "slices", "has_knife", knife, new ItemStack(ONION_SLICE, 4), map.apply(ONION), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_pic/kle", "slices", "has_knife", knife, new ItemStack(PICKLE_SLICE, 4), map.apply(PICKLE), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_pineapple", "slices", "has_knife", knife, new ItemStack(PINEAPPLE_SLICE, 4), map.apply(PINEAPPLE), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "fries", "slices", "has_knife", knife, new ItemStack(RAW_FRIES), map.apply(POTATO), "K", "I");
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_ham_raw", "slices", "has_knife", knife, new ItemStack(RAW_HAM_SLICE, 4), map.apply(RAW_HAM), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "potato_chips", "slices", "has_knife", knife, new ItemStack(RAW_POTATO_CHIPS), map.apply(POTATO), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "baguette_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BAGUETTE, 2), map.apply(BAGUETTE), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "bun_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BUN, 2), map.apply(BUN), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "bread_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BREAD, 2), map.apply(BREAD), array);
        provider.addStackRecipe(consumer, GTFoods.MODID, "slice_tomato", "slices", "has_knife", knife, new ItemStack(TOMATO_SLICE, 4), map.apply(TOMATO), array);

        provider.shapeless(consumer, "dough_pizza", "dough", "has_rolling_pin", provider.hasSafeItem(ToolTypes.ROLLING_PIN.getForgeTag()), new ItemStack(PIZZA_DOUGH), ToolTypes.ROLLING_PIN.getForgeTag(), DOUGH);
        provider.shapeless(consumer, "dough_pasta", "dough", "has_rolling_pin", provider.hasSafeItem(ToolTypes.ROLLING_PIN.getForgeTag()), new ItemStack(FLATTENED_PASTA_DOUGH), ToolTypes.ROLLING_PIN.getForgeTag(), EGG_DOUGH);
    }

    protected static void registerMachineRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        provider.addStackRecipe(consumer, GTFoods.MODID, "juicer_clay", "machines", "has_knife", provider.hasSafeItem(KNIFE.getForgeTag()), new ItemStack(ClayJuicer), of('C', CLAY_BALL, 'R', ToolTypes.ROLLING_PIN.getForgeTag(), 'K', KNIFE.getForgeTag()), "KCR", "CCC");
        if (AntimatterAPI.isModLoaded("gti")){
            for (Tier tier : Tier.getStandard()){
                Item motor = GregTech.get(ItemBasic.class, "motor_"+tier.getId());
                if (motor == null) return;
                Item piston = GregTech.get(ItemBasic.class, "piston_"+tier.getId());
                if (piston == null) return;
                Item arm = GregTech.get(ItemBasic.class, "robot_arm_"+tier.getId());
                if (arm == null) return;
                Item conveyor = GregTech.get(ItemCover.class, "conveyor_"+tier.getId());
                if (conveyor == null) return;
                Item pump = GregTech.get(ItemCover.class, "pump_"+tier.getId());
                if (pump == null) return;
                Item casing = Item.BY_BLOCK.get(GregTech.get(BlockCasing.class, "casing_" + tier.getId()));
                if (casing == null) return;
                Item sensor = GregTech.get(ItemBasic.class, "sensor_"+tier.getId());
                if (sensor == null) return;
                Item emitter = GregTech.get(ItemBasic.class, "emitter_"+tier.getId());
                if (emitter == null) return;
                Item field = GregTech.get(ItemBasic.class, "field_gen_"+tier.getId());
                if (field == null) return;
                Item circuit = TierMaps.TIER_CIRCUITS.getOrDefault(tier, GregTechData.CircuitBasic);
                Item cable = TierMaps.TIER_CABLES.get(tier);
                if (cable == null) return;
                Item glass = Items.GLASS;
                Item rotor = TierMaps.TIER_ROTORS.get(tier);
                provider.addStackRecipe(consumer, GTFoods.MODID, tier.getId() + "_slicer", "machines", "has_machine_casing", provider.hasSafeItem(casing), new ItemStack(Machines.SLICER.getItem(tier)), of('C', cable, 'c', circuit, 'M', casing, 'P', piston, 'm', conveyor), "CcC", "PMm", "CcC");
                if (tier == Tier.LV && !AntimatterAPI.isModLoaded("gt4r")){
                    provider.addItemRecipe(consumer, GTFoods.MODID, "bath", "machines", "has_machine_casing", provider.hasSafeItem(casing),
                            Machines.NonGt4rMachines.BATH.getItem(LV), of('S', PLATE.getMaterialTag(StainlessSteel), 'M', casing), "SSS", "S S", "SMS");
                }
            }
        } else if (AntimatterAPI.isModLoaded("gt4r")){
            provider.addStackRecipe(consumer, GTFoods.MODID,  "slicer", "machines", "has_machine_hull", provider.hasSafeItem(CustomTags.MACHINE_HULLS_BASIC), new ItemStack(Machines.SLICER.getItem(LV)), of('C', GT4RData.CABLE_TIN.getBlockItem(PipeSize.VTINY), 'c', CustomTags.CIRCUITS_BASIC, 'M', CustomTags.MACHINE_HULLS_BASIC, 'P', CustomTags.PISTONS, 'm', GT4RData.ConveyorModule), "CcC", "PMm", "CcC");
            provider.addStackRecipe(consumer, GTFoods.MODID,  "mixer", "machines", "has_machine_hull", provider.hasSafeItem(CustomTags.MACHINE_HULLS_BASIC), new ItemStack(Machines.NonGtiMachines.MIXER.getItem(LV)), of('G', Tags.Items.GLASS_COLORLESS, 'C', CustomTags.CIRCUITS_BASIC, 'M', CustomTags.MACHINE_HULLS_BASIC, 'R', Materials.TURBINE_BLADE.get(Materials.Bronze), 'm', GT4RData.MotorLV), "GRG", "GmG", "CMC");
        }
    }

    protected static void registerFoodCraftingRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        provider.shapeless(consumer,"buns", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(BUN_SLICES), SLICED_BUN, SLICED_BUN);
        provider.shapeless(consumer,"burger_veggie", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(VEGGIE_BURGER), SLICED_BUN, SLICED_BUN, CUCUMBER_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"burger_veggie_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(VEGGIE_BURGER), BUN_SLICES, CUCUMBER_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"burger_cheese", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(CHEESE_BURGER), SLICED_BUN, SLICED_BUN, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"burger_cheese_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(CHEESE_BURGER), BUN_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"hamburger", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(HAMBURGER), SLICED_BUN, SLICED_BUN, COOKED_MEAT_BAR);
        provider.shapeless(consumer,"hamburger_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(HAMBURGER), BUN_SLICES, COOKED_MEAT_BAR);
        provider.shapeless(consumer,"burger_tufu", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(TOFU_BURGER), SLICED_BUN, SLICED_BUN, TOFU_BAR);
        provider.shapeless(consumer,"burger_tufu_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(TOFU_BURGER), BUN_SLICES, TOFU_BAR);
        provider.shapeless(consumer,"burger_soylent", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(SOYLENT_BURGER), SLICED_BUN, SLICED_BUN, SOYLENT_BAR);
        provider.shapeless(consumer,"burger_soylent_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(SOYLENT_BURGER), BUN_SLICES, SOYLENT_BAR);
        provider.shapeless(consumer,"burger_fish", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(FISH_BURGER), SLICED_BUN, SLICED_BUN, COOKED_FISH_BAR);
        provider.shapeless(consumer,"burger_fish_2", "burgers", "has_bun_slices", provider.hasSafeItem(SLICED_BUN), new ItemStack(FISH_BURGER), BUN_SLICES, COOKED_FISH_BAR);


        provider.shapeless(consumer,"breads", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(BREAD_SLICES), SLICED_BREAD, SLICED_BREAD);
        provider.shapeless(consumer,"sandwich_veggie", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(VEGGIE_SANDWICH), SLICED_BREAD, SLICED_BREAD, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"sandwich_veggie_2", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(VEGGIE_SANDWICH), BREAD_SLICES, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"sandwich_cheese", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(CHEESE_SANDWICH), SLICED_BREAD, SLICED_BREAD, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"sandwich_cheese_2", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(CHEESE_SANDWICH), BREAD_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"sandwich_bacon", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(BACON_SANDWICH), SLICED_BREAD, SLICED_BREAD, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        provider.shapeless(consumer,"sandwich_bacon_2", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(BACON_SANDWICH), BREAD_SLICES, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        provider.shapeless(consumer,"sandwich_steak", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(STEAK_SANDWICH), SLICED_BREAD, SLICED_BREAD, COOKED_BEEF);
        provider.shapeless(consumer,"sandwich_steak_2", "sandwiches", "has_bread_slices", provider.hasSafeItem(SLICED_BREAD), new ItemStack(STEAK_SANDWICH), BREAD_SLICES, COOKED_BEEF);

        provider.shapeless(consumer,"baguettes", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(BAGUETTE_SLICES), SLICED_BAGUETTE, SLICED_BAGUETTE);
        provider.shapeless(consumer,"sandwich_large_veggie", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_VEGGIE_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, CUCUMBER_SLICE, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"sandwich_large_veggie_2", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_VEGGIE_SANDWICH), BAGUETTE_SLICES, CUCUMBER_SLICE, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        provider.shapeless(consumer,"sandwich_large_cheese", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_CHEESE_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"sandwich_large_cheese_2", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_CHEESE_SANDWICH), BAGUETTE_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        provider.shapeless(consumer,"sandwich_large_bacon", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_BACON_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        provider.shapeless(consumer,"sandwich_large_bacon_2", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_BACON_SANDWICH), BAGUETTE_SLICES, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        provider.shapeless(consumer,"sandwich_large_steak", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_STEAK_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, COOKED_BEEF, COOKED_BEEF);
        provider.shapeless(consumer,"sandwich_large_steak_2", "large_sandwiches", "has_baguette_slices", provider.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_STEAK_SANDWICH), BAGUETTE_SLICES, COOKED_BEEF, COOKED_BEEF);

        provider.shapeless(consumer, "cake_bottom_raw", "misc", "has_sugary_dough", provider.hasSafeItem(SUGARY_DOUGH), new ItemStack(RAW_CAKE_BOTTOM), SUGARY_DOUGH, SUGARY_DOUGH, SUGARY_DOUGH, SUGARY_DOUGH);
    }
}
