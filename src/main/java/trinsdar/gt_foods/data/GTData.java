package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Data;
import muramasa.antimatter.Ref;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;
import trinsdar.gt_foods.GTFoods;

public class GTData {

    public static final Material StainlessSteel = AntimatterAPI.register(Material.class, new Material(Ref.ID, "stainless_steel", 0xc8c8dc, TextureSet.NONE)).flags(Data.RING, Data.ROD, Data.PLATE_TINY);

    public static final ItemBasic<?> SlicerBladeFrame = new ItemBasic<>(GTFoods.MODID, "slicer_blade_frame");
    public static final ItemBasic<?> FlatSlicerBlades = new ItemBasic<>(GTFoods.MODID, "flat_slicer_blades");
    public static final ItemBasic<?> GridSlicerBlades = new ItemBasic<>(GTFoods.MODID, "grid_slicer_blades");
    public static final ItemBasic<?> EigthsSlicerBlades = new ItemBasic<>(GTFoods.MODID, "eigths_slicer_blades");
    public static final ItemBasic<?> SplitSlicerBlades = new ItemBasic<>(GTFoods.MODID, "split_slicer_blades");
    public static final ItemBasic<?> HollowQuartersSlicerBlades = new ItemBasic<>(GTFoods.MODID, "hollow_quarters_slicer_blades");

    public static void init(){
    }
}
