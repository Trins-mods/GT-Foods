package trinsdar.gt_foods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;

public class BlockPlanks extends Block implements IRegistrationObject, ITextureProvider, IModelProvider {
    protected String id;
    public BlockPlanks(String id) {
        super(Properties.copy(Blocks.OAK_PLANKS));
        this.id = id;
        GTFRegistration.register(this.getClass(), this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId())};
    }
}
