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
        BATHING.RB().ii(RecipeIngredient.of(GTFData.CUCUMBER, 1)).fi(GTFMaterials.AppleCiderVinegar.getLiquid(50)).io(new ItemStack(GTFData.PICKLE)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.GREEN_RAISINS, 1)).fi(GTFMaterials.Chocolate.getLiquid(36)).io(new ItemStack(GTFData.CHOCOLATE_RAISINS)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.WHITE_RAISINS, 1)).fi(GTFMaterials.Chocolate.getLiquid(36)).io(new ItemStack(GTFData.CHOCOLATE_RAISINS)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.RED_RAISINS, 1)).fi(GTFMaterials.Chocolate.getLiquid(36)).io(new ItemStack(GTFData.CHOCOLATE_RAISINS)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.PURPLE_RAISINS, 1)).fi(GTFMaterials.Chocolate.getLiquid(36)).io(new ItemStack(GTFData.CHOCOLATE_RAISINS)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.POMERAISINS, 1)).fi(GTFMaterials.Chocolate.getLiquid(36)).io(new ItemStack(GTFData.CHOCOLATE_RAISINS)).add(16);
        BATHING.RB().ii(RecipeIngredient.of(GTFData.GRILLED_RIBS, 1)).fi(GTFMaterials.BarbecueSauce.getLiquid(250)).io(new ItemStack(GTFData.BARBECUE_RIBS)).add(16);
    }
}
