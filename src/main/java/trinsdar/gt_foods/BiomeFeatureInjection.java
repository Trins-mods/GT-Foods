package trinsdar.gt_foods;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import trinsdar.gt_foods.data.GTFConfiguredFeatures;

public class BiomeFeatureInjection {
    public static void onEvent(BiomeLoadingEvent event){
        Biome.Category biomeCategory = event.getCategory();

        if (event.getName() == null) return;
        //if (!getValidBiomesStatic().test(biomeCategory)) return;
        RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        float p = 0.15F;
        if (event.getClimate().temperature > 0.8f) {
            p = 0.04F;
            if (event.getClimate().precipitation == Biome.RainType.RAIN)
                p += 0.04F;
        }
        float finalp = p;
        if (BiomeDictionary.hasType(biomeKey, Type.COLD) && (BiomeDictionary.hasType(biomeKey, Type.CONIFEROUS) || BiomeDictionary.hasType(biomeKey, Type.MOUNTAIN) || BiomeDictionary.hasType(biomeKey, Type.FOREST))) {
            if (BiomeDictionary.hasType(biomeKey, Type.SNOWY)){
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.LUSH_BLUEBERRY_BUSHES);
            } else {
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.BLUEBERRY_BUSHES);
            }
        }
        if (!BiomeDictionary.hasType(biomeKey, Type.COLD) && !BiomeDictionary.hasType(biomeKey, Type.SNOWY) && !BiomeDictionary.hasType(biomeKey, Type.HOT) && !BiomeDictionary.hasType(biomeKey, Type.DEAD) && !BiomeDictionary.hasType(biomeKey, Type.SAVANNA) && !BiomeDictionary.hasType(biomeKey, Type.DRY) && !BiomeDictionary.hasType(biomeKey, Type.WET)){
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.BLACKBERRY_BUSH);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.RASPBERRY_BUSH);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.GOOSEBERRY_BUSH);
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> GTFConfiguredFeatures.STRAWBERRY_BUSH);
        }

    }
}
