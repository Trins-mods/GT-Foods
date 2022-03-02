package trinsdar.gt_foods.datagen;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.loader.CraftingTableLoader;

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
        buildShapelessRecipes((finishedRecipe) -> {
            if (!set.add(finishedRecipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedRecipe.getId());
            } else {
                saveRecipe(pCache, finishedRecipe.serializeRecipe(), path.resolve("data/" + finishedRecipe.getId().getNamespace() + "/recipes/" + finishedRecipe.getId().getPath() + ".json"));
                JsonObject jsonobject = finishedRecipe.serializeAdvancement();
                if (jsonobject != null) {
                    saveAdvancement(pCache, jsonobject, path.resolve("data/" + finishedRecipe.getId().getNamespace() + "/advancements/" + finishedRecipe.getAdvancementId().getPath() + ".json"));
                }

            }
        });
    }
}
