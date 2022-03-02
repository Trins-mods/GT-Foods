package trinsdar.gt_foods.tree;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockFloweringLeaves;
import trinsdar.gt_foods.data.GTFData;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TreeWorldGen {
    public static final WeightedBlockStateProvider HAZEL_LEAF_BLOCKS = new WeightedBlockStateProvider().add(GTFData.HAZEL_LEAVES.defaultBlockState().setValue(BlockFloweringLeaves.FLOWERING, 1), 1).add(GTFData.HAZEL_LEAVES.defaultBlockState(), 9);
    public static final FoliagePlacerType<CinnamonFoliagePlacer> CINNAMON_FOLIAGE_PLACER = new CustomFoliagePlacerType<>("cinnamon", CinnamonFoliagePlacer.CODEC);
    public static final FoliagePlacerType<CoconutFoliagePlacer> COCONUT_FOLIAGE_PLACER = new CustomFoliagePlacerType<>("coconut", CoconutFoliagePlacer.CODEC);
    public static final FoliagePlacerType<HazelFoliagePlacer> HAZEL_FOLIAGE_PLACER = new CustomFoliagePlacerType<>("hazel", HazelFoliagePlacer.CODEC);
    public static final FoliagePlacerType<LemonFoliagePlacer> LEMON_FOLIAGE_PLACER = new CustomFoliagePlacerType<>("lemon", LemonFoliagePlacer.CODEC);
    final static BaseTreeFeatureConfig CINNAMON_TREE_CONFIG =
            (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.CINNAMON_LOG.defaultBlockState()), new SimpleBlockStateProvider(GTFData.CINNAMON_LEAVES.defaultBlockState()),
                    new CinnamonFoliagePlacer(), new StraightTrunkPlacer(6, 3, 0), new TwoLayerFeature(1, 0, 2))).ignoreVines().build();
    final static BaseTreeFeatureConfig HAZEL_TREE_CONFIG =
            (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.HAZEL_LOG.defaultBlockState()), HAZEL_LEAF_BLOCKS,
                    new HazelFoliagePlacer(), new StraightTrunkPlacer(3, 0, 0), new TwoLayerFeature(1, 0, 2))).ignoreVines().build();
    final static BaseTreeFeatureConfig LEMON_TREE_CONFIG =
            (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.HAZEL_LOG.defaultBlockState()), HAZEL_LEAF_BLOCKS,
                    new LemonFoliagePlacer(), new StraightTrunkPlacer(4, 0, 0), new TwoLayerFeature(1, 0, 2))).ignoreVines().build();
    final static BaseTreeFeatureConfig COCONUT_TREE_CONFIG =
            (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(GTFData.COCONUT_LOG.defaultBlockState()), new SimpleBlockStateProvider(GTFData.COCONUT_LEAVES.defaultBlockState()),
                    new CoconutFoliagePlacer(), new StraightTrunkPlacer(8, 2, 0), new TwoLayerFeature(1, 0, 2))).ignoreVines().build();
    public static final GTFTreeFeature TREE_FEATURE = new GTFTreeFeature();
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONFIGURED_CINNAMON_TREE_FEATURE = register("configured_cinnamon_tree", TREE_FEATURE.configured(CINNAMON_TREE_CONFIG));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONFIGURED_HAZEL_TREE_FEATURE = register("configured_hazel_tree", TREE_FEATURE.configured(HAZEL_TREE_CONFIG));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONFIGURED_LEMON_TREE_FEATURE = register("configured_lemon_tree", TREE_FEATURE.configured(LEMON_TREE_CONFIG));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONFIGURED_COCONUT_TREE_FEATURE = register("configured_coconut_tree", TREE_FEATURE.configured(COCONUT_TREE_CONFIG));


    public static ConfiguredFeature<BaseTreeFeatureConfig,?> register(String id, ConfiguredFeature<BaseTreeFeatureConfig,?> feature){
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(GTFoods.MODID, id), feature);
    }

    public static void init(){

    }

    public static class RubberTreePlacement extends Placement<AtSurfaceWithExtraConfig> {
        public RubberTreePlacement() {
            super(AtSurfaceWithExtraConfig.CODEC);
        }
        @Override
        public Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random random, AtSurfaceWithExtraConfig config, BlockPos pos) {
            int i = config.count;
            if (random.nextDouble() < config.extraChance) {
                i = random.nextInt(config.extraCount) + config.extraCount;
            }
            return IntStream.range(0, i).mapToObj((ix) -> {
                int j = random.nextInt(16) + pos.getX();
                int k = random.nextInt(16) + pos.getZ();
                return new BlockPos(j, helper.getHeight(Heightmap.Type.MOTION_BLOCKING, j, k), k);
            });
        }


    }
}
