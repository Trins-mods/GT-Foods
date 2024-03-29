package trinsdar.gt_foods.data;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockCropBerry;

public class GTFConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> BLUEBERRY_BUSH = createConfiguredFeature("blueberry_bush", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.BLUEBERRY_BUSH.defaultBlockState().setValue(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).noProjection().build()));
    public static final ConfiguredFeature<?, ?> BLUEBERRY_BUSHES = createConfiguredFeature("blueberry_bushes", BLUEBERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> LUSH_BLUEBERRY_BUSHES = createConfiguredFeature("lush_blueberry_bushes", BLUEBERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).chance(12));
    public static final ConfiguredFeature<?, ?> BLACKBERRY_BUSH = createConfiguredFeature("blackberry_bush", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.BLACKBERRY_BUSH.defaultBlockState().setValue(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).noProjection().build()).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> GOOSEBERRY_BUSH = createConfiguredFeature("gooseberry_bush", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.GOOSEBERRY_BUSH.defaultBlockState().setValue(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).noProjection().build()).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> RASPBERRY_BUSH = createConfiguredFeature("raspberry_bush", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.RASPBERRY_BUSH.defaultBlockState().setValue(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).noProjection().build()).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> STRAWBERRY_BUSH = createConfiguredFeature("strawberry_bush", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.STRAWBERRY_BUSH.defaultBlockState().setValue(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).noProjection().build()).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));

    public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation gtfID = new ResourceLocation(GTFoods.MODID, id);
        if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(gtfID))
            throw new IllegalStateException("Configured Feature ID: \"" + gtfID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, gtfID, configuredFeature);
        return configuredFeature;
    }

    public static void init(){

    }
}
