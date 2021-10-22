package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.LanguageProvider;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.RecipeMaps;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.datagen.GTFLangProvider;

public class GTFRegistrar extends AntimatterMod {
    public GTFRegistrar(){
        AntimatterDynamics.addProvider(GTFoods.MODID, g -> new AntimatterBlockStateProvider(GTFoods.MODID, "GT Foods BlockStates", g));
        AntimatterDynamics.addProvider(GTFoods.MODID, GTFItemModelProvider::new);
        AntimatterDynamics.addProvider(GTFoods.MODID, GTFLangProvider::new);
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
