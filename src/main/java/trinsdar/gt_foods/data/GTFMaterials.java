package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Data;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.material.TextureSet;
import trinsdar.gt4r.Ref;
import trinsdar.gt_foods.GTFoods;

import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.material.TextureSet.FINE;
import static muramasa.antimatter.material.TextureSet.NONE;
import static trinsdar.gt_foods.data.GTFMaterialTypes.FLOUR;
import static trinsdar.gt_foods.data.GTFMaterialTypes.GROUND;

public class GTFMaterials {
    public static final Material StainlessSteel = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "stainless_steel", 0xc8c8dc, TextureSet.METALLIC)).flags(RING, ROD, PLATE_TINY);

    public static final Material AppleCiderVinegar = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "apple_cider_vinegar", 0xa17a00, NONE)).asFluid();
    public static final Material Mayonnaise = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "mayonnaise", 0xd0c49e, NONE)).asFluid();
    public static final Material BarbecueSauce = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "barbecue_sauce", 0x520000, NONE)).asFluid();
    public static final Material ChiliSauce = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "chili_sauce", 0xb50000, NONE)).asFluid();
    public static final Material Ketchup = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "ketchup", 0x950000, NONE)).asFluid();
    public static final Material FishOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "fish_oil", 0xffc400, NONE)).asFluid(6);
    public static final Material SeedOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "seed_oil", 0xc4ff00, NONE)).asFluid(6);
    public static final Material NutOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "nut_oil", 0xeaaa40, NONE)).asFluid();
    public static final Material HotFryingOil = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "hot_frying_oil", 0xd0aa42, NONE)).asFluid();
    public static final Material Milk = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "milk", 0xfefefe, NONE)).asFluid();

    public static final Material Chocolate = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "chocolate", 0x643200, NONE)).asDust(GROUND).asFluid();
    public static final Material BlackPepper = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "black_pepper", 0x282828, NONE)).asDust(GROUND);
    public static final Material Cinnamon = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "cinnamon", 0x7a5335, NONE)).asDust(GROUND);
    public static final Material Cocoa = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "cocoa", 0xbe5f00, NONE)).asDust(GROUND);
    public static final Material Coffee = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "coffee", 0x964b00, NONE)).asDust(GROUND);
    public static final Material Chili = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "chili", 0xc80000, NONE)).asDust(GROUND);
    public static final Material Nutmeg = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "nutmeg", 0xf0dcb4, NONE).asDust(GROUND));
    public static final Material Peanut = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "peanut", 0xf0d2a0, NONE).asDust(GROUND));
    public static final Material Hazelnut = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "hazelnut", 0xf0c88c, NONE).asDust(GROUND));
    public static final Material FishMeal = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "fishmeal", 0xff9664, NONE).asDust(GROUND));
    public static final Material Salt = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "salt", 0xfafafa, FINE)).asDust();

    public static final Material Wheat = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "wheat", 0xffffc4, NONE)).flags(FLOUR);
    public static final Material Barley = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "barley", 0xc4ffc4, NONE)).flags(FLOUR);
    public static final Material Rye = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "rye", 0xffe6b4, NONE)).flags(FLOUR);
    public static final Material Rice = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "rice", 0xfcfcf0, NONE)).flags(FLOUR);
    public static final Material Oat = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "oat", 0xf0f0de, NONE)).flags(FLOUR);
    public static final Material Corn = AntimatterAPI.register(Material.class, new Material(GTFoods.MODID, "corn", 0xfaf06f, NONE)).flags(FLOUR);

    public static void init(){
        
    }
}
