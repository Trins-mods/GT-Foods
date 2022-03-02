package trinsdar.gt_foods.items;

import net.minecraft.item.Item;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;

public class ItemBase extends Item implements IRegistrationObject, ITextureProvider, IModelProvider {
    protected String id, tooltip = "";
    protected boolean enabled = true;

    public ItemBase(String id, Properties pProperties) {
        super(pProperties);
        this.id = id;
        GTFRegistration.register(getClass(), this);
    }

    public ItemBase(String id){
        this(id, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(GTFoods.MODID, "item/basic/" + getId())};
    }
}
