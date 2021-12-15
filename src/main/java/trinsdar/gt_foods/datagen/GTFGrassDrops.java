package trinsdar.gt_foods.datagen;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.data.GTFData;

import javax.annotation.Nonnull;
import java.util.List;

@Mod.EventBusSubscriber(modid = GTFoods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GTFGrassDrops {
    @SubscribeEvent
    public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> ev)
    {
        ev.getRegistry().register(
                new GrassDropSerializer().setRegistryName(GTFoods.MODID, "seed_drops")
        );
    }

    public static class GrassDropSerializer extends GlobalLootModifierSerializer<GrassDropModifier>
    {

        @Override
        public GrassDropModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition)
        {
            return new GrassDropModifier(ailootcondition);
        }

        @Override
        public JsonObject write(GrassDropModifier instance)
        {
            return new JsonObject();
        }
    }

    private static class GrassDropModifier extends LootModifier
    {
        protected GrassDropModifier(ILootCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            Item seed = GTFData.BARLEY_SEEDS;
            switch (context.getRandom().nextInt(6)){
                case 1: {
                    seed = GTFData.CHILI_PEPPER_SEEDS;
                    break;
                }
                case 2: {
                    seed = GTFData.CUCUMBER_SEEDS;
                    break;
                }
                case 3: {
                    seed = GTFData.OAT_SEEDS;
                    break;
                }
                case 4: {
                    seed = GTFData.RYE_SEEDS;
                    break;
                }
                case 5: {
                    seed = GTFData.TOMATO_SEEDS;
                    break;
                }
                default: break;
            }
            generatedLoot.add(new ItemStack(seed));
            return generatedLoot;
        }
    }
}
