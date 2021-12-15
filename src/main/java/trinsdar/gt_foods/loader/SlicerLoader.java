package trinsdar.gt_foods.loader;

import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.RecipeMaps;

public class SlicerLoader {

    public static void init(){
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.LEMON, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.LEMON_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.TOMATO, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.TOMATO_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.ONION, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.ONION_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.CUCUMBER, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.CUCUMBER_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.PICKLE, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.PICKLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.CARROT, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.CARROT_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.BANANA, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.BANANA_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.APPLE, 1), RecipeIngredient.of(GTFData.HOLLOW_QUARTERS_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.APPLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.PINEAPPLE, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.PINEAPPLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.CHEESE, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.CHEESE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.RAW_HAM, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.RAW_HAM_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.COOKED_HAM, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.COOKED_HAM_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.BUN, 1), RecipeIngredient.of(GTFData.SPLIT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.SLICED_BUN, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.BREAD, 1), RecipeIngredient.of(GTFData.SPLIT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.SLICED_BREAD, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.BAGUETTE, 1), RecipeIngredient.of(GTFData.SPLIT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.SLICED_BAGUETTE, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.POTATO, 1), RecipeIngredient.of(GTFData.GRID_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.RAW_FRIES)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.POTATO, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.RAW_POTATO_CHIPS)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.CHOCOLATE_DOUGH, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.COOKIE_SHAPED_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.SUGARY_RAISIN_DOUGH, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.COOKIE_SHAPED_RAISIN_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(GTFData.SUGARY_CHOCOLATE_RAISIN_DOUGH, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.MELON, 1), RecipeIngredient.of(GTFData.EIGTHS_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(Items.MELON_SLICE, 8), new ItemStack(Items.MELON_SEEDS)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.EGG, 1), RecipeIngredient.of(GTFData.FLAT_SLICER_BLADES, 1).setNoConsume()).io(new ItemStack(GTFData.SLICED_EGG, 4)).add(16, 16);
    }
}
