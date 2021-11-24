package trinsdar.gt_foods.tile;

import muramasa.antimatter.capability.machine.MachineFluidHandler;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.tile.TileEntityMachine;

public class TileEntityJuicer extends TileEntityMachine<TileEntityJuicer> {
    public TileEntityJuicer(Machine<?> type) {
        super(type);
        fluidHandler.set(() -> new MachineFluidHandler<>(this));
    }
}
