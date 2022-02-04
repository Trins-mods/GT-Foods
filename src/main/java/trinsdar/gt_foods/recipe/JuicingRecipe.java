package trinsdar.gt_foods.recipe;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import muramasa.antimatter.Ref;
import muramasa.antimatter.recipe.Recipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.RecipeConstants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class JuicingRecipe implements IRecipe<IInventory> {
    public final ItemOutput[] itemsOutput;
    @Nonnull
    public final Ingredient itemInput;
    public final FluidStack fluidOutput;
    private ResourceLocation id;
    public String mapId;

    private boolean valid;

    public static final IRecipeType<Recipe> RECIPE_TYPE = IRecipeType.register("antimatter_machine");

    public JuicingRecipe(@Nonnull Ingredient stacksInput, ItemOutput[] stacksOutput, FluidStack fluidOutput) {
        this(stacksInput, stacksOutput, fluidOutput, new ResourceLocation(GTFoods.MODID, stacksInput.getItems()[0].getItem().getRegistryName().toString() + "_" + fluidOutput.getFluid().getRegistryName().toString()));
    }

    public JuicingRecipe(@Nonnull Ingredient stacksInput, ItemOutput[] stacksOutput, FluidStack fluidOutput, ResourceLocation id) {
        this.itemInput = stacksInput;
        this.itemsOutput = stacksOutput;
        this.fluidOutput = fluidOutput;
        this.id = id;
        this.valid = true;
    }

    //After data reload this is false.
    public boolean isValid() {
        return valid;
    }

    public void invalidate() {
        if (this.id != null)
            this.valid = false;
    }

    public boolean hasOutputItems() {
        return itemsOutput != null && itemsOutput.length > 0;
    }

    public boolean hasOutputFluid() {
        return fluidOutput != null && !fluidOutput.isEmpty();
    }

    public boolean hasChances() {
        boolean chances = false;
        for (ItemOutput output : itemsOutput){
            if (output.probability < 1 && output.probability > 0){
                chances = true;
                break;
            }
        }
        //TODO change this if we add input chances?
        return chances;
    }

    public void setIds(ResourceLocation id, String map) {
        this.id = id;
        this.mapId = map;
    }

    public ItemStack[] getOutputItems() {
        return getOutputItems(true);
    }

    public ItemStack[] getOutputItems(boolean chance) {
        if (hasOutputItems()) {
            ItemStack[] outputs = cloneOutput(itemsOutput.clone());
            if (hasChances()) {
                List<ItemStack> evaluated = new ObjectArrayList<>();
                for (int i = 0; i < outputs.length; i++) {
                    if (!chance || GTFoods.RNG.nextFloat() < itemsOutput[i].probability) {
                        evaluated.add(outputs[i].copy());
                    }
                }
                outputs = evaluated.toArray(new ItemStack[0]);
            }
            return outputs;
        }
        return new ItemStack[0];
    }

    /**
     * Returns a list of items not bound by chances.
     *
     * @return list of items.
     */
    public ItemStack[] getFlatOutputItems() {
        if (hasOutputItems()) {
            ItemStack[] outputs = cloneOutput(itemsOutput.clone());
            if (hasChances()) {
                List<ItemStack> evaluated = new ObjectArrayList<>();
                for (int i = 0; i < outputs.length; i++) {
                    if (itemsOutput[i].probability < 1) continue;
                    evaluated.add(outputs[i]);
                }
                outputs = evaluated.toArray(new ItemStack[0]);
            }
            return outputs;
        }
        return new ItemStack[0];
    }

    private ItemStack[] cloneOutput(ItemOutput[] itemsOutput){
        ItemStack[] stacks = new ItemStack[itemsOutput.length];
        for (int i = 0; i < itemsOutput.length; i++){
            stacks[i] = itemsOutput[i].item;
        }
        return stacks;
    }

    @Nullable
    public FluidStack getOutputFluid() {
        return fluidOutput;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nInput Item: ").append(itemInput.toJson());
        builder.append(" \n");
        if (itemsOutput != null) {
            builder.append("Output Items: { ");
            for (int i = 0; i < itemsOutput.length; i++) {
                builder.append(itemsOutput[i].item.getHoverName()).append(" x").append(itemsOutput[i].item.getCount()).append(" Probability: ").append((itemsOutput[i].probability * 100)).append("%");
                if (i != itemsOutput.length - 1) builder.append(", ");
            }
            builder.append(" }\n");
        }
        if (fluidOutput != null) {
            builder.append("Output Fluid: ").append(fluidOutput.getFluid().getRegistryName()).append(": ").append(fluidOutput.getAmount()).append("mb");
            builder.append(" \n");
        }
        return builder.toString();
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return false;
    }

    @Override
    public ItemStack assemble(IInventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id != null ? id : new ResourceLocation(Ref.ID, "default");
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeConstants.JUICING_SERIALIZER;
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {
        return RecipeConstants.JUICING_TYPE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class ItemOutput {
        public final ItemStack item;
        public final float probability;

        public ItemOutput(ItemStack item, float probability) {
            this.item = item;
            this.probability = probability;
        }
    }
}
