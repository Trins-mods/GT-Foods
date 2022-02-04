package trinsdar.gt_foods.loader;

import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.data.RecipeMaps;

public class FermenterLoader {
    public static void init(){
        RecipeMaps.AntimatterMaps.FERMENTING.RB().fi(GTFMaterials.AppleJuice.getLiquid(50)).fo(GTFMaterials.AppleCider.getLiquid(25)).add(64, 16);
        RecipeMaps.AntimatterMaps.FERMENTING.RB().fi(GTFMaterials.AppleCider.getLiquid(10)).fo(GTFMaterials.AppleCiderVinegar.getLiquid(2)).add(25, 16);
    }
}
