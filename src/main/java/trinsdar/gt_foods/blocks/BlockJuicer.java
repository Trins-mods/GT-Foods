package trinsdar.gt_foods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.ToolType;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.TileEntityTypes;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.tile.TileEntityJuicer;

import javax.annotation.Nullable;

public class BlockJuicer extends Block implements IRegistrationObject, IModelProvider {

    public final VoxelShape JUICER_SHAPE;
    public BlockJuicer() {
        super(Properties.of(Material.STONE).strength(1.0f, 10.0f).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion().harvestTool(ToolType.PICKAXE));
        VoxelShape bottom = VoxelShapes.create(new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.25, 0.875));
        VoxelShape top = VoxelShapes.create(new AxisAlignedBB(0.375, 0.25, 0.375, 0.625, 0.375, 0.625));
        JUICER_SHAPE = VoxelShapes.or(bottom, top);
        GTFRegistration.register(this.getClass(), this);
    }

    @Override
    public String getId() {
        return "juicer";
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return JUICER_SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return JUICER_SHAPE;
    }

    @Override
    public void onItemModelBuild(IItemProvider item, GTFItemModelProvider prov) {
        ItemModelBuilder b = prov.getBuilder(item).parent(prov.existing(GTFoods.MODID, "block/juicer"));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        TileEntity tile = world.getBlockEntity(pos);
        if (tile instanceof TileEntityJuicer){
            return ((TileEntityJuicer)tile).onInteract(state, world, pos, player, hand, hit);
        }
        return ActionResultType.PASS;
        //return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypes.JUICER_TYPE.create();
    }
}
