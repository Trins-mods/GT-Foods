package trinsdar.gt_foods.loader;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.recipe.map.RecipeMap;
import trinsdar.gt_foods.GTFoods;

public class BathingLoader {

    public static void init(){

    }

    static RecipeMap<?> getBathing(){
        String domain = AntimatterAPI.isModLoaded("gt4r") ? "gt4r" : GTFoods.MODID;
        return AntimatterAPI.get(RecipeMap.class, "bathing", domain);
    }
}
