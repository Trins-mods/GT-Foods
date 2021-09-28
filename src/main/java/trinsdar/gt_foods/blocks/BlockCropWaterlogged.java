package trinsdar.gt_foods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import trinsdar.gt_foods.data.Data;

import javax.annotation.Nullable;

import static net.minecraft.state.properties.BlockStateProperties.WATERLOGGED;

public class BlockCropWaterlogged extends CropsBlock implements IWaterLoggable {

    public BlockCropWaterlogged() {
        super(Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(WATERLOGGED));
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        FluidState stateWater = worldIn.getFluidState(pos.up());
        BlockState stateAir = worldIn.getBlockState(pos.up(2));
        return state.getBlock() == Blocks.DIRT && stateWater.getFluid() == Fluids.WATER && stateAir.getBlock() == Blocks.AIR;
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return Data.CRANBERRY;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedsItem());
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        if (!blockstate.isAir()) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return blockstate;
    }

    @Override
    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        worldIn.setBlockState(pos, this.withAge(i), 2);
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return !this.isMaxAge(state) && worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR;
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return 1;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
