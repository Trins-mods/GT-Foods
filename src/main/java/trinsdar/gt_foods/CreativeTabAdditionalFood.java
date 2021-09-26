package trinsdar.additional_food;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CreativeTabAdditionalFood  extends ItemGroup {
    public CreativeTabAdditionalFood() {
        super(AdditionalFood.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.WHEAT);
    }
}
