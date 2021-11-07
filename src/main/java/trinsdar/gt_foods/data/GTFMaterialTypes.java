package trinsdar.gt_foods.data;

import muramasa.antimatter.Ref;
import muramasa.antimatter.material.IMaterialTag;
import muramasa.antimatter.material.MaterialTag;
import muramasa.antimatter.material.MaterialTypeItem;

import static muramasa.antimatter.Data.DUST_SMALL;
import static muramasa.antimatter.Data.DUST_TINY;

public class GTFMaterialTypes {
    public static final IMaterialTag GROUND = new MaterialTag("ground");
    public static final MaterialTypeItem<?> FLOUR = new MaterialTypeItem<>("flour", 1, true, Ref.U);


    public static void init(){
        FLOUR.dependents(DUST_SMALL, DUST_TINY);
    }
}
