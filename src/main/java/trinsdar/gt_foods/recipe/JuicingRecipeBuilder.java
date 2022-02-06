package trinsdar.gt_foods.recipe;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fluids.FluidStack;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.RecipeConstants;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class JuicingRecipeBuilder {
    private JuicingRecipe.ItemOutput[] results = new JuicingRecipe.ItemOutput[0];
    private final Ingredient ingredient;
    private final FluidStack fluidOutput;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();

    private JuicingRecipeBuilder(FluidStack resultIn, Ingredient ingredientIn) {
        this.fluidOutput = resultIn;
        this.ingredient = ingredientIn;
    }

    public static JuicingRecipeBuilder juicingRecipe(Ingredient ingredientIn, FluidStack resultIn) {
        return new JuicingRecipeBuilder(resultIn, ingredientIn);
    }

    public JuicingRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
        this.advancementBuilder.addCriterion(name, criterionIn);
        return this;
    }

    public JuicingRecipeBuilder addItemOutputsWithChances(ImmutableMap<ItemStack, Float> outputs) {
        JuicingRecipe.ItemOutput[] outputs1 = new JuicingRecipe.ItemOutput[outputs.size()];
        for (int i = 0; i < outputs.size(); i ++){
            outputs1[i] = new JuicingRecipe.ItemOutput(outputs.entrySet().asList().get(i).getKey(), outputs.entrySet().asList().get(i).getValue());
        }
        this.results = outputs1;
        return this;
    }

    public JuicingRecipeBuilder addItemOutputs(ItemStack... outputs) {
        JuicingRecipe.ItemOutput[] outputs1 = new JuicingRecipe.ItemOutput[outputs.length];
        for (int i = 0; i < outputs.length; i ++){
            outputs1[i] = new JuicingRecipe.ItemOutput(outputs[i], 1);
        }
        this.results = outputs1;
        return this;
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = new ResourceLocation(GTFoods.MODID, save);
        this.build(consumerIn, resourcelocation);
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id) {
        this.validate(id);
        this.advancementBuilder.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(IRequirementsStrategy.OR);
        consumerIn.accept(new Result(id , this.ingredient, this.results, this.fluidOutput, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/juicer/" + id.getPath())));
    }

    /**
     * Makes sure that this obtainable.
     */
    private void validate(ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public static class Result implements IFinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient ingredient;
        private final JuicingRecipe.ItemOutput[] results;
        private final FluidStack fluidOutput;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, Ingredient ingredientIn, JuicingRecipe.ItemOutput[] resultsIn, FluidStack fluidOutput, Advancement.Builder advancementBuilderIn, ResourceLocation advancementIdIn) {
            this.id = idIn;
            this.ingredient = ingredientIn;
            this.results = resultsIn;
            this.advancementBuilder = advancementBuilderIn;
            this.advancementId = advancementIdIn;
            this.fluidOutput = fluidOutput;
        }

        public void serializeRecipeData(JsonObject json) {

            json.add("ingredient", this.ingredient.toJson());
            if (results.length > 0){
                JsonArray array = new JsonArray();
                for (JuicingRecipe.ItemOutput itemOutput : results){
                    JsonObject resultObj = new JsonObject();
                    resultObj.addProperty("item", Registry.ITEM.getKey(itemOutput.item.getItem()).toString());
                    if (itemOutput.item.getCount() > 1) {
                        resultObj.addProperty("count", itemOutput.item.getCount());
                    }
                    if (itemOutput.item.hasTag()) {
                        resultObj.addProperty("nbt", itemOutput.item.getTag().toString());
                    }
                    resultObj.addProperty("probability", itemOutput.probability);
                    array.add(resultObj);
                }
                json.add("itemOutputs", array);
                JsonObject resultObj = new JsonObject();
                resultObj.addProperty("fluid", fluidOutput.getFluid().getRegistryName().toString());
                resultObj.addProperty("amount", fluidOutput.getAmount());
                json.add("fluidOutput", resultObj);
            }

        }

        public IRecipeSerializer<?> getType() {
            return RecipeConstants.JUICING_SERIALIZER;
        }

        /**
         * Gets the ID for the recipe.
         */
        public ResourceLocation getId() {
            return this.id;
        }

        /**
         * Gets the JSON for the advancement that unlocks this recipe. Null if there is no advancement.
         */
        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancementBuilder.serializeToJson();
        }

        /**
         * Gets the ID for the advancement associated with this recipe. Should not be null if {@link #getAdvancementJson}
         * is non-null.
         */
        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
