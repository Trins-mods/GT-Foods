package trinsdar.gt_foods.loader;

import com.google.common.collect.ImmutableMap;
import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidStack;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.recipe.JuicingRecipeBuilder;

import java.util.function.Consumer;

public class JuicerLoader {

    public static void init(){
        /*RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.COCOA_BEANS, 1)).io(Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1)).chances(80, 80, 80, 80).fo(GTFMaterials.SeedOil.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.CHILI_PEPPER, 1)).io(Data.DUST_SMALL.get(GTFMaterials.Chili, 1), Data.DUST_SMALL.get(GTFMaterials.Chili, 1), Data.DUST_SMALL.get(GTFMaterials.Chili, 1), Data.DUST_SMALL.get(GTFMaterials.Chili, 1)).chances(80, 80, 80, 80).fo(GTFMaterials.ChiliSauce.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Tags.Items.SEEDS, 1)).fo(GTFMaterials.SeedOil.getLiquid(50)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.EGG, 1)).io(new ItemStack(GTFData.EGG_WHITE), new ItemStack(GTFData.EGG_YOLK)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.COD, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(1000)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.SALMON, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(2000)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.TROPICAL_FISH, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(500)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.HAZELNUT, 1)).io(Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1)).chances(80, 80, 80, 80).fo(GTFMaterials.NutOil.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.PEANUT, 1)).io(Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), Data.DUST_SMALL.get(GTFMaterials.Peanut, 1)).chances(80, 80, 80, 80).fo(GTFMaterials.NutOil.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.APPLE, 1)).fo(GTFMaterials.AppleJuice.getLiquid(75)).add();*/
    }

    public static void loadRecipes(Consumer<IFinishedRecipe> consumer, AntimatterRecipeProvider provider){
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.COCOA_BEANS), GTFMaterials.SeedOil.getLiquid(75)).addItemOutputsWithChances(
                ImmutableMap.of(Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Cocoa, 1), .8f)
        ).addCriterion("has_cocoa_beans", provider.hasSafeItem(Items.COCOA_BEANS)).build(consumer, "cocoa_beans_to_seed_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(GTFData.CHILI_PEPPER), GTFMaterials.ChiliSauce.getLiquid(75)).addItemOutputsWithChances(
                ImmutableMap.of(Data.DUST_SMALL.get(GTFMaterials.Chili, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Chili, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Chili, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Chili, 1), .8f)
        ).addCriterion("has_chili_pepper", provider.hasSafeItem(GTFData.CHILI_PEPPER)).build(consumer, "chili_pepper_to_chili_sauce");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Tags.Items.SEEDS), GTFMaterials.SeedOil.getLiquid(50)).addCriterion("has_seeds", provider.hasSafeItem(Tags.Items.SEEDS)).build(consumer, "seeds_to_seed_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.EGG), FluidStack.EMPTY).addItemOutputs(new ItemStack(GTFData.EGG_WHITE), new ItemStack(GTFData.EGG_YOLK)).addCriterion("has_egg", provider.hasSafeItem(Items.EGG)).build(consumer, "egg_yolk_and_white");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.COD), GTFMaterials.FishOil.getLiquid(1000)).addItemOutputs(Data.DUST.get(GTFMaterials.FishMeal, 1)).addCriterion("has_cod", provider.hasSafeItem(Items.COD)).build(consumer, "cod_to_fish_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.SALMON), GTFMaterials.FishOil.getLiquid(2000)).addItemOutputs(Data.DUST.get(GTFMaterials.FishMeal, 1)).addCriterion("has_salmon", provider.hasSafeItem(Items.SALMON)).build(consumer, "salmon_to_fish_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.TROPICAL_FISH), GTFMaterials.FishOil.getLiquid(500)).addItemOutputs(Data.DUST.get(GTFMaterials.FishMeal, 1)).addCriterion("has_tropical_fish", provider.hasSafeItem(Items.TROPICAL_FISH)).build(consumer, "tropical_fish_to_fish_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(GTFData.HAZELNUT), GTFMaterials.NutOil.getLiquid(75)).addItemOutputsWithChances(
                ImmutableMap.of(Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Hazelnut, 1), .8f)
        ).addCriterion("has_hazelnut", provider.hasSafeItem(GTFData.HAZELNUT)).build(consumer, "hazelnuts_to_nut_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(GTFData.PEANUT), GTFMaterials.NutOil.getLiquid(75)).addItemOutputsWithChances(
                ImmutableMap.of(Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), .8f, Data.DUST_SMALL.get(GTFMaterials.Peanut, 1), .8f)
        ).addCriterion("has_peanut", provider.hasSafeItem(GTFData.PEANUT)).build(consumer, "peanuts_to_nut_oil");
        JuicingRecipeBuilder.juicingRecipe(Ingredient.of(Items.APPLE), GTFMaterials.AppleJuice.getLiquid(75)).addCriterion("has_apple", provider.hasSafeItem(Items.APPLE)).build(consumer, "apple_to_apple_juice");
    }
}
