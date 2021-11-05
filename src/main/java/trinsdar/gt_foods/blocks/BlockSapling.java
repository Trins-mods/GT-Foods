package trinsdar.gt_foods.blocks;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.registration.IModelProvider;
import muramasa.antimatter.registration.ITextureProvider;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.StateContainer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import trinsdar.gt_foods.GTFoods;

import java.util.Random;

public class BlockSapling extends SaplingBlock implements IGrowable, IAntimatterObject, IModelProvider, ITextureProvider {
    protected String id;

    public BlockSapling(String id) {
        super(null,/*new RubberTree(),*/ Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
        this.id = id;
        AntimatterAPI.register(BlockSapling.class, this);
        //RubberTree.TREE_FEATURE.init();
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
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId())};
    }

    @Override
    public void onBlockModelBuild(Block block, AntimatterBlockStateProvider prov) {
        prov.state(block, prov.getBuilder(block).parent(prov.existing("minecraft", "block/cross")).texture("cross", getTextures()[0]));
    }

    @Override
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {
        prov.getBuilder(item).parent(prov.getExistingFile(new ResourceLocation("item/generated"))).texture("layer0", getTextures()[0]);
    }

    @Override
    public void placeTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if (world.getBiome(pos).getCategory() != Biome.Category.NETHER && world.getBiome(pos).getCategory() != Biome.Category.THEEND) super.placeTree(world, pos, state, random);
    }
}
