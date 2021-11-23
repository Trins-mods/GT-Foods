package trinsdar.gt_foods.blocks;

import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.machine.BlockMachine;
import muramasa.antimatter.machine.MachineState;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.texture.Texture;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import trinsdar.gt_foods.GTFoods;

import static muramasa.antimatter.Data.WRENCH_MATERIAL;

public class BlockJuicer extends BlockMachine {

    public static final VoxelShape JUICER_SHAPE = VoxelShapes.create(new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.25, 0.875));
    public BlockJuicer(Machine<?> type, Tier tier) {
        super(type, tier, Properties.of(Material.STONE).strength(1.0f, 10.0f).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion());
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
}
