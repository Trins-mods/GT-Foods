package trinsdar.gt_foods.blocks;

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
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;
import trinsdar.gt_foods.datagen.GTFBlockStateProvider;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.items.ItemBerry;

public class BlockCropBerry extends SweetBerryBushBlock implements IRegistrationObject, ITextureProvider, IModelProvider {
    final String id, itemID;

    public BlockCropBerry(String id, String itemID) {
        super(Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH));
        this.id = id;
        this.itemID = itemID;
        this.setRegistryName(GTFoods.MODID, id);
        GTFRegistration.register(this.getClass(), this);
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
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(getItem());
    }

    public Item getItem() {
        return GTFRegistration.get(ItemBerry.class, this.itemID);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.random.nextInt(2);
            popResource(worldIn, pos, new ItemStack(getItem(), j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlock(pos, state.setValue(AGE, 1), 2);
            return ActionResultType.sidedSuccess(worldIn.isClientSide);
        } else {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(GTFoods.MODID, "block/crops/" + getId() + "_stage2"), new Texture(GTFoods.MODID, "block/crops/" + getId() + "_stage3")};
    }

    @Override
    public void onBlockModelBuild(Block block, GTFBlockStateProvider prov) {
        prov.getVariantBuilder(block).forAllStates(s -> {
            int age = s.getValue(AGE);
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
    public void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {

    }
}
