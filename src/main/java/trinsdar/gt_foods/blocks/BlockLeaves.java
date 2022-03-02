package trinsdar.gt_foods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;

public class BlockLeaves extends LeavesBlock implements IRegistrationObject, IModelProvider, ITextureProvider {

    protected String id;

    public BlockLeaves(String id) {
        super(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockLeaves::allowsSpawnOnLeaves).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false));
        this.id = id;
        this.setRegistryName(GTFoods.MODID, id);
        GTFRegistration.register(this.getClass(), this);
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED) ? 0 : 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED) ? 0 : 30;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId())};
    }

    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
}
