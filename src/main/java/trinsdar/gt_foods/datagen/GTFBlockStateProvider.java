package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;

public class GTFBlockStateProvider extends AntimatterBlockStateProvider {
    public GTFBlockStateProvider(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
    }

    @Override
    protected void registerStatesAndModels() {
        super.registerStatesAndModels();
        GTFRegistration.all(Block.class).forEach(b -> onBlockModelBuild(b, this));
    }

    public static void onBlockModelBuild(Block block, GTFBlockStateProvider prov) {
        if (block instanceof IModelProvider) ((IModelProvider) block).onBlockModelBuild(block, prov);
    }

    public BlockModelBuilder getSimpleModel(Block block, ResourceLocation texture) {
        return getBuilder(block).parent(models().getExistingFile(loc(GTFoods.MODID, "block/preset/simple"))).texture("all", texture);
    }

    public BlockModelBuilder getSimpleModel(Block block, ResourceLocation... texture) {
        return getBuilder(block).parent(models().getExistingFile(loc(GTFoods.MODID, "block/preset/simple"))).texture("down", texture[0]).texture("up", texture[1]).texture("south", texture[2]).texture("north", texture[3]).texture("west", texture[4]).texture("east", texture[5]).texture("particle", texture[1]);
    }

    public BlockModelBuilder getLayeredModel(Block block, ResourceLocation... texture) {
        return getBuilder(block).parent(models().getExistingFile(loc(GTFoods.MODID, "block/preset/layered"))).texture("basedown", texture[0]).texture("baseup", texture[1]).texture("basesouth", texture[2]).texture("basenorth", texture[3]).texture("basewest", texture[4]).texture("baseeast", texture[5]).texture("overlaydown", texture[6]).texture("overlayup", texture[7]).texture("overlaysouth", texture[8]).texture("overlaynorth", texture[9]).texture("overlaywest", texture[10]).texture("overlayeast", texture[11]).texture("particle", texture[1]);
    }

    public BlockModelBuilder getLayeredModel(Block block, ResourceLocation base, ResourceLocation overlay) {
        return getBuilder(block).parent(models().getExistingFile(loc(GTFoods.MODID, "block/preset/layered"))).texture("base", base).texture("overlay", overlay);
    }
}
