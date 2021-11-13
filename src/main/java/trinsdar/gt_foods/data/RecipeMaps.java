package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;
import trinsdar.gt_foods.GTFoods;

public class RecipeMaps {
    public static RecipeMap<?> SLICING = new RecipeMap<>(GTFoods.MODID, "slicing", new RecipeBuilder());

    public static void init(){
        if (!AntimatterAPI.isModLoaded("gti")){
            NonGtiRecipeMaps.init();
        }

        if (!AntimatterAPI.isModLoaded("gt4r")){
            NonGt4rRecipeMaps.init();
        }
    }

    public static class NonGtiRecipeMaps{
        public static RecipeMap<?> MIXING = new RecipeMap<>(GTFoods.MODID, "mixing", new RecipeBuilder());

        static void init(){

        }
    }

    public static class NonGt4rRecipeMaps{
        public static RecipeMap<?> BATHING = new RecipeMap<>(GTFoods.MODID, "bathing", new RecipeBuilder());

        static void init(){

        }
    }
}
