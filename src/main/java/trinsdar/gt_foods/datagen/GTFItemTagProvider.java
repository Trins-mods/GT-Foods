package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.tool.IAntimatterTool;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.GTFoods;

public class GTFItemTagProvider extends ItemTagsProvider /*AntimatterItemTagProvider*/ {
    public GTFItemTagProvider(String providerDomain, DataGenerator gen, BlockTagsProvider p, ExistingFileHelperOverride fh) {
        super(gen, p, providerDomain, fh);
    }

    @Override
    protected void addTags() {
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.LOGS, ItemTags.LOGS);
        this.copy(TagUtils.getBlockTag(new ResourceLocation(GTFoods.MODID, "cinnamon_logs")), TagUtils.getItemTag(new ResourceLocation(GTFoods.MODID, "cinnamon_logs")));
        processTags(modId);
    }

    protected void processTags(String domain) {
        AntimatterAPI.all(IAntimatterTool.class, domain, tool -> {
            this.tag(tool.getAntimatterToolType().getTag()).add(tool.getItem());
            this.tag(tool.getAntimatterToolType().getForgeTag()).add(tool.getItem());
        });
    }
}
