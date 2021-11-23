package trinsdar.gt_foods.items;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterConfig;
import muramasa.antimatter.Ref;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemTag;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.registration.IModelProvider;
import muramasa.antimatter.registration.ISharedAntimatterObject;
import muramasa.antimatter.registration.ITextureProvider;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.Set;

import net.minecraft.item.Item.Properties;

public class ItemBerry extends BlockNamedItem implements IAntimatterObject, ITextureProvider, IModelProvider {

    protected String domain, id, tooltip = "";
    protected boolean enabled = true;
    protected Set<ItemTag> tags = new ObjectOpenHashSet<>();

    public ItemBerry(String domain, String id, Block block, Properties properties) {
        super(block, properties);
        this.domain = domain;
        this.id = id;
        AntimatterAPI.register(getClass(), this);
    }

    public ItemBerry tip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public ItemBerry tags(ItemTag... tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }

    @Override
    public String getDomain() {
        return this instanceof ISharedAntimatterObject ? Ref.SHARED_ID : domain;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTooltip() {
        return tooltip;
    }

    public boolean isEnabled() {
        return enabled || AntimatterConfig.DATA.ALL_MATERIAL_ITEMS;
    }

    /*
    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new TranslationTextComponent("item." + getId());
    }
     */

    public boolean isEqual(ItemStack stack) {
        return stack.getItem() == this;
    }

//    public static boolean doesShowExtendedHighlight(ItemStack stack) {
//        return AntimatterAPI.getCoverFromCatalyst(stack) != null; //TODO: reimplement?
//    }

    public ItemStack get(int count) {
        //TODO replace consumeTag with flag system
        if (count == 0) return Utils.addNoConsumeTag(new ItemStack(this, 1));
        return new ItemStack(this, count);
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(domain, "item/food/" + getId())};
    }
}
