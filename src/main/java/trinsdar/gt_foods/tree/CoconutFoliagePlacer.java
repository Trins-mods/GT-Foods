package trinsdar.gt_foods.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import trinsdar.gt_foods.data.GTFData;

import javax.swing.tree.TreeNode;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

public class CoconutFoliagePlacer extends FoliagePlacer {
    public static final Codec<CoconutFoliagePlacer> CODEC = RecordCodecBuilder.create((p_242834_0_) -> {
        return func_242830_b(p_242834_0_).apply(p_242834_0_, CoconutFoliagePlacer::new);
    });

    protected CoconutFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    public CoconutFoliagePlacer() {
        super(FeatureSpread.create(1), FeatureSpread.create(-1));
    }

    @Override
    protected FoliagePlacerType<?> getPlacerType() {
        return TreeWorldGen.COCONUT_FOLIAGE_PLACER;
    }

    @Override
    protected void func_230372_a_(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage treeNode, int foilageHeight, int radius, Set<BlockPos> leaves, int offset, MutableBoundingBox box) {
        generate(world, random, config, trunkHeight, treeNode, foilageHeight, radius, leaves, offset, box);
    }

    protected void generate(IWorldGenerationReader world, Random random, BaseTreeFeatureConfig config, int trunkHeight, Foliage treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, MutableBoundingBox blockBox) {

        //The origin of this leaf piece
        BlockPos center = treeNode.func_236763_a_().toMutable().move(0, offset, 0).toImmutable();

        //The working mutable position
        BlockPos.Mutable pos = new BlockPos.Mutable();

        //Determine weather this tree should have it's spiral flipped to make it have more variation among trees
        boolean flipSpiral = random.nextBoolean();

        //Place the top blocks
        checkAndSetBlockState(world, random, pos.setPos(center).move(0, 1, 0), leaves, blockBox, config);
        checkAndSetBlockState(world, random, pos.setPos(center).move(1, 1, 0), leaves, blockBox, config);
        checkAndSetBlockState(world, random, pos.setPos(center).move(0, 1, 1), leaves, blockBox, config);
        checkAndSetBlockState(world, random, pos.setPos(center).move(-1, 1, 0), leaves, blockBox, config);
        checkAndSetBlockState(world, random, pos.setPos(center).move(0, 1, -1), leaves, blockBox, config);

        //Place supports for dangly bits
        for (int dZ = -1; dZ < 2; dZ++) {
            for (int dX = -1; dX < 2; dX++) {
                checkAndSetBlockState(world, random, pos.setPos(center).move(dZ, 0, dX), leaves, blockBox, config);
                if (dX != 0 && dZ != 0){
                    if (random.nextBoolean()){
                        BlockPos currentPosition = pos.setPos(center).move(dX, -1, dZ);
                        if (TreeFeature.isAirOrLeavesAt(world, currentPosition)) {
                            world.setBlockState(currentPosition, GTFData.COCONUT_HANGING_PLANT.getDefaultState(), 19);
                        }
                    }
                }
            }
        }

        //Place 2 dangly bits in each direction
        for (int d = 0; d < 4; d++) {
            Direction direction = Direction.byHorizontalIndex(d);

            pos.setPos(center).move(direction, 2);
            placeSpiral(world, random, pos, leaves, blockBox, config, direction, !flipSpiral);

            pos.setPos(center).move(direction, 3);
            placeSpiral(world, random, pos, leaves, blockBox, config, direction, flipSpiral);
        }
    }

    private void placeSpiral(IWorldGenerationReader world, Random rand, BlockPos.Mutable pos, Set<BlockPos> leaves, MutableBoundingBox box, BaseTreeFeatureConfig config, Direction direction, boolean invertLeafSpiral) {
        //Base of dangly bit
        checkAndSetBlockState(world, rand, pos, leaves, box, config);

        //Get the direction of the twist from the direction of the branch then place a block there
        Direction spiral = spiral(direction, invertLeafSpiral);
        checkAndSetBlockState(world, rand, pos.move(spiral), leaves, box, config);

        //Continue the branch all the way down
        for (int i = 0; i < 2; i++) {
            checkAndSetBlockState(world, rand, pos.move(Direction.DOWN), leaves, box, config);
        }
    }

    private void checkAndSetBlockState(IWorldGenerationReader world, Random random, BlockPos.Mutable currentPosition, Set<BlockPos> set, MutableBoundingBox blockBox, BaseTreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeavesAt(world, currentPosition)) {
            world.setBlockState(currentPosition, config.leavesProvider.getBlockState(random, currentPosition), 19);
            blockBox.expandTo(new MutableBoundingBox(currentPosition, currentPosition));
            set.add(currentPosition.toImmutable());
        }
    }

    /**
     * @param direction the direction from the trunk the current spiraling piece needs to be calculated for
     * @param invert whether the direction of the spiral is to be inverted (this is to make variation in the trees)
     * @return the direction of the resulting twist in the direction provided
     */
    private static Direction spiral(Direction direction, boolean invert) {
        switch (direction) {
            case EAST:
                return invert ? Direction.NORTH : Direction.SOUTH;
            case WEST:
                return invert ? Direction.SOUTH : Direction.NORTH;
            case NORTH:
                return invert ? Direction.WEST : Direction.EAST;
            case SOUTH:
            default:
                return invert ? Direction.EAST : Direction.WEST;
        }
    }

    /**
     * Iterates over the positions contained with in a circle defined by origin and radius. The circle is two dimensional,
     * perpendicular to the Y axis.
     *
     * @param origin The center block of the circle; this function clobbers the variable, and it must be reset afterwards
     * @param radius The radius of the circle
     * @param consumer The target of the positions; it passes the same BlockPos.Mutable object each time
     */
    private static void square(BlockPos.Mutable origin, int radius, boolean cornerless, Consumer<BlockPos.Mutable> consumer) {
        int x = origin.getX();
        int z = origin.getZ();

        for (int rx = -radius; rx <= radius; rx++){
            for (int rz = -radius; rz <= radius; rz++){
                int abx = Math.abs(rx), abz = Math.abs(rz);
                if (cornerless){
                    if (abx == abz && abx == radius){
                        continue;
                    }
                    if (abx == radius || abz == radius){
                        if (abx == radius - 1 || abz == radius - 1){
                            continue;
                        }
                    }
                }
                origin.setPos(x + rx, origin.getY(), z + rz);
                consumer.accept(origin);
            }
        }
    }

    @Override
    public int func_230374_a_(Random random, int radius, BaseTreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean func_230373_a_(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
        return false;
    }
}
