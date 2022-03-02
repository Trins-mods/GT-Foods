package trinsdar.gt_foods.integration;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiFluidStackGroup;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fluids.FluidStack;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.recipe.JuicingRecipe;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JuicerCategory implements IRecipeCategory<JuicingRecipe> {
    protected static IGuiHelper guiHelper;
    protected final String title;
    public final static ResourceLocation uid = new ResourceLocation(GTFoods.MODID, "juicing");
    protected IDrawable background, icon;
    protected IDrawableAnimated progressBar;
    public JuicerCategory(){
        this.title = new TranslationTextComponent("jei.category.gt_foods.juicing").getString();
        background = guiHelper.drawableBuilder(new ResourceLocation(GTFoods.MODID, "textures/gui/machine/juicer.png"), 3, 3, 170, 80).addPadding(0, 55, 0, 0).build();
        progressBar = guiHelper.drawableBuilder(new ResourceLocation(GTFoods.MODID, "textures/gui/machine/juicer.png"), 176, 0, 20, 18).buildAnimated(50, IDrawableAnimated.StartDirection.LEFT, false);
        //todo: fix to real juicer
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(GTFData.CLAY_JUICER));
    }
    @Override
    public ResourceLocation getUid() {
        return uid;
    }

    @Override
    public Class<? extends JuicingRecipe> getRecipeClass() {
        return JuicingRecipe.class;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(JuicingRecipe recipe, MatrixStack stack, double mouseX, double mouseY) {
        if (progressBar != null)
            progressBar.draw(stack, 72 + 3, 18 + 3);
    }

    @Override
    public void setIngredients(JuicingRecipe recipe, IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, Arrays.asList(recipe.itemInput.getItems()));
        if (!recipe.fluidOutput.isEmpty()) ingredients.setOutput(VanillaTypes.FLUID, recipe.fluidOutput);
        ingredients.setOutputLists(VanillaTypes.ITEM, Arrays.stream(recipe.getOutputItems(false)).map(Collections::singletonList).collect(Collectors.toList()));
    }

    @Override
    public void setRecipe(IRecipeLayout layout, JuicingRecipe recipe, @Nonnull IIngredients ingredients) {
        IGuiItemStackGroup itemGroup = layout.getItemStacks();
        IGuiFluidStackGroup fluidGroup = layout.getFluidStacks();
        List<ItemStack> input = ingredients.getInputs(VanillaTypes.ITEM).get(0);
        itemGroup.init(0, true, 49, 21);
        itemGroup.set(0, input);
        if (!ingredients.getOutputs(VanillaTypes.FLUID).isEmpty()){
            FluidStack fluidOutput = ingredients.getOutputs(VanillaTypes.FLUID).get(0).get(0);
            fluidGroup.init(0, false, 104, 60, 16, 16, fluidOutput.getAmount(), false, null);
            fluidGroup.set(0, fluidOutput);
        }
        List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);
        for (int i = 0; i < outputs.size() && i < 6; i++){
            int x = 103 + ((i < 3 ? i : i - 3) * 18);
            int y = i < 3 ? 12 : 30;
            List<ItemStack> output = outputs.get(i);
            itemGroup.init(i + 1, false, x, y);
            itemGroup.set(i + 1, output);
        }
        itemGroup.addTooltipCallback((index, isInput, stack, tooltip) -> {
            if (recipe.hasChances() && !isInput) {
                int chanceIndex = index - 1;
                if (recipe.itemsOutput[chanceIndex].probability < 1) {
                    tooltip.add(new StringTextComponent("Chance: " + (recipe.itemsOutput[chanceIndex].probability * 100) + "%").withStyle(TextFormatting.WHITE));
                }
            }
        });
    }

    public static void setGuiHelper(IGuiHelper helper) {
        guiHelper = helper;
    }

}
