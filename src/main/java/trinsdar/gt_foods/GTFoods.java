package trinsdar.gt_foods;

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
import trinsdar.gt_foods.data.GTFConfiguredFeatures;

@Mod(value = GTFoods.MODID)
public class GTFoods {
    public static final String MODID = "gt_foods";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeTabAdditionalFood CREATIVE_TAB = new CreativeTabAdditionalFood();


    public GTFoods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        Data.init();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.addListener(BiomeFeatureInjection::onEvent);
        if (ModList.get().isLoaded("antimatter")){
            new GTFRegistrar();
        }

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

    @SubscribeEvent
    public void onRegisterBlock(RegistryEvent.Register<Block> event){
        Data.getBlockIdList().forEach((r, b) -> event.getRegistry().register(b.setRegistryName(r)));
    }

    @SubscribeEvent
    public void onRegisterItem(RegistryEvent.Register<Item> event){
        Data.getItemIdList().forEach((r, i) -> event.getRegistry().register(i.setRegistryName(r)));
    }
}
