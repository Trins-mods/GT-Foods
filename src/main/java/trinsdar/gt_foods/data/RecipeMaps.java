package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;
import trinsdar.gt_foods.GTFoods;

public class RecipeMaps {

    //public static RecipeMap<?> JUICING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "juicing", new RecipeBuilder()));

    public static void init(){
    }

    public static class AntimatterMaps {

        public static RecipeMap<?> SLICING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "slicing", new RecipeBuilder()));
        public static RecipeMap<?> MIXING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "mixing", new RecipeBuilder()));
        public static RecipeMap<?> BATHING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "bathing", new RecipeBuilder()));
        public static RecipeMap<?> FERMENTING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "fermenting", new RecipeBuilder()));

        public static void init(){

        }
    }
}
