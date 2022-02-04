package trinsdar.gt_foods.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import trinsdar.gt_foods.data.RecipeConstants;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JuicingRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<JuicingRecipe> {

    protected Collection<JuicingRecipe> getManagerRecipes(World world) {
        return world.getRecipeManager().getAllRecipesFor(RecipeConstants.JUICING_TYPE);
    }

    public Collection<JuicingRecipe> getRecipes(World world) {
        return getManagerRecipes(world);
    }

    @Override
    public JuicingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
        JsonElement jsonelement = JSONUtils.isArrayNode(pJson, "ingredient") ? JSONUtils.getAsJsonArray(pJson, "ingredient") : JSONUtils.getAsJsonObject(pJson, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonelement);
        if (!pJson.has("fluidOutput")) throw new com.google.gson.JsonSyntaxException("Missing fluidOutput, expected to find a string or object");
        JsonObject fluidOutput = JSONUtils.getAsJsonObject(pJson, "fluidOutput");
        if (!fluidOutput.has("fluid")) throw new com.google.gson.JsonSyntaxException("Missing fluid in fluidOutput, expected to find a string or object");
        FluidStack fluid = readFluidOutput(fluidOutput);
        JuicingRecipe.ItemOutput[] itemOutputs = readArray(pJson, "itemOutputs", j -> new JuicingRecipe.ItemOutput(ShapedRecipe.itemFromJson(j), readProbability(j, "probability"))).toArray(new JuicingRecipe.ItemOutput[0]);
        return new JuicingRecipe(ingredient, itemOutputs, fluid, pRecipeId);
    }

    private static FluidStack readFluidOutput(JsonObject json) {
        ResourceLocation id = readIdentifier(json, "fluid");
        Fluid fluid = ForgeRegistries.FLUIDS.getValue(id);
        if (fluid == null){
            throw new IllegalArgumentException("Fluid " + id + " does not exist.");
        }
        int amount = readAmount(json, "amount");
        return new FluidStack(fluid, amount);
    }

    private static float readProbability(JsonObject json, String element) {
        if (JSONUtils.isValidPrimitive(json, element)) {
            float x = JSONUtils.getAsFloat(json, element);
            if (x < 0 || x > 1)
                throw new IllegalArgumentException(element + " should be a float between 0 and 1.");
            return x;
        } else {
            return 1;
        }
    }

    private static <T> List<T> readArray(JsonObject json, String element, Function<JsonObject, T> reader) {
        if (!JSONUtils.isArrayNode(json, element)) {
            // If there is no array, try to parse a single element object instead.
            JsonElement backupObject = json.get(element);
            if (backupObject != null && backupObject.isJsonObject()) {
                return Arrays.asList(reader.apply(backupObject.getAsJsonObject()));
            } else {
                return Collections.emptyList();
            }
        } else {
            JsonArray array = JSONUtils.getAsJsonArray(json, element);
            JsonObject[] objects = new JsonObject[array.size()];
            for (int i = 0; i < objects.length; i++) {
                objects[i] = array.get(i).getAsJsonObject();
            }
            return Arrays.stream(objects).map(reader).collect(Collectors.toList());
        }
    }

    private static int readAmount(JsonObject json, String element) {
        int amount = JSONUtils.getAsInt(json, element);
        if (amount <= 0) {
            throw new IllegalArgumentException(element + " should be a positive amount.");
        }
        return amount;
    }

    private static ResourceLocation readIdentifier(JsonObject json, String element) {
        return new ResourceLocation(JSONUtils.getAsString(json, element));
    }

    @Nullable
    @Override
    public JuicingRecipe fromNetwork(ResourceLocation pRecipeId, PacketBuffer pBuffer) {
        Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
        FluidStack fluidOutput = pBuffer.readFluidStack();
        JuicingRecipe.ItemOutput[] itemOutputs = readList(pBuffer, p -> new JuicingRecipe.ItemOutput(p.readItem(), p.readFloat())).toArray(new JuicingRecipe.ItemOutput[0]);
        return new JuicingRecipe(ingredient, itemOutputs, fluidOutput, pRecipeId);
    }

    private static <T> List<T> readList(PacketBuffer buf, Function<PacketBuffer, T> reader) {
        List<T> l = new ArrayList<>();
        int size = buf.readVarInt();
        for (int i = 0; i < size; ++i) {
            l.add(reader.apply(buf));
        }
        return l;
    }

    private static <T> void writeList(PacketBuffer buf, T[] array, BiConsumer<PacketBuffer, T> writer) {
        buf.writeVarInt(array.length);
        for (T t : array) {
            writer.accept(buf, t);
        }
    }

    @Override
    public void toNetwork(PacketBuffer pBuffer, JuicingRecipe pRecipe) {
        pRecipe.itemInput.toNetwork(pBuffer);
        pRecipe.fluidOutput.writeToPacket(pBuffer);
        writeList(pBuffer, pRecipe.itemsOutput, (p, i) -> {
            p.writeItem(i.item);
            p.writeFloat(i.probability);
        });
    }
}
