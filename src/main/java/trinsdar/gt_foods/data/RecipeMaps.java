package trinsdar.gt_foods.data;

import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;
import trinsdar.gt_foods.GTFoods;

public class RecipeMaps {
    public static RecipeMap<?> SLICING = new RecipeMap<>("slicing", GTFoods.MODID, new RecipeBuilder());

    public static void init(){}
}
