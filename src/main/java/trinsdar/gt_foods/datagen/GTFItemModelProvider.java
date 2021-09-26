package trinsdar.gt_foods.datagen;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.Data;

public class GTFItemModelProvider extends ItemModelProvider {
    public GTFItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GTFoods.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Data.getItemIdList().forEach((r, i) -> {
            tex(i, new ResourceLocation(r.getNamespace(), "item/" + r.getPath()));
        });
    }

    public ItemModelBuilder getBuilder(IItemProvider item) {
        return getBuilder(item.asItem().getRegistryName().getPath());
    }

    public ItemModelBuilder tex(IItemProvider item, ResourceLocation... textures) {
        return tex(item, "minecraft:item/generated", textures);
    }

    public ItemModelBuilder tex(IItemProvider item, String parent, ResourceLocation... textures) {
        ItemModelBuilder builder = getBuilder(item);
        builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(parent)));
        for (int i = 0; i < textures.length; i++) {
            builder.texture("layer" + i, textures[i]);
        }
        return builder;
    }

    public ItemModelBuilder blockItem(Block block) {
        return blockItem(block.asItem());
    }

    public ItemModelBuilder blockItem(IItemProvider item) {
        return withExistingParent(item.asItem().getRegistryName().getPath(), modLoc("block/" + item.asItem().getRegistryName().getPath()));
    }
}
