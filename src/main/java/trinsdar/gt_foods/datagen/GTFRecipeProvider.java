package trinsdar.gt_foods.datagen;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.recipe.Recipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.loader.CraftingTableLoader;
import trinsdar.gt_foods.loader.JuicerLoader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class GTFRecipeProvider extends AntimatterRecipeProvider {
    public GTFRecipeProvider(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
    }

    @Override
    public void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
       CraftingTableLoader.loadRecipes(consumer, this);
    }

    public void run(DirectoryCache pCache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        buildShapelessRecipes((p_200410_3_) -> {
            if (!set.add(p_200410_3_.getId())) {
                throw new IllegalStateException("Duplicate recipe " + p_200410_3_.getId());
            } else {
                saveRecipe(pCache, p_200410_3_.serializeRecipe(), path.resolve("data/" + p_200410_3_.getId().getNamespace() + "/recipes/" + p_200410_3_.getId().getPath() + ".json"));
                JsonObject jsonobject = p_200410_3_.serializeAdvancement();
                if (jsonobject != null) {
                    saveAdvancement(pCache, jsonobject, path.resolve("data/" + p_200410_3_.getId().getNamespace() + "/advancements/" + p_200410_3_.getAdvancementId().getPath() + ".json"));
                }

            }
        });
    }
}
