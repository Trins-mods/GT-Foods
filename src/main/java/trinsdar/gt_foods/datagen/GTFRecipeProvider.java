package trinsdar.gt_foods.datagen;

import com.google.common.collect.ImmutableMap;
import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.builder.AntimatterCookingRecipeBuilder;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import trinsdar.gt_foods.GTFoods;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.KNIFE;
import static net.minecraft.item.Items.*;
import static trinsdar.gt_foods.data.GTFData.*;

public class GTFRecipeProvider extends AntimatterRecipeProvider {
    public GTFRecipeProvider(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        super.registerRecipes(consumer);
        registerFoodKnifeRecipes(consumer);
        registerFoodFurnaceRecipes(consumer);
    }

    protected void registerFoodKnifeRecipes(Consumer<IFinishedRecipe> consumer){
        ICriterionInstance knife = this.hasSafeItem(Data.KNIFE.getForgeTag());
        Function<Item, ImmutableMap<Character, Object>> map = item -> of('I', item, 'K', KNIFE.getForgeTag());
        String array = "KI";
        addStackRecipe(consumer, GTFoods.MODID, "slice_apple", "slices", "has_knife", knife, new ItemStack(APPLE_SLICE, 4), map.apply(APPLE), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_banana", "slices", "has_knife", knife, new ItemStack(BANANA_SLICE, 4), map.apply(BANANA), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_carrot", "slices", "has_knife", knife, new ItemStack(CARROT_SLICE, 4), map.apply(CARROT), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_cheese", "slices", "has_knife", knife, new ItemStack(CHEESE_SLICE, 4), map.apply(CHEESE), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_ham_cooked", "slices", "has_knife", knife, new ItemStack(COOKED_HAM_SLICE, 4), map.apply(COOKED_HAM), array);
        addStackRecipe(consumer, GTFoods.MODID, "raw_chocolate_raisin_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, 4), map.apply(SUGARY_CHOCOLATE_RAISIN_DOUGH), array);
        addStackRecipe(consumer, GTFoods.MODID, "raw_raisin_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_RAISIN_DOUGH, 4), map.apply(SUGARY_RAISIN_DOUGH), array);
        addStackRecipe(consumer, GTFoods.MODID, "raw_cookie", "slices", "has_knife", knife, new ItemStack(COOKIE_SHAPED_DOUGH, 4), map.apply(CHOCOLATE_DOUGH), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_cucumber", "slices", "has_knife", knife, new ItemStack(CUCUMBER_SLICE, 4), map.apply(CUCUMBER), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_egg", "slices", "has_knife", knife, new ItemStack(SLICED_EGG, 4), map.apply(BOILED_EGG), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_lemon", "slices", "has_knife", knife, new ItemStack(LEMON_SLICE, 4), map.apply(LEMON), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_onion", "slices", "has_knife", knife, new ItemStack(ONION_SLICE, 4), map.apply(ONION), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_pickle", "slices", "has_knife", knife, new ItemStack(PICKLE_SLICE, 4), map.apply(PICKLE), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_pineapple", "slices", "has_knife", knife, new ItemStack(PINEAPPLE_SLICE, 4), map.apply(PINEAPPLE), array);
        addStackRecipe(consumer, GTFoods.MODID, "fries", "slices", "has_knife", knife, new ItemStack(RAW_FRIES), map.apply(POTATO), "K", "I");
        addStackRecipe(consumer, GTFoods.MODID, "slice_ham_raw", "slices", "has_knife", knife, new ItemStack(RAW_HAM_SLICE, 4), map.apply(RAW_HAM), array);
        addStackRecipe(consumer, GTFoods.MODID, "potato_chips", "slices", "has_knife", knife, new ItemStack(RAW_POTATO_CHIPS), map.apply(POTATO), array);
        addStackRecipe(consumer, GTFoods.MODID, "baguette_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BAGUETTE, 2), map.apply(BAGUETTE), array);
        addStackRecipe(consumer, GTFoods.MODID, "bun_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BUN, 2), map.apply(BUN), array);
        addStackRecipe(consumer, GTFoods.MODID, "bread_slice", "slices", "has_knife", knife, new ItemStack(SLICED_BREAD, 2), map.apply(BREAD), array);
        addStackRecipe(consumer, GTFoods.MODID, "slice_tomato", "slices", "has_knife", knife, new ItemStack(TOMATO_SLICE, 4), map.apply(TOMATO), array);
    }

    protected void registerFoodCraftingRecipes(Consumer<IFinishedRecipe> consumer){
        shapeless(consumer,"buns", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(BUN_SLICES), SLICED_BUN, SLICED_BUN);
        shapeless(consumer,"burger_veggie", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(VEGGIE_BURGER), SLICED_BUN, SLICED_BUN, CUCUMBER_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"burger_veggie_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(VEGGIE_BURGER), BUN_SLICES, CUCUMBER_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"burger_cheese", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(CHEESE_BURGER), SLICED_BUN, SLICED_BUN, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"burger_cheese_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(CHEESE_BURGER), BUN_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"hamburger", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(HAMBURGER), SLICED_BUN, SLICED_BUN, COOKED_MEAT_BAR);
        shapeless(consumer,"hamburger_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(HAMBURGER), BUN_SLICES, COOKED_MEAT_BAR);
        shapeless(consumer,"burger_tufu", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(TOFU_BURGER), SLICED_BUN, SLICED_BUN, TOFU_BAR);
        shapeless(consumer,"burger_tufu_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(TOFU_BURGER), BUN_SLICES, TOFU_BAR);
        shapeless(consumer,"burger_soylent", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(SOYLENT_BURGER), SLICED_BUN, SLICED_BUN, SOYLENT_BAR);
        shapeless(consumer,"burger_soylent_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(SOYLENT_BURGER), BUN_SLICES, SOYLENT_BAR);
        shapeless(consumer,"burger_fish", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(FISH_BURGER), SLICED_BUN, SLICED_BUN, COOKED_FISH_BAR);
        shapeless(consumer,"burger_fish_2", "burgers", "has_bun_slices", this.hasSafeItem(SLICED_BUN), new ItemStack(FISH_BURGER), BUN_SLICES, COOKED_FISH_BAR);


        shapeless(consumer,"breads", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(BREAD_SLICES), SLICED_BREAD, SLICED_BREAD);
        shapeless(consumer,"sandwich_veggie", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(VEGGIE_SANDWICH), SLICED_BREAD, SLICED_BREAD, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"sandwich_veggie_2", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(VEGGIE_SANDWICH), BREAD_SLICES, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"sandwich_cheese", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(CHEESE_SANDWICH), SLICED_BREAD, SLICED_BREAD, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"sandwich_cheese_2", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(CHEESE_SANDWICH), BREAD_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"sandwich_bacon", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(BACON_SANDWICH), SLICED_BREAD, SLICED_BREAD, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        shapeless(consumer,"sandwich_bacon_2", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(BACON_SANDWICH), BREAD_SLICES, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        shapeless(consumer,"sandwich_steak", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(STEAK_SANDWICH), SLICED_BREAD, SLICED_BREAD, COOKED_BEEF);
        shapeless(consumer,"sandwich_steak_2", "sandwiches", "has_bread_slices", this.hasSafeItem(SLICED_BREAD), new ItemStack(STEAK_SANDWICH), BREAD_SLICES, COOKED_BEEF);

        shapeless(consumer,"baguettes", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(BAGUETTE_SLICES), SLICED_BAGUETTE, SLICED_BAGUETTE);
        shapeless(consumer,"sandwich_large_veggie", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_VEGGIE_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, CUCUMBER_SLICE, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"sandwich_large_veggie_2", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_VEGGIE_SANDWICH), BAGUETTE_SLICES, CUCUMBER_SLICE, CUCUMBER_SLICE, CUCUMBER_SLICE, TOMATO_SLICE, TOMATO_SLICE, TOMATO_SLICE, ONION_SLICE);
        shapeless(consumer,"sandwich_large_cheese", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_CHEESE_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"sandwich_large_cheese_2", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_CHEESE_SANDWICH), BAGUETTE_SLICES, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE, CHEESE_SLICE);
        shapeless(consumer,"sandwich_large_bacon", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_BACON_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        shapeless(consumer,"sandwich_large_bacon_2", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_BACON_SANDWICH), BAGUETTE_SLICES, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON, COOKED_BACON);
        shapeless(consumer,"sandwich_large_steak", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_STEAK_SANDWICH), SLICED_BAGUETTE, SLICED_BAGUETTE, COOKED_BEEF, COOKED_BEEF);
        shapeless(consumer,"sandwich_large_steak_2", "large_sandwiches", "has_baguette_slices", this.hasSafeItem(SLICED_BAGUETTE), new ItemStack(LARGE_STEAK_SANDWICH), BAGUETTE_SLICES, COOKED_BEEF, COOKED_BEEF);

        shapeless(consumer, "cake_bottom_raw", "misc", "has_sugary_dough", this.hasSafeItem(SUGARY_DOUGH), new ItemStack(RAW_CAKE_BOTTOM), SUGARY_DOUGH, SUGARY_DOUGH, SUGARY_DOUGH, SUGARY_DOUGH);
    }

    protected void registerFoodFurnaceRecipes(Consumer<IFinishedRecipe> consumer){
        addCookingRecipe(consumer, RAW_HAM, COOKED_HAM, "ham");
        addCookingRecipe(consumer, RAW_HAM_SLICE, COOKED_HAM_SLICE, "ham_slice");
        addCookingRecipe(consumer, RAW_BACON, COOKED_BACON, "bacon");
        addCookingRecipe(consumer, RAW_RIBS, GRILLED_RIBS, "ribs");
        addCookingRecipe(consumer, RAW_RIB_EYE_STEAK, GRILLED_RIB_EYE_STEAK, "rib_eye_steak");
        addCookingRecipe(consumer, RAW_DOGMEAT, GRILLED_DOGMEAT, "dogmeat");
        addCookingRecipe(consumer, RAW_HORSEMEAT, GRILLED_HORSEMEAT, "horsemeat");
        addCookingRecipe(consumer, RAW_MULEMEAT, GRILLED_MULEMEAT, "mulemeat");
        addCookingRecipe(consumer, RAW_DONKEYMEAT, GRILLED_DONKEYMEAT, "donkeymeat");
        addCookingRecipe(consumer, EGG, FRIED_EGG, "cooked_egg");
        addCookingRecipe(consumer, BUN_DOUGH, BUN, "bun");
        addCookingRecipe(consumer, BREAD_DOUGH, BREAD, "bread");
        addCookingRecipe(consumer, BAGUETTE_DOUGH, BAGUETTE, "baguette");
        addCookingRecipe(consumer, RAW_CAKE_BOTTOM, CAKE_BOTTOM, "cake_bottom");
        addCookingRecipe(consumer, COOKIE_SHAPED_DOUGH, COOKIE, "cookie");
        addCookingRecipe(consumer, COOKIE_SHAPED_RAISIN_DOUGH, RAISIN_COOKIE, "raisin_cookie");
        addCookingRecipe(consumer, COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, CHOCOLATE_RAISIN_COOKIE, "chocolate_raisin_cookie");
        addCookingRecipe(consumer, RAW_MARGHERITA_PIZZA, MARGHERITA_PIZZA, "margherita_pizza");
        addCookingRecipe(consumer, RAW_MINCEMEAT_PIZZA, MINCEMEAT_PIZZA, "mincemeat_pizza");
        addCookingRecipe(consumer, RAW_VEGGIE_PIZZA, VEGGIE_PIZZA, "veggie_pizza");
        addCookingRecipe(consumer, RAW_HAWAIIN_PIZZA, HAWAIIN_PIZZA, "hawaiin_pizza");
        addCookingRecipe(consumer, RAW_POTATO_CHIPS, POTATO_CHIPS, "potato_chips");
        addCookingRecipe(consumer, RAW_MEAT_BAR, COOKED_MEAT_BAR, "meat_bar");
        addCookingRecipe(consumer, RAW_FISH_BAR, COOKED_FISH_BAR, "fish_bar");
    }

    protected void addCookingRecipe(Consumer<IFinishedRecipe> consumer, Item input, Item output, String id){
        AntimatterCookingRecipeBuilder.smeltingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 1.0F, 200)
                .addCriterion("has_" + input.getRegistryName().getPath(), hasItem(input))
                .build(consumer, fixLoc(providerDomain, id));
        AntimatterCookingRecipeBuilder.cookingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 1.0F, 100, IRecipeSerializer.SMOKING)
                .addCriterion("has_" + input.getRegistryName().getPath(), hasItem(input))
                .build(consumer, fixLoc(providerDomain, "smoking_" + id));
        AntimatterCookingRecipeBuilder.cookingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 0.0F, 600, IRecipeSerializer.CAMPFIRE_COOKING)
                .addCriterion("has_" + input.getRegistryName().getPath(), hasItem(input))
                .build(consumer, fixLoc(providerDomain, "campfire_cooking_" + id));
    }
}