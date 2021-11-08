package trinsdar.gt_foods.blocks;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.items.ItemFood;

import java.util.Random;

public class BlockFloweringLeaves extends BlockLeaves{
    public static final IntegerProperty FLOWERING = IntegerProperty.create("flowering", 0, 3);
    String fruitId;
    public BlockFloweringLeaves(String id, String fruitId) {
        super(id);
        this.fruitId = fruitId;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FLOWERING);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return !state.get(PERSISTENT) && (state.get(DISTANCE) == 7 || state.get(FLOWERING) < 3);
    }

    private Item getFruit(){
        return AntimatterAPI.get(ItemFood.class, fruitId, GTFoods.MODID);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        if (state.get(FLOWERING) < 3 && worldIn.rand.nextInt(10) == 0){
            worldIn.setBlockState(pos, state.with(FLOWERING, state.get(FLOWERING) + 1));
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(FLOWERING);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i == 3) {
            int j = 1 + worldIn.rand.nextInt(2);
            ItemStack fruit = new ItemStack(getFruit(), j);
            if (!player.addItemStackToInventory(fruit)) {
                spawnAsEntity(worldIn, pos, fruit);
            }
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            worldIn.setBlockState(pos, state.with(FLOWERING, 0), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState state = super.getStateForPlacement(context);
        return state == null ? null : state.with(FLOWERING, 0);
    }

    @Override
    public void onBlockModelBuild(Block block, AntimatterBlockStateProvider prov) {
        prov.getVariantBuilder(block).forAllStates(s -> {
            int age = s.get(FLOWERING);
            ModelFile model;
            switch (age){
                case 0: {
                    model = prov.getBuilder(block).parent(prov.models().getExistingFile(new ResourceLocation(Ref.ID, "block/preset/simple"))).texture("all", new Texture(getDomain(), getTextures()[0].getPath()));
                    break;
                }
                case 1: {
                    model = prov.models().getBuilder(block.getRegistryName().getPath() + "_flowering").parent(prov.models().getExistingFile(new ResourceLocation(Ref.ID, "block/preset/simple"))).texture("all", new Texture(getDomain(), getTextures()[0].getPath() + "_flowering"));
                    break;
                }
                case 2: {
                    model = prov.models().getBuilder(block.getRegistryName().getPath() + "_pre_fruiting").parent(prov.models().getExistingFile(new ResourceLocation(Ref.ID, "block/preset/simple"))).texture("all", new Texture(getDomain(), getTextures()[0].getPath() + "_pre_fruiting"));
                    break;
                }
                default: {
                    model = prov.models().getBuilder(block.getRegistryName().getPath() + "_fruiting").parent(prov.models().getExistingFile(new ResourceLocation(Ref.ID, "block/preset/simple"))).texture("all", new Texture(getDomain(), getTextures()[0].getPath() + "fruiting"));
                    break;
                }
            }
            return ConfiguredModel.builder().modelFile(model).build();
        });
    }
}
