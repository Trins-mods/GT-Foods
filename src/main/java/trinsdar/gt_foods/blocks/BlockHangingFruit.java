package trinsdar.gt_foods.blocks;

import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import trinsdar.gt_foods.data.GTFData;

public class BlockHangingFruit extends BlockCrop{
    public BlockHangingFruit(String id, String fruit) {
        super(id, fruit, 4);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        BlockState stateAir = worldIn.getBlockState(pos.up(2));
        return state.getBlock() == Blocks.AIR && stateAir.getBlock() == GTFData.COCONUT_LEAVES;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i == 3) {
            int j = 1 + worldIn.rand.nextInt(2);
            ItemStack fruit = new ItemStack(getSeedsItem(), j);
            if (!player.addItemStackToInventory(fruit)) {
                spawnAsEntity(worldIn, pos, fruit);
            }
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            worldIn.setBlockState(pos, state.with(AGE, 0), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
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
        return !this.isMaxAge(state) && worldIn.getBlockState(pos.up()).getBlock() == GTFData.COCONUT_LEAVES;
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return 1;
    }

    @Override
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {
        prov.getBuilder(item).parent(prov.getExistingFile(new ResourceLocation("item/generated"))).texture("layer0", getTextures()[0]);
    }

    @Override
    public boolean generateItemBlock() {
        return true;
    }
}
