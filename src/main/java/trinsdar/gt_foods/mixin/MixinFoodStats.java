package trinsdar.gt_foods.mixin;

import net.minecraft.util.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodStats.class)
public class MixinFoodStats {

    @Shadow
    private int foodLevel;
    @Shadow
    private float saturationLevel;

    @Inject(method = "Lnet/minecraft/util/FoodStats;eat(IF)V", at = @At("HEAD"), cancellable = true)
    public void gtf_injectAddStats(int foodLevelIn, float foodSaturationModifier, CallbackInfo info){
        if (foodLevelIn == 0){
            this.saturationLevel = Math.min(this.saturationLevel + (float)1 * foodSaturationModifier * 2.0F, (float)this.foodLevel);
            info.cancel();
        }
    }
}
