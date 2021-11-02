package trinsdar.gt_foods.blocks;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.registration.IItemBlockProvider;
import muramasa.antimatter.registration.IModelProvider;
import muramasa.antimatter.registration.ITextureProvider;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.items.ItemBerry;

public class BlockCrop extends CropsBlock implements IAntimatterObject, ITextureProvider, IModelProvider, IItemBlockProvider {

    final String id, itemID;
    final int maxAge;

    public BlockCrop(String id, String itemID, int maxAge, Properties builder) {
        super(builder);
        this.id = id;
        this.itemID = itemID;
        this.maxAge = maxAge;
        AntimatterAPI.register(BlockCrop.class, this);
    }

    public BlockCrop(String id, String itemID, int maxAge) {
        this(id, itemID, maxAge, Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP));
    }

    @Override
    public String getDomain() {
        return GTFoods.MODID;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return getItem();
    }

    public Item getItem() {
        return AntimatterAPI.get(Item.class, this.itemID, getDomain());
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[0];
    }

    @Override
    public void onBlockModelBuild(Block block, AntimatterBlockStateProvider prov) {
        prov.getVariantBuilder(block).forAllStates(s -> {
            int age = s.get(AGE);
            return ConfiguredModel.builder().modelFile(prov.models().getBuilder(block.getRegistryName().getPath() + "_stage" + age).parent(prov.models().getExistingFile(new ResourceLocation("minecraft:block/crop"))).texture("crop", new Texture(getDomain(), "block/" + getId() + "/" + Math.min(age, maxAge)))).build();
        });
    }

    @Override
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {

    }

    @Override
    public boolean generateItemBlock() {
        return false;
    }
}
