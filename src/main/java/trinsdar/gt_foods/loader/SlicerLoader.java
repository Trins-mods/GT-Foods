package trinsdar.gt_foods.loader;

import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import trinsdar.gt_foods.data.Data;
import trinsdar.gt_foods.data.GTData;
import trinsdar.gt_foods.data.RecipeMaps;

public class SlicerLoader {

    public static void init(){
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.LEMON, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.LEMON_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.TOMATO, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.TOMATO_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.ONION, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.ONION_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.CUCUMBER, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.CUCUMBER_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.PICKLE, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.PICKLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.CARROT, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.CARROT_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.BANANA, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.BANANA_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.APPLE, 1), RecipeIngredient.of(GTData.HollowQuartersSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.APPLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.PINEAPPLE, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.PINEAPPLE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.CHEESE, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.CHEESE_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.RAW_HAM, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.RAW_HAM_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.COOKED_HAM, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.COOKED_HAM_SLICE, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.BUN, 1), RecipeIngredient.of(GTData.SplitSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.SLICED_BUN, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.BREAD, 1), RecipeIngredient.of(GTData.SplitSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.SLICED_BREAD, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.BAGUETTE, 1), RecipeIngredient.of(GTData.SplitSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.SLICED_BAGUETTE, 2)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.POTATO, 1), RecipeIngredient.of(GTData.GridSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.RAW_FRIES)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.POTATO, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.RAW_POTATO_CHIPS)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.CHOCOLATE_DOUGH, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.COOKIE_SHAPED_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.SUGARY_RAISIN_DOUGH, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.COOKIE_SHAPED_RAISIN_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Data.SUGARY_CHOCOLATE_RAISIN_DOUGH, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.COOKIE_SHAPED_CHOCOLATE_RAISIN_DOUGH, 4)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.MELON, 1), RecipeIngredient.of(GTData.EigthsSlicerBlades, 1).setNoConsume()).io(new ItemStack(Items.MELON_SLICE, 8), new ItemStack(Items.MELON_SEEDS)).add(16, 16);
        RecipeMaps.SLICING.RB().ii(RecipeIngredient.of(Items.EGG, 1), RecipeIngredient.of(GTData.FlatSlicerBlades, 1).setNoConsume()).io(new ItemStack(Data.SLICED_EGG, 4)).add(16, 16);
    }
}
