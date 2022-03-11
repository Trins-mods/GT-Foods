package trinsdar.gt_foods.tile;

import muramasa.antimatter.tile.TileEntityMachine;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import trinsdar.gt_foods.data.RecipeConstants;
import trinsdar.gt_foods.data.TileEntityTypes;
import trinsdar.gt_foods.recipe.JuicingRecipe;

import javax.annotation.Nonnull;
import java.util.Optional;

public class TileEntityJuicer extends TileEntity implements IInventory {
    LazyOptional<JuicerTank> tank = LazyOptional.of(() -> new JuicerTank(1000));
    public TileEntityJuicer() {
        super(TileEntityTypes.JUICER_TYPE);
    }

    public ActionResultType onInteract(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack held = player.getItemInHand(hand);
        if (!held.isEmpty()){
            JuicingRecipe recipe = getRecipeFor(held).orElse(null);
            if (recipe != null && canOutput(recipe)){
                held.shrink(1);
                for (ItemStack o : recipe.getOutputItems()) {
                    if (!player.addItem(o)){
                        player.drop(o, false);
                    }
                }
                this.tank.ifPresent(f -> {
                    if (!recipe.fluidOutput.isEmpty()) {
                        f.fillInternal(recipe.fluidOutput, IFluidHandler.FluidAction.EXECUTE);
                    }
                });
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    public void setRemoved() {
        this.tank.invalidate();
        super.setRemoved();
    }

    @SuppressWarnings("unchecked")
    public Optional<JuicingRecipe> getRecipeFor(ItemStack toMatch) {
        return RecipeConstants.JUICING_SERIALIZER.getRecipes(level).stream().flatMap((r) -> Util.toStream(r.itemInput.test(toMatch) ? Optional.of(r) : Optional.empty())).findFirst();
    }

    public boolean canOutput(JuicingRecipe recipe) {
        return recipe.fluidOutput.isEmpty() || this.tank.map(t -> t.getFluid().getAmount() + recipe.fluidOutput.getAmount() <= t.getCapacity()).orElse(false);
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {

    }

    @Override
    public boolean stillValid(PlayerEntity pPlayer) {
        return false;
    }

    @Override
    public void clearContent() {

    }

    public static class JuicerTank extends FluidTank{

        public JuicerTank(int capacity) {
            super(capacity);
        }

        @Override
        public int fill(FluidStack resource, FluidAction action) {
            return 0;
        }

        public int fillInternal(FluidStack resource, FluidAction action){
            return super.fill(resource, action);
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return tank.cast();
        return super.getCapability(cap, side);
    }
}
