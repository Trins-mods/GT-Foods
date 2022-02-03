package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.event.AntimatterCraftingEvent;
import muramasa.antimatter.event.AntimatterLoaderEvent;
import muramasa.antimatter.event.AntimatterProvidersEvent;
import muramasa.antimatter.recipe.loader.IRecipeRegistrate;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.gt_foods.blocks.BlockCrop;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.blocks.BlockJuicer;
import trinsdar.gt_foods.blocks.BlockLeaves;
import trinsdar.gt_foods.blocks.BlockSapling;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.GTFConfiguredFeatures;
import trinsdar.gt_foods.data.GTFMaterialTypes;
import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.data.Guis;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.RecipeMaps;
import trinsdar.gt_foods.datagen.GTFBlockLootProvider;
import trinsdar.gt_foods.datagen.GTFBlockTagProvider;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.datagen.GTFItemTagProvider;
import trinsdar.gt_foods.datagen.GTFLangProvider;
import trinsdar.gt_foods.loader.BathingLoader;
import trinsdar.gt_foods.loader.CraftingTableLoader;
import trinsdar.gt_foods.loader.FermenterLoader;
import trinsdar.gt_foods.loader.FurnaceLoader;
import trinsdar.gt_foods.loader.JuicerLoader;
import trinsdar.gt_foods.loader.MixingLoader;
import trinsdar.gt_foods.loader.SlicerLoader;
import trinsdar.gt_foods.tree.TreeWorldGen;

import java.util.function.BiConsumer;

@Mod(value = GTFoods.MODID)
public class GTFoods {
    public static final String MODID = "gt_foods";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeTabAdditionalFood CREATIVE_TAB = new CreativeTabAdditionalFood();


    public GTFoods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.addListener(BiomeFeatureInjection::onEvent);
        if (ModList.get().isLoaded("antimatter")){
            new GTFAntimatterAddon();
        }
    }

    @SubscribeEvent
    public static void onRegisterFeature(final RegistryEvent.Register<Feature<?>> e) {

        e.getRegistry().register(TreeWorldGen.TREE_FEATURE);
    }

    @SubscribeEvent
    public static void onRegisterFoliage(final RegistryEvent.Register<FoliagePlacerType<?>> e) {
        e.getRegistry().register(TreeWorldGen.CINNAMON_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.COCONUT_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.HAZEL_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.LEMON_FOLIAGE_PLACER);
    }

    private void setup(final FMLCommonSetupEvent event) {
        GTFConfiguredFeatures.init();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        AntimatterAPI.all(BlockCrop.class, MODID, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        AntimatterAPI.all(BlockCropBerry.class, MODID, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        AntimatterAPI.all(BlockSapling.class, MODID, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        AntimatterAPI.all(BlockLeaves.class, MODID, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        AntimatterAPI.all(BlockJuicer.class, MODID, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
    }

    @OnlyIn(Dist.CLIENT)
    public void addBlocksToRenderLayer(RenderType type, Block... blocks){
        for (Block block : blocks) {
            RenderTypeLookup.setRenderLayer(block, type);
        }
    }
}
