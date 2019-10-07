package trinsdar.additional_food.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import trinsdar.additional_food.AdditionalFood;

public class ItemBerry extends BlockNamedItem {
    public ItemBerry(Block blockIn, String name, int hunger, float saturation) {
        super(blockIn, new Item.Properties().group(AdditionalFood.CREATIVE_TAB).food(new Food.Builder().hunger(hunger).saturation(saturation).build()));
        this.setRegistryName(new ResourceLocation(AdditionalFood.MODID, name));
    }
}
