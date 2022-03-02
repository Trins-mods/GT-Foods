package trinsdar.gt_foods.data.registration;

import net.minecraft.util.ResourceLocation;
import trinsdar.gt_foods.GTFoods;

public interface IRegistrationObject {
    default String getDomain() {
        return GTFoods.MODID;
    }

    String getId();

    default boolean shouldRegister() {
        return true;
    }

    default ResourceLocation getLoc() {
        return new ResourceLocation(getDomain(), getId());
    }
}
