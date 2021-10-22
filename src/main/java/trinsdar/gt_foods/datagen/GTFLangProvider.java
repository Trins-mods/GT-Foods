package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import net.minecraft.data.DataGenerator;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.Data;

import static muramasa.antimatter.util.Utils.lowerUnderscoreToUpperSpaced;

public class GTFLangProvider extends AntimatterLanguageProvider {
    public GTFLangProvider(DataGenerator gen) {
        super(GTFoods.MODID, "GT Foods en_us Localization", "en_us", gen);
    }

    @Override
    protected void processTranslations(String domain, String locale) {
        super.processTranslations(domain, locale);
        Data.getItemIdList().forEach((r, i) -> add(i, lowerUnderscoreToUpperSpaced(r.getPath())));
        Data.getBlockIdList().forEach((r, i) -> add(i, lowerUnderscoreToUpperSpaced(r.getPath())));
    }
}
