package trinsdar.gt_foods.data;

import net.minecraft.tileentity.TileEntityType;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.tile.TileEntityJuicer;

import java.util.Collections;

public class TileEntityTypes {
    public static final TileEntityType<?> JUICER_TYPE = new TileEntityType<>(TileEntityJuicer::new, Collections.singleton(GTFData.JUICER), null).setRegistryName(GTFoods.MODID, "juicer");

    public static void init(){
        GTFRegistration.register(TileEntityType.class, "juicer", JUICER_TYPE);
    }
}
