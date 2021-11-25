package trinsdar.gt_foods.loader;

import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.data.RecipeMaps;

public class JuicerLoader {

    public static void init(){
        //RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.COCOA_BEANS, 1)).io(new ItemStack(GTFMaterials.Cocoa))
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Tags.Items.SEEDS, 1)).fo(GTFMaterials.SeedOil.getLiquid(50)).add();
        RecipeMaps.JUICING.RB().ii(RecipeIngredient.of(Items.EGG, 1)).io(new ItemStack(GTFData.EGG_WHITE), new ItemStack(GTFData.EGG_YOLK)).add();
    }
}
