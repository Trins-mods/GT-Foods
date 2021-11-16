package trinsdar.gt_foods.loader;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import muramasa.antimatter.recipe.map.RecipeMap;
import net.minecraft.item.ItemStack;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.GTFMaterials;

import static trinsdar.gt_foods.data.RecipeMaps.BATHING;

public class BathingLoader {

    public static void init(){
        BATHING.RB().ii(RecipeIngredient.of(GTFData.RAW_FRIES, 1)).fi(GTFMaterials.HotFryingOil.getLiquid(10)).io(new ItemStack(GTFData.FRIES)).add(16);
    }
}
