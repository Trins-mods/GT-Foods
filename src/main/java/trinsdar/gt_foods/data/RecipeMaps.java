package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;
import trinsdar.gt_foods.GTFoods;

public class RecipeMaps {
    public static RecipeMap<?> SLICING = new RecipeMap<>("slicing", GTFoods.MODID, new RecipeBuilder());

    public static void init(){
        if (!AntimatterAPI.isModLoaded("gti")){
            NonGtiRecipeMaps.init();
        }
    }

    public static class NonGtiRecipeMaps{
        public static RecipeMap<?> MIXING = new RecipeMap<>("mixing", GTFoods.MODID, new RecipeBuilder());

        static void init(){

        }
    }
}
