package trinsdar.gt_foods.items;

import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.texture.Texture;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import trinsdar.gt_foods.GTFoods;

public class ItemFood extends ItemBasic<ItemFood> {
    public ItemFood(String domain, String id, Properties properties) {
        super(domain, id, properties);
    }

    public ItemFood(String modid, String id) {
        this(modid, id, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/food/" + getId())};
    }
}
