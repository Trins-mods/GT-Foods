package trinsdar.gt_foods.data.registration;

import muramasa.antimatter.client.ModelUtils;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class Texture extends ResourceLocation {
    public Texture(String domain, String id) {
        super(domain, id);
    }

    public RenderMaterial asMaterial() {
        return ModelUtils.getBlockMaterial(this);
    }

    public TextureAtlasSprite asSprite() {
        return ModelUtils.getSprite(this);
    }
}
