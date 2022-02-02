package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import trinsdar.gt_foods.data.ToolTypes;

public class GTFRegistrar extends AntimatterMod {
    public GTFRegistrar(){
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        if (event == RegistrationEvent.DATA_INIT){
            ToolTypes.init();
        }
    }

    @Override
    public int getPriority() {
        return -4000;
    }

    @Override
    public String getId() {
        return GTFoods.MODID + "_registrar";
    }

    @Override
    public void onGatherData(GatherDataEvent e) {
    }
}
