package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class GTFItemTagProvider extends AntimatterItemTagProvider {
    public GTFItemTagProvider(String providerDomain, String providerName, boolean replace, DataGenerator gen, BlockTagsProvider p, ExistingFileHelperOverride fh) {
        super(providerDomain, providerName, replace, gen, p, fh);
    }
}
