package trinsdar.gt_foods.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;

import java.util.function.Supplier;

public class BlockHangingFruit extends BlockCrop{
    public BlockHangingFruit(String id, Supplier<Item> fruit) {
        super(id, fruit, 3);
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        BlockState stateAir = worldIn.getBlockState(pos.above(2));
        return state.getBlock() == Blocks.AIR && stateAir.getBlock() == GTFData.COCONUT_LEAVES;
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i == 3) {
            int j = 1 + worldIn.random.nextInt(2);
            ItemStack fruit = new ItemStack(getBaseSeedId(), j);
            if (!player.addItem(fruit)) {
                popResource(worldIn, pos, fruit);
            }
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            worldIn.setBlock(pos, state.setValue(AGE, 0), 2);
            return ActionResultType.sidedSuccess(worldIn.isClientSide);
        } else {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
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
        return !this.isMaxAge(state) && worldIn.getBlockState(pos.above()).getBlock() == GTFData.COCONUT_LEAVES;
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return 1;
    }

    @Override
    public void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {
        prov.getBuilder(item).parent(prov.getExistingFile(new ResourceLocation("item/generated"))).texture("layer0", getTextures()[0]);
    }
}
