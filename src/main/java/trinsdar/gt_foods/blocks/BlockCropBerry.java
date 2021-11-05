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
import net.minecraft.block.SoundType;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.items.ItemBerry;

public class BlockCropBerry extends SweetBerryBushBlock implements IAntimatterObject, ITextureProvider, IModelProvider, IItemBlockProvider {
    final String id, itemID;

    public BlockCropBerry(String id, String itemID) {
        super(Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH));
        this.id = id;
        this.itemID = itemID;
        AntimatterAPI.register(BlockCropBerry.class, this);
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
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(getItem());
    }

    public Item getItem() {
        return AntimatterAPI.get(ItemBerry.class, this.itemID, getDomain());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.rand.nextInt(2);
            spawnAsEntity(worldIn, pos, new ItemStack(getItem(), j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(GTFoods.MODID, "block/crops/" + getId() + "_stage2"), new Texture(GTFoods.MODID, "block/crops/" + getId() + "_stage3")};
    }

    @Override
    public void onBlockModelBuild(Block block, AntimatterBlockStateProvider prov) {
        prov.getVariantBuilder(block).forAllStates(s -> {
            int age = s.get(AGE);
            ModelFile model;
            switch (age){
                case 0: {
                    model = prov.existing("minecraft", "block/sweet_berry_bush_stage0");
                    break;
                }
                case 1: {
                    model = prov.existing("minecraft", "block/sweet_berry_bush_stage1");
                    break;
                }
                case 2: {
                    model = prov.models().getBuilder(block.getRegistryName().getPath() + "_stage2").parent(prov.models().getExistingFile(new ResourceLocation("minecraft:block/cross"))).texture("cross", getTextures()[0]);
                    break;
                }
                default: {
                    model = prov.models().getBuilder(block.getRegistryName().getPath() + "_stage3").parent(prov.models().getExistingFile(new ResourceLocation("minecraft:block/cross"))).texture("cross", getTextures()[1]);
                    break;
                }
            }
            return ConfiguredModel.builder().modelFile(model).build();
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
