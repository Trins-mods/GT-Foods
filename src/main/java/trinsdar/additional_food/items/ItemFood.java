package trinsdar.additional_food.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import trinsdar.additional_food.AdditionalFood;

public class ItemFood  extends Item {
    public ItemFood(String name, int hunger, float saturation) {
        super(new Properties().group(AdditionalFood.CREATIVE_TAB).food(new Food.Builder().saturation(saturation).hunger(hunger).build()));
        this.setRegistryName(new ResourceLocation(AdditionalFood.MODID, name.toLowerCase()));
    }
}
