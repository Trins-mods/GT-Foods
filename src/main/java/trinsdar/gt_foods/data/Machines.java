package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.machine.types.BasicMachine;
import muramasa.antimatter.machine.types.Machine;
import trinsdar.gt_foods.GTFoods;

import static muramasa.antimatter.machine.MachineFlag.GUI;
import static muramasa.antimatter.machine.MachineFlag.ITEM;

public class Machines {
    public static BasicMachine SLICER = new BasicMachine(GTFoods.MODID, "slicer").setMap(RecipeMaps.SLICING).addFlags(GUI, ITEM);

    public static void init(){

    }
}
