package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockLeaves;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.data.GTFData;

public class GTFBlockTagProvider extends AntimatterBlockTagProvider {
    public GTFBlockTagProvider(String providerDomain, String providerName, boolean replace, DataGenerator gen, ExistingFileHelper helper) {
        super(providerDomain, providerName, replace, gen, helper);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        AntimatterAPI.all(BlockLogStrippable.class, domain, b -> this.tag(BlockTags.LOGS).add(b));
        AntimatterAPI.all(BlockLeaves.class, domain, b -> this.tag(BlockTags.LEAVES).add(b));
        AntimatterAPI.all(BlockPlanks.class, domain, b -> this.tag(BlockTags.PLANKS).add(b));
        this.tag(TagUtils.getBlockTag(new ResourceLocation(GTFoods.MODID, "cinnamon_logs"))).add(GTFData.CINNAMON_LOG, GTFData.STRIPPED_CINNAMON_LOG, GTFData.CINNAMON_WOOD, GTFData.STRIPPED_CINNAMON_WOOD);
    }
}
