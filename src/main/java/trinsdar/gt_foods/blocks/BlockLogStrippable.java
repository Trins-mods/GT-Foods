package trinsdar.gt_foods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;
import trinsdar.gt_foods.data.registration.GTFRegistration;
import trinsdar.gt_foods.data.registration.IModelProvider;
import trinsdar.gt_foods.data.registration.IRegistrationObject;
import trinsdar.gt_foods.data.registration.ITextureProvider;
import trinsdar.gt_foods.data.registration.Texture;
import trinsdar.gt_foods.datagen.GTFBlockStateProvider;

import java.util.function.Supplier;

public class BlockLogStrippable extends RotatedPillarBlock implements IRegistrationObject, ITextureProvider, IModelProvider {
    private Supplier<Block> stripped;
    private String id;
    private boolean strip, wood;
    public BlockLogStrippable(String woodType, Supplier<Block> stripped, boolean strip, boolean wood) {
        super(Properties.copy(Blocks.OAK_LOG));
        String prefix = strip ? "stripped_" : "";
        String suffix = wood ? "_wood" : "_log";
        this.id = prefix + woodType + suffix;
        this.strip = strip;
        this.stripped = stripped;
        this.wood = wood;
        this.setRegistryName(GTFoods.MODID, id);
        GTFRegistration.register(this.getClass(), this);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (strip){
            return ActionResultType.PASS;
        }
        ItemStack heldStack = player.getItemBySlot(hand == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND);

        if(heldStack.isEmpty()) {
            return ActionResultType.FAIL;
        }

        Item held = heldStack.getItem();
        if(!(held instanceof ToolItem)) {
            return ActionResultType.FAIL;
        }

        ToolItem tool = (ToolItem) held;

        if(stripped != null && tool.getToolTypes(heldStack).contains(ToolType.AXE)) {
            world.playSound(player, pos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if(!world.isClientSide) {
                BlockState target = stripped.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));

                world.setBlockAndUpdate(pos, target);

                heldStack.hurtAndBreak(1, player, consumedPlayer -> consumedPlayer.broadcastBreakEvent(hand));
                if (this.id.contains("cinnamon")){
                    ItemStack cinnamon = new ItemStack(GTFData.CINNAMON_BARK);
                    if (!player.addItem(cinnamon)){
                        player.drop(cinnamon, true);
                    }
                }
            }

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.FAIL;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDomain() {
        return GTFoods.MODID;
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(getDomain(), "block/tree/" + getId() +"_top"), new Texture(getDomain(), "block/tree/" + getId() +"_side")};
    }

    @Override
    public void onBlockModelBuild(Block block, GTFBlockStateProvider prov) {
        if (wood){
            prov.axisBlock((RotatedPillarBlock) block, new Texture(getDomain(), "block/tree/" + getId().replace("wood", "log") + "_side"), new Texture(getDomain(), "block/tree/" + getId().replace("wood", "log") + "_side"));
            return;
        }
        prov.axisBlock((RotatedPillarBlock) block, getTextures()[1], getTextures()[0]);
    }
}
