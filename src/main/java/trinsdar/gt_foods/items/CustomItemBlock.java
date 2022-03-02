package trinsdar.gt_foods.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import trinsdar.gt_foods.GTFoods;

import javax.annotation.Nonnull;

public class CustomItemBlock extends BlockItem {
    public CustomItemBlock(Block block) {
        super(block, new Item.Properties().tab(GTFoods.CREATIVE_TAB));
        if (block.getRegistryName() != null) setRegistryName(block.getRegistryName());
    }

    @Nonnull
    @Override
    public ITextComponent getName(@Nonnull ItemStack stack) {
        return new TranslationTextComponent(stack.getDescriptionId());
    }
}
