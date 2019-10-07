package trinsdar.additional_food;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import trinsdar.additional_food.blocks.BlockCropBerry;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(AdditionalFood.MODID)
@Mod.EventBusSubscriber(modid = AdditionalFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryBlock {
    private static List<Block> toRegister = new ArrayList<>();
    public static final BlockCropBerry blueberryBush = registerBlock(new BlockCropBerry("blueberry_bush", RegistryItem.blueberry));
    public static final BlockCropBerry gooseberryBush = registerBlock(new BlockCropBerry("gooseberry_bush", RegistryItem.gooseberry));
    public static final BlockCropBerry blackberryBush = registerBlock(new BlockCropBerry("blackberry_bush", RegistryItem.blackberry));
    public static final BlockCropBerry raspberryBush = registerBlock(new BlockCropBerry("raspberry_bush", RegistryItem.raspberry));
    public static final BlockCropBerry strawberryBush = registerBlock(new BlockCropBerry("strawberry_bush", RegistryItem.strawberry));

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        for (Block block : toRegister){
            event.getRegistry().register(block);
        }
    }

    static <T extends Block> T registerBlock(T block) {
        toRegister.add(block);
        return block;
    }
}
