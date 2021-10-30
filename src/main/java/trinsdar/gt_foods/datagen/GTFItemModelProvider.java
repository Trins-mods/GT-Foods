package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.Data;

public class GTFItemModelProvider extends AntimatterItemModelProvider {
    public GTFItemModelProvider(DataGenerator generator) {
        super(GTFoods.MODID, "GT Foods Item Models", generator);
    }

    @Override
    protected void registerModels() {
        super.registerModels();
    }
}
