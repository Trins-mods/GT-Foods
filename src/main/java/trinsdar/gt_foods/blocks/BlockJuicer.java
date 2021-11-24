package trinsdar.gt_foods.blocks;

import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.machine.BlockMachine;
import muramasa.antimatter.machine.MachineState;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.tile.TileEntityMachine;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
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

public class BlockJuicer extends BlockMachine {

    public static final VoxelShape JUICER_SHAPE = VoxelShapes.create(new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.25, 0.875));
    public BlockJuicer(Machine<?> type, Tier tier) {
        super(type, tier, Properties.of(Material.STONE).strength(1.0f, 10.0f).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion().harvestTool(ToolType.PICKAXE));
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
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {
        ItemModelBuilder b = prov.getBuilder(item).parent(prov.existing(GTFoods.MODID, "block/juicer"));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        TileEntityMachine<?> tile = (TileEntityMachine<?>) world.getBlockEntity(pos);
        if (tile != null){
            AntimatterToolType type = Utils.getToolType(player);
            return tile.onInteract(state, world, pos, player, hand, hit, type);
        }
        return ActionResultType.PASS;
        //return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }
}
