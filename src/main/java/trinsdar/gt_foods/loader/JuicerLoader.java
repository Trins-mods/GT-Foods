package trinsdar.gt_foods.loader;

import muramasa.antimatter.Data;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.data.RecipeMaps;

public class JuicerLoader {

    public static void init(){
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.COCOA_BEANS, 1)).io(Data.DUST.get(GTFMaterials.Cocoa, 1)).fo(GTFMaterials.SeedOil.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.CHILI_PEPPER, 1)).io(Data.DUST.get(GTFMaterials.Chili, 1)).fo(GTFMaterials.ChiliSauce.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Tags.Items.SEEDS, 1)).fo(GTFMaterials.SeedOil.getLiquid(50)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.EGG, 1)).io(new ItemStack(GTFData.EGG_WHITE), new ItemStack(GTFData.EGG_YOLK)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.COD, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(1000)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.SALMON, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(2000)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.TROPICAL_FISH, 1)).io(Data.DUST.get(GTFMaterials.FishMeal, 1)).fo(GTFMaterials.FishOil.getLiquid(500)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.HAZELNUT, 1)).io(Data.DUST.get(GTFMaterials.Hazelnut, 1)).fo(GTFMaterials.NutOil.getLiquid(75)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(GTFData.PEANUT, 1)).io(Data.DUST.get(GTFMaterials.Peanut, 1)).fo(GTFMaterials.NutOil.getLiquid(75)).add();
    }
}
