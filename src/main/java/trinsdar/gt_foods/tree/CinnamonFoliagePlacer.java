package trinsdar.gt_foods.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

public class CinnamonFoliagePlacer extends FoliagePlacer {
    public static final Codec<CinnamonFoliagePlacer> CODEC = RecordCodecBuilder.create((p_242834_0_) -> {
        return func_242830_b(p_242834_0_).apply(p_242834_0_, CinnamonFoliagePlacer::new);
    });
    public static final FoliagePlacerType<CinnamonFoliagePlacer> CINNAMON = new FoliagePlacerType<>(CODEC);
    protected CinnamonFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public CinnamonFoliagePlacer() {
        super(FeatureSpread.create(3), FeatureSpread.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return CINNAMON;
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage treeNode, int foilageHeight, int radius, Set<BlockPos> leaves, int offset, MutableBoundingBox box) {
        generate(world, random, config, trunkHeight, treeNode, foilageHeight, radius, leaves, offset, box);
    }

    protected void generate(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, MutableBoundingBox box) {
        BlockPos center = treeNode.func_236763_a_();
        BlockPos.Mutable pos = center.toMutable();

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        double treeRadius = 3.5;
        for(int i = offset; i >= offset - foliageHeight; --i) {
            if (i == offset){
                this.func_236753_a_(world, random, config, center, 1, leaves, i, treeNode.func_236765_c_(), box);
                continue;
            }
            pos.setPos(x, y + i, z);
            circle(pos.toMutable(), treeRadius, position -> {
                if (TreeFeature.isAirOrLeavesAt(world, position)) {
                    world.setBlockState(position, config.leavesProvider.getBlockState(random, position), 19);
                    box.expandTo(new MutableBoundingBox(position, position));
                    leaves.add(position.toImmutable());
                }
            });
        }

        /*int spikeHeight = 2 + random.nextInt(3);
        for (int i = 0; i < spikeHeight; i++){
            BlockPos leaf = center.up(i);
            if (TreeFeature.isAirOrLeavesAt(world, leaf)) {
                world.setBlockState(leaf, config.leavesProvider.getBlockState(random, leaf), 19);
                box.expandTo(new MutableBoundingBox(leaf, leaf));
                leaves.add(leaf.toImmutable());
            }
        }*/

    }

    /**
     * Iterates over the positions contained with in a circle defined by origin and radius. The circle is two dimensional,
     * perpendicular to the Y axis.
     *
     * @param origin The center block of the circle; this function clobbers the variable, and it must be reset afterwards
     * @param radius The radius of the circle
     * @param consumer The target of the positions; it passes the same BlockPos.Mutable object each time
     */
    private static void circle(BlockPos.Mutable origin, double radius, Consumer<BlockPos.Mutable> consumer) {
        int x = origin.getX();
        int z = origin.getZ();

        double radiusSq = radius * radius;
        int radiusCeil = (int) Math.ceil(radius);

        for (int dz = -radiusCeil; dz <= radiusCeil; dz++) {
            int dzSq = dz * dz;

            for (int dx = -radiusCeil; dx <= radiusCeil; dx++) {
                int dxSq = dx * dx;

                if (dzSq + dxSq <= radiusSq) {
                    origin.setPos(x + dx, origin.getY(), z + dz);
                    consumer.accept(origin);
                }
            }
        }
    }

    @Override
    public int func_230374_a_(Random p_230374_1_, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
        return Math.max(2, p_230374_2_ - (3 + p_230374_1_.nextInt(2)));
    }

    @Override
    protected boolean func_230373_a_(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
        return false;
    }
}
