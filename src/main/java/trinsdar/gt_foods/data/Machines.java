package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.machine.types.BasicMachine;
import muramasa.antimatter.machine.types.Machine;
import trinsdar.gt_foods.GTFoods;

import static muramasa.antimatter.machine.MachineFlag.FLUID;
import static muramasa.antimatter.machine.MachineFlag.GUI;
import static muramasa.antimatter.machine.MachineFlag.ITEM;

public class Machines {
    public static BasicMachine SLICER = new BasicMachine(GTFoods.MODID, "slicer").setMap(RecipeMaps.SLICING).addFlags(GUI, ITEM);

    public static void init(){
        if (!AntimatterAPI.isModLoaded("gti")){
            NonGtiMachines.init();
        }
    }

    public static class NonGtiMachines {
        public static BasicMachine MIXER = new BasicMachine(GTFoods.MODID, "mixer").setMap(RecipeMaps.NonGtiRecipeMaps.MIXING).addFlags(GUI, ITEM, FLUID);

        static void init(){}
    }
}
