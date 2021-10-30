package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.recipe.loader.IRecipeRegistrate;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.gt_foods.data.Data;
import trinsdar.gt_foods.data.GTData;
import trinsdar.gt_foods.data.GTFConfiguredFeatures;
import trinsdar.gt_foods.data.Guis;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.RecipeMaps;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.datagen.GTFLangProvider;
import trinsdar.gt_foods.loader.SlicerLoader;

@Mod(value = GTFoods.MODID)
public class GTFoods extends AntimatterMod {
    public static final String MODID = "gt_foods";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeTabAdditionalFood CREATIVE_TAB = new CreativeTabAdditionalFood();


    public GTFoods() {
        super();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.addListener(BiomeFeatureInjection::onEvent);
        AntimatterDynamics.addProvider(GTFoods.MODID, g -> new AntimatterBlockStateProvider(GTFoods.MODID, "GT Foods BlockStates", g));
        AntimatterDynamics.addProvider(GTFoods.MODID, GTFItemModelProvider::new);
        AntimatterDynamics.addProvider(GTFoods.MODID, GTFLangProvider::new);
        registerRecipeLoaders();
        new GTFRegistrar();

    }

    private void registerRecipeLoaders() {
        IRecipeRegistrate loader = AntimatterAPI.getRecipeRegistrate(GTFoods.MODID);
        loader.add(SlicerLoader::init);
    }

    @Override
    public String getId() {
        return GTFoods.MODID;
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        if (event == RegistrationEvent.DATA_INIT){
            GTData.init();
            Data.init();
            RecipeMaps.init();
            Machines.init();
            Guis.init();
        }
    }

    @Override
    public int getPriority() {
        return -4000;
    }

    private void setup(final FMLCommonSetupEvent event) {
        GTFConfiguredFeatures.init();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        addBlocksToRenderLayer(RenderType.getCutout(),
                Data.BLUEBERRY_BUSH, Data.BLACKBERRY_BUSH,
                Data.GOOSEBERRY_BUSH, Data.RASPBERRY_BUSH,
                Data.STRAWBERRY_BUSH, Data.CRANBERRY_CROP);
    }

    @OnlyIn(Dist.CLIENT)
    public void addBlocksToRenderLayer(RenderType type, Block... blocks){
        for (Block block : blocks) {
            RenderTypeLookup.setRenderLayer(block, type);
        }
    }
}
