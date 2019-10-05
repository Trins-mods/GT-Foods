package trinsdar.additional_food;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import trinsdar.additional_food.items.ItemFood;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(AdditionalFood.MODID)
@Mod.EventBusSubscriber(modid = AdditionalFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryItem {
    private static List<Item> toRegister = new ArrayList<>();
    public static final ItemFood burgerBun = registerItem(new ItemFood("burger_bun",1, 1.0F));
    public static final ItemFood burgerBunHalf = registerItem(new ItemFood("burger_bun_half", 1, 1.0F));

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        for (Item item : toRegister){
            event.getRegistry().register(item);
        }
    }

    static <T extends Item> T registerItem(T item) {
        toRegister.add(item);
        return item;
    }
}
