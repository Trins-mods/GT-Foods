package trinsdar.gt_foods.items;

import net.minecraft.block.Block;
import trinsdar.gt_foods.data.registration.Texture;

public class ItemSeed extends ItemBerry{
    public ItemSeed(String domain, String id, Block block) {
        super(domain, id, block);
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/seeds/" + getId())};
    }
}
