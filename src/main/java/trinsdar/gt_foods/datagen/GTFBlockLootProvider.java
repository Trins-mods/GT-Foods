package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;
import net.minecraft.data.DataGenerator;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.blocks.BlockSapling;
import trinsdar.gt_foods.data.GTFData;

public class GTFBlockLootProvider extends AntimatterBlockLootProvider {
    public GTFBlockLootProvider(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
    }

    @Override
    protected void loot() {
        super.loot();
        AntimatterAPI.all(BlockLogStrippable.class, providerDomain, this::add);
        AntimatterAPI.all(BlockSapling.class, providerDomain, this::add);
        AntimatterAPI.all(BlockPlanks.class, providerDomain, this::add);
        tables.put(GTFData.CINNAMON_LEAVES, b -> droppingWithChancesAndSticks(GTFData.CINNAMON_LEAVES, GTFData.CINNAMON_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
    }
}
