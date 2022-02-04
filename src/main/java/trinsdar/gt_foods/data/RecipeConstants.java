package trinsdar.gt_foods.data;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.recipe.JuicingRecipe;
import trinsdar.gt_foods.recipe.JuicingRecipeSerializer;

@Mod.EventBusSubscriber(modid = GTFoods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeConstants {
    public static final IRecipeType<JuicingRecipe> JUICING_TYPE = register("juicing");

    public static final JuicingRecipeSerializer JUICING_SERIALIZER = new JuicingRecipeSerializer();

    static <T extends IRecipe<?>> IRecipeType<T> register(final String pIdentifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(GTFoods.MODID, pIdentifier), new IRecipeType<T>() {
            public String toString() {
                return pIdentifier;
            }
        });
    }

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<IRecipeSerializer<?>> event){
        event.getRegistry().register(JUICING_SERIALIZER.setRegistryName(new ResourceLocation(GTFoods.MODID, "juicing_serializer")));
    }
}
