package trinsdar.gt_foods.mixin;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BucketItem.class)
public class MixinBucketItem {

    @Redirect(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/Fluid;getBucket()Lnet/minecraft/item/Item;"))
    private Item redirectedFilledBucket(Fluid fluid){
        if (fluid.getRegistryName().getPath().equals("liquid_milk")){
            return Items.MILK_BUCKET;
        }
        return fluid.getBucket();
    }
}
