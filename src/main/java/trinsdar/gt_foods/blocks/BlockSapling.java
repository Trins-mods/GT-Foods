package trinsdar.gt_foods.blocks;

import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.StateContainer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;
import trinsdar.gt_foods.datagen.GTFBlockStateProvider;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;

import java.util.Random;

public class BlockSapling extends SaplingBlock implements IGrowable, IRegistrationObject, IModelProvider, ITextureProvider {
    protected String id;

    public BlockSapling(String id, Tree tree) {
        super(tree, Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS));
        this.id = id;
        this.setRegistryName(GTFoods.MODID, id);
        GTFRegistration.register(this.getClass(), this);
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
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId())};
    }

    @Override
    public void onBlockModelBuild(Block block, GTFBlockStateProvider prov) {
        prov.state(block, prov.getBuilder(block).parent(prov.existing("minecraft", "block/cross")).texture("cross", getTextures()[0]));
    }

    @Override
    public void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {
        prov.getBuilder(item).parent(prov.getExistingFile(new ResourceLocation("item/generated"))).texture("layer0", getTextures()[0]);
    }

    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if (world.getBiome(pos).getBiomeCategory() != Biome.Category.NETHER && world.getBiome(pos).getBiomeCategory() != Biome.Category.THEEND) super.advanceTree(world, pos, state, random);
    }
}
