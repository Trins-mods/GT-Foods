package trinsdar.additional_food;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class RegistryBlock {
    private static List<Block> toRegister = new ArrayList<>();

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
