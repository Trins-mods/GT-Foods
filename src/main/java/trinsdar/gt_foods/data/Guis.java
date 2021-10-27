package trinsdar.gt_foods.data;

import static muramasa.antimatter.gui.SlotType.ENERGY;
import static muramasa.antimatter.gui.SlotType.IT_IN;
import static muramasa.antimatter.gui.SlotType.IT_OUT;

public class Guis {

    public static void init(){
        Machines.SLICER.add(IT_IN, 35, 25).add(IT_IN, 53, 25).add(IT_OUT, 107, 25).add(IT_OUT, 125, 25).add(ENERGY,80, 63);
    }
}
