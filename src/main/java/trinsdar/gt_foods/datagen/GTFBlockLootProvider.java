package trinsdar.gt_foods.datagen;

import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.blocks.BlockCrop;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.blocks.BlockFloweringLeaves;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.blocks.BlockSapling;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.registration.GTFRegistration;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

import static muramasa.antimatter.Ref.GSON;

public class GTFBlockLootProvider extends AntimatterBlockLootProvider {
    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
    private static final ILootCondition.IBuilder NO_SILK_TOUCH = SILK_TOUCH.invert();
    private static final ILootCondition.IBuilder SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS = SHEARS.or(SILK_TOUCH);
    private static final ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS = SILK_TOUCH_OR_SHEARS.invert();
    public GTFBlockLootProvider(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
    }

    @Override
    protected void loot() {
        super.loot();
        lootGT();
    }

    protected void lootGT() {
        GTFRegistration.all(BlockLogStrippable.class, this::add);
        GTFRegistration.all(BlockSapling.class, this::add);
        GTFRegistration.all(BlockPlanks.class, this::add);
        GTFRegistration.all(BlockCropBerry.class, b -> tables.put(b, b2 -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(b).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))).add(ItemLootEntry.lootTableItem(b.getItem())).apply(SetCount.setCount(RandomValueRange.between(2.0F, 3.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(Blocks.SWEET_BERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(ItemLootEntry.lootTableItem(b.getItem())).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))))));

        tables.put(GTFData.CINNAMON_LEAVES, b -> createLeavesDrops(GTFData.CINNAMON_LEAVES, GTFData.CINNAMON_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
        tables.put(GTFData.COCONUT_LEAVES, b -> createLeavesDrops(GTFData.COCONUT_LEAVES, GTFData.COCONUT_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
        tables.put(GTFData.HAZEL_LEAVES, b -> createLeavesDrops(GTFData.HAZEL_LEAVES, GTFData.HAZEL_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(NOT_SILK_TOUCH_OR_SHEARS).when(BlockStateProperty.hasBlockStateProperties(GTFData.HAZEL_LEAVES).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockFloweringLeaves.FLOWERING, 3))).add(applyExplosionCondition(b, ItemLootEntry.lootTableItem(GTFData.HAZELNUT).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))))));
        tables.put(GTFData.LEMON_LEAVES, b -> createLeavesDrops(GTFData.LEMON_LEAVES, GTFData.LEMON_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(NOT_SILK_TOUCH_OR_SHEARS).when(BlockStateProperty.hasBlockStateProperties(GTFData.LEMON_LEAVES).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockFloweringLeaves.FLOWERING, 3))).add(applyExplosionCondition(b, ItemLootEntry.lootTableItem(GTFData.LEMON).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))))));
        tables.put(GTFData.ONION_CROP, b -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().add(ItemLootEntry.lootTableItem(GTFData.ONION))).withPool(LootPool.lootPool().when(withGrowthValue(b, 3)).add(ItemLootEntry.lootTableItem(GTFData.ONION).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
        tables.put(GTFData.CRANBERRY_CROP, b -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().add(ItemLootEntry.lootTableItem(GTFData.CRANBERRY))).withPool(LootPool.lootPool().when(withGrowthValue(b, 3)).add(ItemLootEntry.lootTableItem(GTFData.CRANBERRY).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
        tables.put(GTFData.RICE_CROP, b -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().add(ItemLootEntry.lootTableItem(GTFData.RICE))).withPool(LootPool.lootPool().when(withGrowthValue(b, 7)).add(ItemLootEntry.lootTableItem(GTFData.RICE).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
        tables.put(GTFData.PEANUT_CROP, b -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().add(ItemLootEntry.lootTableItem(GTFData.PEANUT))).withPool(LootPool.lootPool().when(withGrowthValue(b, 3)).add(ItemLootEntry.lootTableItem(GTFData.PEANUT).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
        tables.put(GTFData.PINEAPPLE_CROP, b -> applyExplosionDecay(b, LootTable.lootTable().withPool(LootPool.lootPool().add(ItemLootEntry.lootTableItem(GTFData.PINEAPPLE))).withPool(LootPool.lootPool().when(withGrowthValue(b, 2)).add(ItemLootEntry.lootTableItem(GTFData.PINEAPPLE).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));
        tables.put(GTFData.TOMATO_CROP, b -> createCropDrops(b, GTFData.TOMATO, GTFData.TOMATO_SEEDS, withGrowthValue(b, 3)).withPool(LootPool.lootPool().when(withGrowthValue(b, 3)).add(ItemLootEntry.lootTableItem(GTFData.MAX_TOMATO).when(RandomChance.randomChance(0.02F)))));
        tables.put(GTFData.RYE_CROP, b -> createCropDrops(b, GTFData.RYE, GTFData.RYE_SEEDS, withGrowthValue(b, 7)));
        tables.put(GTFData.BARLEY_CROP, b -> createCropDrops(b, GTFData.BARLEY, GTFData.BARLEY_SEEDS, withGrowthValue(b, 7)));
        tables.put(GTFData.OAT_CROP, b -> createCropDrops(b, GTFData.OATS, GTFData.OAT_SEEDS, withGrowthValue(b, 7)));
        tables.put(GTFData.CHILI_PEPPER_CROP, b -> createCropDrops(b, GTFData.CHILI_PEPPER, GTFData.CHILI_PEPPER_SEEDS, withGrowthValue(b, 3)));
        tables.put(GTFData.CUCUMBER_CROP, b -> createCropDrops(b, GTFData.CUCUMBER, GTFData.CUCUMBER_SEEDS, withGrowthValue(b, 3)));

    }

    @Override
    public void run(DirectoryCache cache) throws IOException {
        lootGT();
        for (Map.Entry<Block, Function<Block, LootTable.Builder>> e : tables.entrySet()) {
            Path path = getPath(generator.getOutputFolder(), e.getKey().getRegistryName());
            IDataProvider.save(GSON, cache, LootTableManager.serialize(e.getValue().apply(e.getKey()).setParamSet(LootParameterSets.BLOCK).build()), path);
        }
    }

    private static Path getPath(Path root, ResourceLocation id) {
        return root.resolve("data/" + id.getNamespace() + "/loot_tables/blocks/" + id.getPath() + ".json");
    }

    private ILootCondition.IBuilder withGrowthValue(Block block, int age){
        return BlockStateProperty.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockCrop.AGE, age));
    }
}
