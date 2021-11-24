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
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class TileEntityJuicer extends TileEntityMachine<TileEntityJuicer> {
    public TileEntityJuicer(Machine<?> type) {
        super(type);
        fluidHandler.set(() -> new MachineFluidHandler<>(this, 1000, 2000, 0, 1));
    }

    @Override
    public ActionResultType onInteract(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit, @Nullable AntimatterToolType type) {
        ItemStack held = player.getItemInHand(hand);
        this.recipeHandler.ifPresent(r -> {
            if (!held.isEmpty()){
                RecipeMap<?> map = getMachineType().getRecipeMap();
                Recipe recipe = map != null ? map.find(new ItemStack[]{held}, new FluidStack[0], re -> !consumeInputs(re.getInputItems(), player, hand, true).isEmpty()) : null;
                if (recipe != null){
                    List<ItemStack> inputs = consumeInputs(recipe.getInputItems(), player, hand, false);
                    inputs.forEach(i -> {
                        if (!player.addItem(i)){
                            player.drop(i, false);
                        }
                    });
                }
            }
        });
        return super.onInteract(state, world, pos, player, hand, hit, type);
    }

    public List<ItemStack> consumeInputs(List<RecipeIngredient> items, PlayerEntity player, Hand hand, boolean simulate) {
        if (items == null) return Collections.emptyList();
        ItemStack compare = player.getItemInHand(hand);
        List<ItemStack> consumedItems = new ObjectArrayList<>();

        boolean success = items.stream().mapToInt(input -> {
            int failed = 0;
            int countToReach = input.count;
            if (input.get().test(compare) && compare.getCount() >= countToReach) {
                int toConsume = Math.min(compare.getCount(), Math.max(countToReach - compare.getCount(), countToReach));
                ItemStack copy = compare.copy();
                copy.setCount(toConsume);
                consumedItems.add(copy);
                if (!input.ignoreConsume() && !simulate) compare.shrink(toConsume);
                if (compare.getCount() == 0) player.setItemInHand(hand, ItemStack.EMPTY);
            }
            return failed;
        }).sum() == 0;
        if (simulate) return success ? consumedItems : Collections.emptyList();
        return consumedItems;
    }
}
