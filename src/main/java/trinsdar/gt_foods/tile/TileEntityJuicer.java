package trinsdar.gt_foods.tile;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import muramasa.antimatter.capability.item.ITrackedHandler;
import muramasa.antimatter.capability.machine.MachineFluidHandler;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.recipe.Recipe;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import muramasa.antimatter.recipe.map.RecipeMap;
import muramasa.antimatter.tile.TileEntityMachine;
import muramasa.antimatter.tool.AntimatterToolType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import trinsdar.gt_foods.data.RecipeConstants;
import trinsdar.gt_foods.recipe.JuicingRecipe;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TileEntityJuicer extends TileEntityMachine<TileEntityJuicer> implements IInventory {
    public TileEntityJuicer(Machine<?> type) {
        super(type);
        fluidHandler.set(() -> new MachineFluidHandler<>(this, 1000, 2000, 0, 1));
    }

    @Override
    public ActionResultType onInteract(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit, @Nullable AntimatterToolType type) {
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
                this.fluidHandler.ifPresent(f -> {
                    if (!recipe.fluidOutput.isEmpty()) {
                        f.fillOutput(recipe.fluidOutput, IFluidHandler.FluidAction.EXECUTE);
                    }
                });
                return ActionResultType.SUCCESS;
            }
        }
        return super.onInteract(state, world, pos, player, hand, hit, type);
    }

    @SuppressWarnings("unchecked")
    public Optional<JuicingRecipe> getRecipeFor(ItemStack toMatch) {
        return RecipeConstants.JUICING_SERIALIZER.getRecipes(level).stream().flatMap((r) -> Util.toStream(r.itemInput.test(toMatch) ? Optional.of(r) : Optional.empty())).findFirst();
    }

    public boolean canOutput(JuicingRecipe recipe) {
        return !this.fluidHandler.isPresent() || recipe.fluidOutput.isEmpty() || this.fluidHandler.map(t -> t.canOutputsFit(new FluidStack[]{recipe.fluidOutput})).orElse(false);
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
}
