package trinsdar.gt_foods.data.registration;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockCrop;
import trinsdar.gt_foods.blocks.BlockCropBerry;
import trinsdar.gt_foods.items.CustomItemBlock;
import trinsdar.gt_foods.tree.TreeWorldGen;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = GTFoods.MODID)
public class GTFRegistration {
    private static final Map<Class<?>, Map<String, Object>> OBJECTS = new Object2ObjectOpenHashMap<>();

    private static void registerInternal(Class<?> c, String id, Object o) {
        Map<String, Object> map = OBJECTS.computeIfAbsent(c, t -> new Object2ObjectLinkedOpenHashMap<>());
        Object present = map.getOrDefault(id, null);
        if (present != null) {
            throw new IllegalStateException(String.join("", "Class ", c.getName(), "'s object: ", id,
                    " has already been registered by: ", present.toString()));
        } else {
            map.put(id, o);
        }
    }

    public static <T> T register(Class<?> c, String id, Object o) {
        // synchronized (OBJECTS) {
        /*if (!allowRegistration()) {
            throw new IllegalStateException("Registering after Registration event in GT Foods - badbad!");
        }*/
        if (o instanceof IRegistrationObject && !((IRegistrationObject) o).shouldRegister())
            return (T) o;
        Class clazz = c;
        registerInternal(c, id, o);
        if (o instanceof Block && notRegistered(Block.class, id))
            registerInternal(Block.class, id, o);
        else if (o instanceof Item && notRegistered(Item.class, id))
            registerInternal(Item.class, id, o);
        /*else if (o instanceof IRegistryEntryProvider) {
            String changedId = o instanceof Material ? "material_" + id : o instanceof StoneType ? "stone_" + id : id;
            if (notRegistered(IRegistryEntryProvider.class, changedId, domain))
                registerInternal(IRegistryEntryProvider.class, changedId, o);
        }*/
        return (T) o;
        // }
    }

    public static <T> T register(Class<T> c, IRegistrationObject o) {
        return register(c, o.getId(), o);
    }

    private static boolean notRegistered(Class<?> c, String id) {
        return !has(c, id);
    }

    public static <T> boolean has(Class<T> c, String id) {
        Map<String, Object> map = OBJECTS.get(c);
        return map != null && map.get(id) != null;
    }

    public static <T> T get(Class<T> c, String id) {
        Map<String, Object> map = OBJECTS.get(c);
        if (map != null) {
            Object object = map.get(id);
            return ((T) object);
        }
        return null;
    }

    public static <T> List<T> all(Class<T> c) {
        // if (!dataDone) {
        // List<T> list;
        // synchronized (OBJECTS) {
        // list = allInternal(c).collect(Collectors.toList());
        // }
        // return list;
        // }
        return allInternal(c).collect(Collectors.toList());
    }

    public static <T> void all(Class<T> c, Consumer<T> consumer) {
        // if (!dataDone) {
        // synchronized (OBJECTS) {
        // allInternal(c).forEach(consumer);
        // }
        // } else {
        allInternal(c).forEach(consumer);
        // }
    }

    private static <T> Stream<T> allInternal(Class<T> c) {
        Map<String, Object> map = OBJECTS.get(c);
        return map == null ? Stream.empty()
                : map.values().stream().map(c::cast);
    }

    @SubscribeEvent
    public static void onRegisterBlock(final RegistryEvent.Register<Block> e) {
        all(Block.class, b -> {
            if (b instanceof IRegistrationObject && b.getRegistryName() == null)
                b.setRegistryName(((IRegistrationObject) b).getDomain(), ((IRegistrationObject) b).getId());
            if (!(b instanceof BlockCrop) && !(b instanceof BlockCropBerry)) {
                register(Item.class, b.getRegistryName().getPath(), new CustomItemBlock(b));
            }
            e.getRegistry().register(b);
        });
        /*else if (e.getRegistry() == ForgeRegistries.TILE_ENTITIES) {
            AntimatterAPI.all(TileEntityType.class, domain, t -> ((IForgeRegistry) e.getRegistry()).register(t));
        } else if (e.getRegistry() == ForgeRegistries.FLUIDS) {
            AntimatterAPI.all(AntimatterFluid.class, domain, f -> {
                ((IForgeRegistry) e.getRegistry()).registerAll(f.getFluid(), f.getFlowingFluid());
            });
        } else if (e.getRegistry() == ForgeRegistries.CONTAINERS) {
            AntimatterAPI.all(ContainerType.class, domain, h -> ((IForgeRegistry) e.getRegistry()).register(h));
        }*/
    }

    @SubscribeEvent
    public static void onRegisterItem(final RegistryEvent.Register<Item> e){
        all(Item.class, i -> {
            if (i instanceof IRegistrationObject && i.getRegistryName() == null)
                i.setRegistryName(((IRegistrationObject) i).getDomain(), ((IRegistrationObject) i).getId());
            e.getRegistry().register(i);
        });
    }

    @SubscribeEvent
    public static void onRegisterFeature(final RegistryEvent.Register<Feature<?>> e) {

        e.getRegistry().register(TreeWorldGen.TREE_FEATURE);
    }

    @SubscribeEvent
    public static void onRegisterFoliage(final RegistryEvent.Register<FoliagePlacerType<?>> e) {
        e.getRegistry().register(TreeWorldGen.CINNAMON_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.COCONUT_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.HAZEL_FOLIAGE_PLACER);
        e.getRegistry().register(TreeWorldGen.LEMON_FOLIAGE_PLACER);
    }
}
