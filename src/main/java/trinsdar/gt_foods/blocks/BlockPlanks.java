package trinsdar.gt_foods.blocks;

import muramasa.antimatter.block.BlockBasic;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Blocks;

public class BlockPlanks extends BlockBasic {
    public BlockPlanks(String domain, String id) {
        super(domain, id, Properties.from(Blocks.OAK_PLANKS));
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId())};
    }
}
