package trinsdar.gt_foods.blocks;

import muramasa.antimatter.machine.BlockMachine;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockJuicer extends BlockMachine {

    public static final VoxelShape JUICER_SHAPE = VoxelShapes.create(new AxisAlignedBB(2, 0, 2, 14, 4, 14));
    public BlockJuicer(Machine<?> type, Tier tier) {
        super(type, tier);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return JUICER_SHAPE;
    }
}
