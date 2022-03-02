package trinsdar.gt_foods.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;

public class ItemBerry extends BlockNamedItem implements IRegistrationObject, ITextureProvider, IModelProvider {

    protected String domain, id, tooltip = "";
    protected boolean enabled = true;

    public ItemBerry(String domain, String id, Block block, Properties properties) {
        super(block, properties);
        this.domain = domain;
        this.id = id;
        GTFRegistration.register(getClass(), this);
    }

    public ItemBerry(String domain, String id, Block block) {
        this(domain, id, block, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
    }

    public ItemBerry tip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTooltip() {
        return tooltip;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/food/" + getId())};
    }
}
