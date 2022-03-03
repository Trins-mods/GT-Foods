package trinsdar.gt_foods.data.registration;

import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import net.minecraft.block.Block;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.extensions.IForgeBlock;
import trinsdar.gt_foods.datagen.GTFBlockStateProvider;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;

public interface IModelProvider {

    default void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {
        if (item instanceof IForgeBlock) prov.blockItem(item);
        else if (item instanceof ITextureProvider) prov.tex(item, ((ITextureProvider) item).getTextures());
        else prov.getBuilder(item);
    }

    default void onBlockModelBuild(Block block, GTFBlockStateProvider prov) {
        if (block instanceof ITextureProvider) prov.state(block, ((ITextureProvider) block).getTextures());
    }
}
