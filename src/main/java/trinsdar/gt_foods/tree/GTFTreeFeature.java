package trinsdar.gt_foods.tree;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import trinsdar.gt_foods.GTFoods;

public class GTFTreeFeature extends TreeFeature {
    public GTFTreeFeature() {
        super(BaseTreeFeatureConfig.CODEC);
        this.setRegistryName(new ResourceLocation(GTFoods.MODID, "tree"));
    }

    public static void init() {
        //AntimatterWorldGenerator.register(TreeWorldGen::onEvent, "tree", GTFoods.MODID, RubberTreeWorldGen.getValidBiomesStatic());
    }
}
