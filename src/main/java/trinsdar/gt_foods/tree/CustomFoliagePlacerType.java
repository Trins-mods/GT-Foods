package trinsdar.gt_foods.tree;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import trinsdar.gt_foods.GTFoods;

public class CustomFoliagePlacerType<T extends FoliagePlacer> extends FoliagePlacerType<T> {
    public CustomFoliagePlacerType(String id, Codec<T> tCodec) {
        super(tCodec);
        this.setRegistryName(GTFoods.MODID, id +"_foliage_placer");
    }
}
