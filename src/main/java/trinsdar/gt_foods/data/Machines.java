package trinsdar.gt_foods.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.machine.MachineFlag;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.BasicMachine;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.texture.IOverlayTexturer;
import muramasa.antimatter.texture.ITextureHandler;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Block;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockJuicer;
import trinsdar.gt_foods.tile.TileEntityJuicer;

import static muramasa.antimatter.machine.MachineFlag.FLUID;
import static muramasa.antimatter.machine.MachineFlag.GUI;
import static muramasa.antimatter.machine.MachineFlag.ITEM;

public class Machines {
    private static ITextureHandler J = (m, t) -> new Texture[] {
                new Texture(GTFoods.MODID, "block/juicer/bottom"),
                new Texture(GTFoods.MODID, "block/juicer/middletop"),
                new Texture(GTFoods.MODID, "block/juicer/sides"),
                new Texture(GTFoods.MODID, "block/juicer/sides"),
                new Texture(GTFoods.MODID, "block/juicer/sides"),
                new Texture(GTFoods.MODID, "block/juicer/sides"),
    };
    private static IOverlayTexturer O = (m, s, t) -> {
        Texture tex = new Texture(Ref.ID, "block/machine/overlay/invalid/back");
        return new Texture[]{tex, tex, tex, tex, tex, tex};
    };
    public static BasicMachine SLICER = new BasicMachine(GTFoods.MODID, "slicer").setMap(RecipeMaps.SLICING).addFlags(GUI, ITEM);
    public static BasicMachine JUICER = new Juicer(GTFoods.MODID, "juicer").setMap(RecipeMaps.JUICING).addFlags(ITEM, FLUID).setTiers(Tier.LV).baseTexture(J).renderContainedLiquids().noCovers().overlayTexture(O).setTile(m -> () -> new TileEntityJuicer(m));

    public static void init(){
        MachineFlag.ENERGY.remove(JUICER);
        MachineFlag.COVERABLE.remove(JUICER);

        if (!AntimatterAPI.isModLoaded("gti")){
            NonGtiMachines.init();
        }

        if (!AntimatterAPI.isModLoaded("gt4r")){
            NonGt4rMachines.init();
        }
    }

    public static class NonGtiMachines {
        public static BasicMachine MIXER = new BasicMachine(GTFoods.MODID, "mixer").setMap(RecipeMaps.MIXING).addFlags(GUI, ITEM, FLUID);

        static void init(){}
    }

    public static class NonGt4rMachines {
        public static BasicMachine BATH = new BasicMachine(GTFoods.MODID, "bath").setMap(RecipeMaps.BATHING).addFlags(GUI, ITEM, FLUID);
        static void init(){}
    }

    public static class Juicer extends BasicMachine {
        public Juicer(String domain, String id) {
            super(domain, id);
        }

        @Override
        protected Block getBlock(Machine<BasicMachine> type, Tier tier) {
            return new BlockJuicer(type, tier);
        }
    }
}
