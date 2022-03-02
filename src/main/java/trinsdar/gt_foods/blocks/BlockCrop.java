package trinsdar.gt_foods.blocks;

import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;

import java.util.function.Supplier;

public class BlockCrop extends CropsBlock implements IRegistrationObject, ITextureProvider, IModelProvider {

    final String id;
    final int maxAge;
    final Supplier<Item> seed;

    public BlockCrop(String id, Supplier<Item> seed, int maxAge, Properties builder) {
        super(builder);
        this.id = id + "_crop";
        this.seed = seed;
        this.maxAge = maxAge;
        this.setRegistryName(GTFoods.MODID, id);
        GTFRegistration.register(getClass(), this);
    }

    public BlockCrop(String id, Supplier<Item> seed, int maxAge) {
        this(id, seed, maxAge, Properties.of(Material.PLANT).noCollission().randomTicks().sound(SoundType.CROP));
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
    protected IItemProvider getBaseSeedId() {
        return getItem();
    }

    public Item getItem() {
        return seed.get();
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public Texture[] getTextures() {
        Texture[] textures = new Texture[maxAge + 1];
        for (int i = 0; i < textures.length; i++){
            textures[i] = new Texture(getDomain(), "block/crops/" + getId().replace("_crop", "") + "/" + i);
        }
        return textures;
    }

    @Override
    public void onBlockModelBuild(Block block, AntimatterBlockStateProvider prov) {
        prov.getVariantBuilder(block).forAllStates(s -> {
            int age = s.getValue(AGE);
            return ConfiguredModel.builder().modelFile(prov.models().getBuilder(getId().replace("_crop", "") + "_stage" + age).parent(prov.models().getExistingFile(new ResourceLocation("minecraft:block/crop"))).texture("crop", getTextures()[Math.min(maxAge, age)])).build();
        });
    }

    @Override
    public void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {

    }
}
