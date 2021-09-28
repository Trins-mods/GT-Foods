package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.RecipeMaps;

public class GTFRegistrar extends AntimatterMod {
    public GTFRegistrar(){
        AntimatterDynamics.addProvider(GTFoods.MODID, g -> new AntimatterBlockStateProvider(GTFoods.MODID, "GT Foods BlockStates", g));
        AntimatterDynamics.addProvider(GTFoods.MODID, g -> new AntimatterItemModelProvider(GTFoods.MODID, "GT Foods Item Models", g));
        AntimatterDynamics.addProvider(GTFoods.MODID, g -> new AntimatterLanguageProvider(GTFoods.MODID, "GT Foods en_us Localization", "en_us", g));
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        if (event == RegistrationEvent.DATA_INIT){
            RecipeMaps.init();
            Machines.init();
        }
    }

    @Override
    public int getPriority() {
        return -4000;
    }

    @Override
    public String getId() {
        return GTFoods.MODID;
    }
}
