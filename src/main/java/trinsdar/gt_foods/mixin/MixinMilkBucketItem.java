package trinsdar.gt_foods.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MilkBucketItem.class)
public class MixinMilkBucketItem extends Item {
    public MixinMilkBucketItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(pLevel, pPlayer, this.content == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(pPlayer, pLevel, itemstack, raytraceresult);
        if (ret != null) return ret;
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
            return ActionResult.pass(itemstack);
        } else {
            BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
            BlockPos blockpos = blockraytraceresult.getBlockPos();
            Direction direction = blockraytraceresult.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);
            if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos1, direction, itemstack)) {
                BlockState blockstate = pLevel.getBlockState(blockpos);
                BlockPos blockpos2 = canBlockContainFluid(pLevel, blockpos, blockstate) ? blockpos : blockpos1;
                if (this.emptyBucket(pPlayer, pLevel, blockpos2, blockraytraceresult)) {
                    this.checkExtraContent(pLevel, itemstack, blockpos2);
                    if (pPlayer instanceof ServerPlayerEntity) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) pPlayer, blockpos2, itemstack);
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(this.getEmptySuccessItem(itemstack, pPlayer), pLevel.isClientSide());
                } else {
                    return ActionResult.fail(itemstack);
                }
            } else {
                return ActionResult.fail(itemstack);
            }
        }
    }

    protected ItemStack getEmptySuccessItem(ItemStack pStack, PlayerEntity pPlayer) {
        return !pPlayer.abilities.instabuild ? new ItemStack(Items.BUCKET) : pStack;
    }
}
