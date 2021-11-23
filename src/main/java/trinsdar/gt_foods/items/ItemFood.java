package trinsdar.gt_foods.items;

import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.texture.Texture;

import net.minecraft.item.Item.Properties;

public class ItemFood extends ItemBasic<ItemFood> {
    public ItemFood(String domain, String id, Properties properties) {
        super(domain, id, properties);
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/food/" + getId())};
    }
}
