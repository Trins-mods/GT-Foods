package trinsdar.gt_foods.items;

import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import trinsdar.gt_foods.GTFoods;

public class ItemSeed extends ItemBerry{
    public ItemSeed(String domain, String id, Block block) {
        super(domain, id, block, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/seeds/" + getId())};
    }
}
