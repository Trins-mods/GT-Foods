package trinsdar.gt_foods.datagen;


import muramasa.antimatter.client.AntimatterModelManager;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;

public class GTFItemModelProvider extends AntimatterItemModelProvider {
    public GTFItemModelProvider(DataGenerator generator) {
        super(GTFoods.MODID, "GT Foods Item Models", generator);
    }

    @Override
    protected void registerModels() {
        super.registerModels();
        GTFRegistration.all(Item.class).forEach(i -> onItemModelBuild(i, this));
        GTFRegistration.all(Block.class).forEach(b -> onItemModelBuild(b, this));
    }

    public static void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {
        if (item instanceof IModelProvider) ((IModelProvider) item).onItemModelBuild(item, prov);
    }
}
