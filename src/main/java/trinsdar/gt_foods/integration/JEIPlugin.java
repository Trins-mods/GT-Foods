package trinsdar.gt_foods.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.RecipeConstants;

import javax.annotation.Nonnull;
import java.util.Optional;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(GTFoods.MODID, "jei");
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        JuicerCategory.setGuiHelper(registration.getJeiHelpers().getGuiHelper());
        registration.addRecipeCategories(new JuicerCategory());
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Optional.ofNullable(Minecraft.getInstance().level).ifPresent(w -> {
            registration.addRecipes(RecipeConstants.JUICING_SERIALIZER.getRecipes(w), JuicerCategory.uid);
        });
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(GTFData.JUICER), JuicerCategory.uid);
    }
}
