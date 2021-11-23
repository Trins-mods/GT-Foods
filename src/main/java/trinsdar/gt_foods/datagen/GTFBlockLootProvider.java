package trinsdar.gt_foods.datagen;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.BlockStateProperties;
import trinsdar.gt_foods.blocks.BlockFloweringLeaves;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.blocks.BlockSapling;
import trinsdar.gt_foods.data.GTFData;

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
        AntimatterAPI.all(BlockLogStrippable.class, providerDomain, this::add);
        AntimatterAPI.all(BlockSapling.class, providerDomain, this::add);
        AntimatterAPI.all(BlockPlanks.class, providerDomain, this::add);
        tables.put(GTFData.CINNAMON_LEAVES, b -> createLeavesDrops(GTFData.CINNAMON_LEAVES, GTFData.CINNAMON_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
        tables.put(GTFData.COCONUT_LEAVES, b -> createLeavesDrops(GTFData.COCONUT_LEAVES, GTFData.COCONUT_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
        tables.put(GTFData.HAZEL_LEAVES, b -> createLeavesDrops(GTFData.HAZEL_LEAVES, GTFData.HAZEL_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(NOT_SILK_TOUCH_OR_SHEARS).when(BlockStateProperty.hasBlockStateProperties(GTFData.HAZEL_LEAVES).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockFloweringLeaves.FLOWERING, 3))).add(applyExplosionCondition(b, ItemLootEntry.lootTableItem(GTFData.HAZELNUT).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))))));
        tables.put(GTFData.LEMON_LEAVES, b -> createLeavesDrops(GTFData.LEMON_LEAVES, GTFData.LEMON_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(NOT_SILK_TOUCH_OR_SHEARS).when(BlockStateProperty.hasBlockStateProperties(GTFData.LEMON_LEAVES).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockFloweringLeaves.FLOWERING, 3))).add(applyExplosionCondition(b, ItemLootEntry.lootTableItem(GTFData.LEMON).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))))));
    }
}
