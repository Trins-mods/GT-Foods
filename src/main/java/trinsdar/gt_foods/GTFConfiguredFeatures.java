package trinsdar.gt_foods;

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
import trinsdar.gt_foods.blocks.BlockCropBerry;

public class GTFConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> BLUEBERRY_BUSH = createConfiguredFeature("blueberry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Data.BLUEBERRY_BUSH.getDefaultState().with(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).preventProjection().build()));
    public static final ConfiguredFeature<?, ?> BLUEBERRY_BUSHES = createConfiguredFeature("blueberry_bushes", BLUEBERRY_BUSH.withPlacement(Features.Placements.PATCH_PLACEMENT));
    public static final ConfiguredFeature<?, ?> LUSH_BLUEBERRY_BUSHES = createConfiguredFeature("lush_blueberry_bushes", BLUEBERRY_BUSH.withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
    public static final ConfiguredFeature<?, ?> BLACKBERRY_BUSH = createConfiguredFeature("blackberry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Data.BLACKBERRY_BUSH.getDefaultState().with(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.PATCH_PLACEMENT));
    public static final ConfiguredFeature<?, ?> GOOSEBERRY_BUSH = createConfiguredFeature("gooseberry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Data.GOOSEBERRY_BUSH.getDefaultState().with(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.PATCH_PLACEMENT));
    public static final ConfiguredFeature<?, ?> RASPBERRY_BUSH = createConfiguredFeature("raspberry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Data.RASPBERRY_BUSH.getDefaultState().with(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.PATCH_PLACEMENT));
    public static final ConfiguredFeature<?, ?> STRAWBERRY_BUSH = createConfiguredFeature("strawberry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Data.STRAWBERRY_BUSH.getDefaultState().with(BlockCropBerry.AGE, 3)), new SimpleBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.PATCH_PLACEMENT));

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
