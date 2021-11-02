package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.data.DataGenerator;
import trinsdar.gt_foods.GTFoods;

public class GTFItemModelProvider extends AntimatterItemModelProvider {
    public GTFItemModelProvider(DataGenerator generator) {
        super(GTFoods.MODID, "GT Foods Item Models", generator);
    }

    @Override
    protected void registerModels() {
        super.registerModels();
    }
}
