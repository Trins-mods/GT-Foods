package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import muramasa.antimatter.item.ItemBasic;
import net.minecraft.data.DataGenerator;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.Data;
import trinsdar.gt_foods.items.ItemBerry;
import trinsdar.gt_foods.items.ItemFood;

import static muramasa.antimatter.util.Utils.lowerUnderscoreToUpperSpaced;

public class GTFLangProvider extends AntimatterLanguageProvider {
    public GTFLangProvider(DataGenerator gen) {
        super(GTFoods.MODID, "GT Foods en_us Localization", "en_us", gen);
    }

    @Override
    protected void processTranslations(String domain, String locale) {
        super.processTranslations(domain, locale);
        AntimatterAPI.all(ItemBerry.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
        AntimatterAPI.all(ItemFood.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
    }
}
