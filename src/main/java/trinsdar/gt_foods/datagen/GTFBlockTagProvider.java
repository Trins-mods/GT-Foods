package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockLeaves;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.registration.GTFRegistration;

public class GTFBlockTagProvider extends BlockTagsProvider /*AntimatterBlockTagProvider*/ {
    public GTFBlockTagProvider(String providerDomain, DataGenerator gen, ExistingFileHelper helper) {
        super(gen, providerDomain, helper);
    }

    @Override
    protected void addTags() {
        processTags(modId);
    }

    //@Override
    protected void processTags(String domain) {
        //super.processTags(domain);
        GTFRegistration.all(BlockLogStrippable.class, b -> this.tag(BlockTags.LOGS).add(b));
        GTFRegistration.all(BlockLeaves.class, b -> this.tag(BlockTags.LEAVES).add(b));
        GTFRegistration.all(BlockPlanks.class, b -> this.tag(BlockTags.PLANKS).add(b));
        this.tag(TagUtils.getBlockTag(new ResourceLocation(GTFoods.MODID, "cinnamon_logs"))).add(GTFData.CINNAMON_LOG, GTFData.STRIPPED_CINNAMON_LOG, GTFData.CINNAMON_WOOD, GTFData.STRIPPED_CINNAMON_WOOD);
    }
}
