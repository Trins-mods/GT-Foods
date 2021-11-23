package trinsdar.gt_foods;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CreativeTabAdditionalFood extends ItemGroup {
    public CreativeTabAdditionalFood() {
        super(GTFoods.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.WHEAT);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
