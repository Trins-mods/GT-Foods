package trinsdar.gt_foods.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import trinsdar.gt_foods.data.GTFMaterials;

import javax.annotation.Nullable;

@Mixin(MilkBucketItem.class)
public abstract class MixinMilkBucketItem extends Item {
    private MixinMilkBucketItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }


    /*@Override
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ActionResult<ItemStack> result = useBucket(pLevel, pPlayer, pHand);
        if (result.getResult() == ActionResultType.SUCCESS){
            return result;
        }
        return super.use(pLevel, pPlayer, pHand);
    }*/

    @Inject(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;", at = @At("HEAD"), cancellable = true)
    public void inject_useBucket_gtf(World pLevel, PlayerEntity pPlayer, Hand pHand, CallbackInfoReturnable<ActionResult<ItemStack>> callbackInfoReturnable){
        ActionResult<ItemStack> result = useBucket(pLevel, pPlayer, pHand);
        if (result.getResult() == ActionResultType.SUCCESS){
            callbackInfoReturnable.setReturnValue(result);
        }

    }

    public ActionResult<ItemStack> useBucket(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(pLevel, pPlayer, RayTraceContext.FluidMode.NONE);
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

    public void checkExtraContent(World p_203792_1_, ItemStack p_203792_2_, BlockPos p_203792_3_) {
    }

    public boolean emptyBucket(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockRayTraceResult result) {
        if (!(this.getFluid() instanceof FlowingFluid)) {
            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos);
            Block block = blockstate.getBlock();
            Material material = blockstate.getMaterial();
            boolean flag = blockstate.canBeReplaced(this.getFluid());
            boolean flag1 = blockstate.isAir() || flag || block instanceof ILiquidContainer && ((ILiquidContainer)block).canPlaceLiquid(world, pos, blockstate, this.getFluid());
            if (!flag1) {
                return result != null && this.emptyBucket(player, world, result.getBlockPos().relative(result.getDirection()), (BlockRayTraceResult)null);
            } else if (block instanceof ILiquidContainer && ((ILiquidContainer)block).canPlaceLiquid(world,pos,blockstate,getFluid())) {
                ((ILiquidContainer)block).placeLiquid(world, pos, blockstate, ((FlowingFluid)this.getFluid()).getSource(false));
                this.playEmptySound(player, world, pos);
                return true;
            } else {
                if (!world.isClientSide && flag && !material.isLiquid()) {
                    world.destroyBlock(pos, true);
                }

                if (!world.setBlock(pos, this.getFluid().defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
                    return false;
                } else {
                    this.playEmptySound(player, world, pos);
                    return true;
                }
            }
        }
    }

    protected void playEmptySound(@Nullable PlayerEntity pPlayer, IWorld pLevel, BlockPos pPos) {
        SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
        if(soundevent == null) soundevent = SoundEvents.BUCKET_EMPTY;
        pLevel.playSound(pPlayer, pPos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundNBT nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }

    public Fluid getFluid() { return GTFMaterials.Milk.getLiquid(); }

    private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate)
    {
        return blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer)blockstate.getBlock()).canPlaceLiquid(worldIn, posIn, blockstate, this.getFluid());
    }
}
