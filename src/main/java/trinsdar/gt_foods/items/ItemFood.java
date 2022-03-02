package trinsdar.gt_foods.items;

import net.minecraft.item.Item;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.Texture;

public class ItemFood extends ItemBase {
    public ItemFood(String id, Properties properties) {
        super(id, properties);
    }

    public ItemFood(String id) {
        this(id, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(GTFoods.MODID, "item/food/" + getId())};
    }
}
