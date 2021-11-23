package trinsdar.gt_foods.loader;

import muramasa.antimatter.datagen.builder.AntimatterCookingRecipeBuilder;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import trinsdar.gt_foods.GTFoods;

import java.util.function.Consumer;

import static net.minecraft.item.Items.BREAD;
import static net.minecraft.item.Items.COOKIE;
import static net.minecraft.item.Items.EGG;
import static trinsdar.gt_foods.data.GTFData.*;
import static trinsdar.gt_foods.data.GTFData.POMEGRANATE;
import static trinsdar.gt_foods.data.GTFData.POMERAISINS;

public class FurnaceLoader {
    public static void loadRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        addCookingRecipe(consumer, provider, RAW_HAM, COOKED_HAM, "ham");
        addCookingRecipe(consumer, provider, RAW_HAM_SLICE, COOKED_HAM_SLICE, "ham_slice");
        addCookingRecipe(consumer, provider, RAW_BACON, COOKED_BACON, "bacon");
        addCookingRecipe(consumer, provider, RAW_RIBS, GRILLED_RIBS, "ribs");
        addCookingRecipe(consumer, provider, RAW_RIB_EYE_STEAK, GRILLED_RIB_EYE_STEAK, "rib_eye_steak");
        addCookingRecipe(consumer, provider, RAW_DOGMEAT, GRILLED_DOGMEAT, "dogmeat");
        addCookingRecipe(consumer, provider, RAW_HORSEMEAT, GRILLED_HORSEMEAT, "horsemeat");
        addCookingRecipe(consumer, provider, RAW_MULEMEAT, GRILLED_MULEMEAT, "mulemeat");
        addCookingRecipe(consumer, provider, RAW_DONKEYMEAT, GRILLED_DONKEYMEAT, "donkeymeat");
        addCookingRecipe(consumer, provider, EGG, FRIED_EGG, "cooked_egg");
        addCookingRecipe(consumer, provider, BUN_DOUGH, BUN, "bun");
        addCookingRecipe(consumer, provider, BREAD_DOUGH, BREAD, "bread");
        addCookingRecipe(consumer, provider, BAGUETTE_DOUGH, BAGUETTE, "baguette");
        addCookingRecipe(consumer, provider, RAW_CAKE_BOTTOM, CAKE_BOTTOM, "cake_bottom");
        addCookingRecipe(consumer, provider, COOKIE_SHAPED_DOUGH, COOKIE, "cookie");
        addCookingRecipe(consumer, provider, COOKIE_SHAPED_RAISIN_DOUGH, RAISIN_COOKIE, "raisin_cookie");
        addCookingRecipe(consumer, provider, COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, CHOCOLATE_RAISIN_COOKIE, "chocolate_raisin_cookie");
        addCookingRecipe(consumer, provider, RAW_MARGHERITA_PIZZA, MARGHERITA_PIZZA, "margherita_pizza");
        addCookingRecipe(consumer, provider, RAW_MINCEMEAT_PIZZA, MINCEMEAT_PIZZA, "mincemeat_pizza");
        addCookingRecipe(consumer, provider, RAW_VEGGIE_PIZZA, VEGGIE_PIZZA, "veggie_pizza");
        addCookingRecipe(consumer, provider, RAW_HAWAIIN_PIZZA, HAWAIIN_PIZZA, "hawaiin_pizza");
        addCookingRecipe(consumer, provider, RAW_POTATO_CHIPS, POTATO_CHIPS, "potato_chips");
        addCookingRecipe(consumer, provider, RAW_MEAT_BAR, COOKED_MEAT_BAR, "meat_bar");
        addCookingRecipe(consumer, provider, RAW_FISH_BAR, COOKED_FISH_BAR, "fish_bar");
        addCookingRecipe(consumer, provider, GREEN_GRAPES, GREEN_RAISINS, "green_raisins");
        addCookingRecipe(consumer, provider, RED_GRAPES, RED_RAISINS, "red_raisins");
        addCookingRecipe(consumer, provider, WHITE_GRAPES, WHITE_RAISINS, "white_raisins");
        addCookingRecipe(consumer, provider, PURPLE_GRAPES, PURPLE_RAISINS, "purple_raisins");
        addCookingRecipe(consumer, provider, POMEGRANATE, POMERAISINS, "pomeraisins");

    }

    protected static void addCookingRecipe(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider, Item input, Item output, String id){
        AntimatterCookingRecipeBuilder.smeltingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 1.0F, 200)
                .addCriterion("has_" + input.getRegistryName().getPath(), provider.hasSafeItem(input))
                .build(consumer, provider.fixLoc(GTFoods.MODID, "smelting_" + id));
        AntimatterCookingRecipeBuilder.cookingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 1.0F, 100, IRecipeSerializer.SMOKING_RECIPE)
                .addCriterion("has_" + input.getRegistryName().getPath(), provider.hasSafeItem(input))
                .build(consumer, provider.fixLoc(GTFoods.MODID, "smoking_" + id));
        AntimatterCookingRecipeBuilder.cookingRecipe(RecipeIngredient.of(input, 1).get(), new ItemStack(output), 0.0F, 600, IRecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                .addCriterion("has_" + input.getRegistryName().getPath(), provider.hasSafeItem(input))
                .build(consumer, provider.fixLoc(GTFoods.MODID, "campfire_cooking_" + id));
    }
}
