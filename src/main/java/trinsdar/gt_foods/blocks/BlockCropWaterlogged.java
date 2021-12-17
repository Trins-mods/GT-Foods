package trinsdar.gt_foods.blocks;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.registration.IModelProvider;
import muramasa.antimatter.registration.ITextureProvider;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.items.ItemBerry;

import javax.annotation.Nullable;

import static net.minecraft.state.properties.BlockStateProperties.WATERLOGGED;

import net.minecraft.block.AbstractBlock.Properties;

import java.util.function.Supplier;

public class BlockCropWaterlogged extends BlockCrop implements IWaterLoggable {

    public BlockCropWaterlogged(String id, Supplier<Item> seed, int maxAge) {
        super(id, seed, maxAge, Properties.of(Material.WATER_PLANT).noCollission().randomTicks().sound(SoundType.CROP));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(WATERLOGGED));
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        FluidState stateWater = worldIn.getFluidState(pos.above());
        BlockState stateAir = worldIn.getBlockState(pos.above(2));
        return state.getBlock() == Blocks.DIRT && stateWater.getType() == Fluids.WATER && stateAir.getBlock() == Blocks.AIR;
    }

    @Override
    public boolean canSurvive(BlockState pState, IWorldReader pLevel, BlockPos pPos) {
        FluidState stateWater = pLevel.getFluidState(pPos);
        BlockState stateAir = pLevel.getBlockState(pPos.above());
        boolean survive =  pLevel.getBlockState(pPos.below()).getBlock() == Blocks.DIRT && stateWater.getType() == Fluids.WATER && stateAir.getBlock() == Blocks.AIR;
        return super.canSurvive(pState, pLevel, pPos) && survive;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState blockstate = super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        if (!blockstate.isAir()) {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return blockstate;
    }

    @Override
    public void growCrops(World worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        worldIn.setBlock(pos, this.getStateForAge(i), 2);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return !this.isMaxAge(state) && worldIn.getBlockState(pos.above()).getBlock() == Blocks.AIR;
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return 1;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
