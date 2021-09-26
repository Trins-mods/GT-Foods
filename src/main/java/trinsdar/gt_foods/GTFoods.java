package trinsdar.gt_foods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = GTFoods.MODID)
public class GTFoods {
    public static final String MODID = "gt_foods";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeTabAdditionalFood CREATIVE_TAB = new CreativeTabAdditionalFood();


    public GTFoods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        Registry.init();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        //JsonMaker.initModels();
    }

    @SubscribeEvent
    public void onRegisterBlock(RegistryEvent.Register<Block> event){
        Registry.getBlockIdList().forEach((r, b) -> event.getRegistry().register(b.setRegistryName(r)));
    }

    @SubscribeEvent
    public void onRegisterItem(RegistryEvent.Register<Item> event){
        Registry.getItemIdList().forEach((r, i) -> event.getRegistry().register(i.setRegistryName(r)));
    }
}
