package trinsdar.gt_foods.tree;

import muramasa.antimatter.worldgen.AntimatterWorldGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import trinsdar.gt_foods.GTFoods;

import java.util.Random;

public class GTFTreeFeature extends TreeFeature {
    public GTFTreeFeature() {
        super(BaseTreeFeatureConfig.CODEC);
        this.setRegistryName(new ResourceLocation(GTFoods.MODID, "tree"));
    }

    public static void init() {
        //AntimatterWorldGenerator.register(TreeWorldGen::onEvent, "tree", GTFoods.MODID, RubberTreeWorldGen.getValidBiomesStatic());
    }
}
