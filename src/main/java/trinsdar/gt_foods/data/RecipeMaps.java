package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;

public class RecipeMaps {
    public static RecipeMap<?> SLICING = AntimatterAPI.registerIfAbsent(RecipeMap.class, "slicing", () -> new RecipeMap<>("slicing", new RecipeBuilder()));

    public static void init(){}
}
