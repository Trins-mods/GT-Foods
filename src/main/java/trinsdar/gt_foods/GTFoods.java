package trinsdar.gt_foods;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.gt_foods.blocks.BlockCrop;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.blocks.BlockJuicer;
import trinsdar.gt_foods.blocks.BlockLeaves;
import trinsdar.gt_foods.blocks.BlockSapling;
import trinsdar.gt_foods.data.GTFConfiguredFeatures;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.TileEntityTypes;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.tree.TreeWorldGen;

@Mod(value = GTFoods.MODID)
public class GTFoods {
    public static final String MODID = "gt_foods";
    public static final XSTR RNG = new XSTR();

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeTabAdditionalFood CREATIVE_TAB = new CreativeTabAdditionalFood();


    public GTFoods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.addListener(BiomeFeatureInjection::onEvent);
        GTFData.init();
        TileEntityTypes.init();
        TreeWorldGen.init();
        if (ModList.get().isLoaded("antimatter")){
            new GTFAntimatterAddon();
        }
    }



    private void setup(final FMLCommonSetupEvent event) {
        GTFConfiguredFeatures.init();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        GTFRegistration.all(BlockCrop.class, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        GTFRegistration.all(BlockCropBerry.class, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        GTFRegistration.all(BlockSapling.class, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        GTFRegistration.all(BlockLeaves.class, b -> RenderTypeLookup.setRenderLayer(b, RenderType.cutout()));
        RenderTypeLookup.setRenderLayer(GTFData.JUICER, RenderType.cutout());
    }

    @OnlyIn(Dist.CLIENT)
    public void addBlocksToRenderLayer(RenderType type, Block... blocks){
        for (Block block : blocks) {
            RenderTypeLookup.setRenderLayer(block, type);
        }
    }
}
