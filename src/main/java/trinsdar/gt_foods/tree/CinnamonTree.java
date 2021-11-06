package trinsdar.gt_foods.tree;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CinnamonTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random rand, boolean flowers) {
        return TreeWorldGen.CONFIGURED_CINNAMON_TREE_FEATURE;
    }

    @Override
    public boolean attemptGrowTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredFeature = TreeWorldGen.CONFIGURED_CINNAMON_TREE_FEATURE;
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
        configuredFeature.config.forcePlacement();
        if (!configuredFeature.generate(world, chunkGenerator, random, pos)) {
            world.setBlockState(pos, state, 4);
            return false;
        } else
            return true;
    }
}
