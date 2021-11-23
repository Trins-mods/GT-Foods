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
import java.util.function.Supplier;

public class GTFTree extends Tree {
    Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> treeFeature;
    public GTFTree(Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> treeFeature){
        this.treeFeature = treeFeature;
    }

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random rand, boolean flowers) {
        return treeFeature.get();
    }

    @Override
    public boolean growTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
        treeFeature.get().config.setFromSapling();
        if (!treeFeature.get().place(world, chunkGenerator, random, pos)) {
            world.setBlock(pos, state, 4);
            return false;
        } else
            return true;
    }
}
