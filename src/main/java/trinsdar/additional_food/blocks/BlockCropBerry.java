package trinsdar.additional_food.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import trinsdar.additional_food.AdditionalFood;
import trinsdar.additional_food.Registry;

public class BlockCropBerry extends SweetBerryBushBlock {
    Item berry;
    public BlockCropBerry(String berry) {
        super(Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH));
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(getItem());
    }

    public Item getItem() {
        if (this == Registry.BLUEBERRY_BUSH.get()){
            return Registry.BLUEBERRY.get();
        }
        if (this == Registry.BLACKBERRY_BUSH.get()){
            return Registry.BLACKBERRY.get();
        }
        if (this == Registry.GOOSEBERRY_BUSH.get()){
            return Registry.GOOSEBERRY.get();
        }
        if (this == Registry.RASPBERRY_BUSH.get()){
            return Registry.RASPBERRY.get();
        }
        if (this == Registry.STRAWBERRY_BUSH.get()){
            return Registry.STRAWBERRY.get();
        }
        return Items.SWEET_BERRIES;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return false;
        } else if (i > 1) {
            int j = 1 + worldIn.rand.nextInt(2);
            spawnAsEntity(worldIn, pos, new ItemStack(getItem(), j + (flag ? 1 : 0)));
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, 1), 2);
            return true;
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }
}
