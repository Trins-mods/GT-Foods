package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeBuilder;
import muramasa.antimatter.recipe.map.RecipeMap;
import net.minecraftforge.fml.ModList;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.recipe.JuicingRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeMaps {

    private static List<JuicingRecipe> JUICING_RECIPES = new ArrayList<>();

    public static RecipeMap<?> JUICING = AntimatterAPI.register(RecipeMap.class, new RecipeMap<>(GTFoods.MODID, "juicing", new RecipeBuilder()));

    public static void init(){
        if (ModList.get().isLoaded("antimatter")){
            AntimatterMaps.init();
        }
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
