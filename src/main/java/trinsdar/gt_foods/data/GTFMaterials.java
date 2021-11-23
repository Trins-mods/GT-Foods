package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Data;
import muramasa.antimatter.Ref;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.material.TextureSet;
import trinsdar.gt_foods.GTFoods;

import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.material.TextureSet.NONE;
import static trinsdar.gt_foods.data.GTFMaterialTypes.FLOUR;
import static trinsdar.gt_foods.data.GTFMaterialTypes.GROUND;

public class GTFMaterials {
    public static final Material StainlessSteel = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "stainless_steel", 0xc8c8dc, TextureSet.METALLIC)).flags(RING, ROD, PLATE_TINY);

    public static final Material AppleCiderVinegar = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "apple_cider_vinegar", 0xa17a00, NONE)).asFluid();
    public static final Material Mayonnaise = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "mayonnaise", 0xd0c49e, NONE)).asFluid();
    public static final Material BarbecueSauce = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "barbecue_sauce", 0x520000, NONE)).asFluid();
    public static final Material Ketchup = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "ketchup", 0x950000, NONE)).asFluid();
    public static final Material FishOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "fish_oil", 0xffc400, NONE)).asFluid(6);
    public static final Material SeedOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "seed_oil", 0xc4ff00, NONE)).asFluid(6);
    public static final Material HotFryingOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "hot_frying_oil", 0xd0aa42, NONE)).asFluid();

    public static final Material Chocolate = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "chocolate", 0x643200, NONE)).asDust(GROUND).asFluid();
    public static final Material BlackPepper = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "black_pepper", 0x282828, NONE)).asDust(GROUND);
    public static final Material Cinnamon = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "cinnamon", 0x7a5335, NONE)).asDust(GROUND);

    public static final Material Wheat = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "wheat", 0xffffc4, NONE)).flags(FLOUR);
    public static final Material Barley = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "barley", 0xc4ffc4, NONE)).flags(FLOUR);
    public static final Material Rye = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "rye", 0xffe6b4, NONE)).flags(FLOUR);
    public static final Material Rice = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "rice", 0xfcfcf0, NONE)).flags(FLOUR);
    public static final Material Oat = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "oat", 0xf0f0de, NONE)).flags(FLOUR);
    public static final Material Corn = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "corn", 0xfaf06f, NONE)).flags(FLOUR);

    public static void init(){
        
    }
}
