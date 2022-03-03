package trinsdar.gt_foods;

import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.event.AntimatterCraftingEvent;
import muramasa.antimatter.event.AntimatterLoaderEvent;
import muramasa.antimatter.event.AntimatterProvidersEvent;
import muramasa.antimatter.recipe.loader.IRecipeRegistrate;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import trinsdar.gt_foods.data.GTFMaterialTypes;
import trinsdar.gt_foods.data.GTFMaterials;
import trinsdar.gt_foods.data.Guis;
import trinsdar.gt_foods.data.Machines;
import trinsdar.gt_foods.data.RecipeMaps;
import trinsdar.gt_foods.datagen.GTFBlockLootProvider;
import trinsdar.gt_foods.datagen.GTFBlockStateProvider;
import trinsdar.gt_foods.datagen.GTFBlockTagProvider;
import trinsdar.gt_foods.datagen.GTFItemModelProvider;
import trinsdar.gt_foods.datagen.GTFItemTagProvider;
import trinsdar.gt_foods.datagen.GTFLangProvider;
import trinsdar.gt_foods.datagen.GTFRecipeProvider;
import trinsdar.gt_foods.loader.BathingLoader;
import trinsdar.gt_foods.loader.CraftingTableLoader;
import trinsdar.gt_foods.loader.FermenterLoader;
import trinsdar.gt_foods.loader.MixingLoader;
import trinsdar.gt_foods.loader.SlicerLoader;

import java.util.function.BiConsumer;

import static trinsdar.gt_foods.GTFoods.MODID;

public class GTFAntimatterAddon extends AntimatterMod {
    public GTFAntimatterAddon(){
        AntimatterDynamics.addProvider(MODID, g -> new GTFBlockStateProvider(MODID, "GT Foods BlockStates", g));
        AntimatterDynamics.addProvider(MODID, GTFItemModelProvider::new);
        AntimatterDynamics.addProvider(MODID, GTFLangProvider::new);
        new GTFRegistrar();
        MinecraftForge.EVENT_BUS.addListener(GTFAntimatterAddon::registerRecipeLoaders);
        MinecraftForge.EVENT_BUS.addListener(GTFAntimatterAddon::registerCraftingLoaders);
        MinecraftForge.EVENT_BUS.addListener(GTFAntimatterAddon::onProviders);
    }

    private static void registerRecipeLoaders(AntimatterLoaderEvent event) {
        BiConsumer<String, IRecipeRegistrate.IRecipeLoader> loader = (a, b) -> event.registrat.add(MODID, a, b);
        loader.accept("slicer_food", SlicerLoader::init);
        loader.accept("mixing_food", MixingLoader::init);
        //loader.accept("juicing_food", JuicerLoader::init);
        loader.accept("fermenting_food", FermenterLoader::init);
        loader.accept("bathing_food", BathingLoader::init);
    }

    private static void registerCraftingLoaders(AntimatterCraftingEvent event){
        //event.addLoader(FurnaceLoader::loadRecipes);
        //event.addLoader(CraftingTableLoader::loadRecipes);
        event.addLoader(CraftingTableLoader::registerMachineRecipes);
    }

    private static void onProviders(AntimatterProvidersEvent event){
        if (event.getSide() == Dist.CLIENT) return;
        /*final AntimatterBlockTagProvider[] p = new AntimatterBlockTagProvider[1];
        event.addProvider(Ref.ID, g -> {
            p[0] = new GTFBlockTagProvider(MODID, "GT Foods Block Tags", false, g, new ExistingFileHelperOverride());
            return p[0];
        });
        event.addProvider(Ref.ID, g -> new GTFItemTagProvider(MODID, "GT Foods Item Tags", false, g, p[0], new ExistingFileHelperOverride()));*/
        event.addProvider(Ref.ID, g -> new GTFBlockLootProvider(MODID, "GT Foods Loot generator",g));
    }

    @Override
    public String getId() {
        return GTFoods.MODID;
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        if (event == RegistrationEvent.DATA_INIT){
            GTFMaterialTypes.init();
            GTFMaterials.init();
            RecipeMaps.AntimatterMaps.init();
            Machines.init();
            Guis.init();
        }
    }

    @Override
    public int getPriority() {
        return 200000;
    }

    @Override
    public void onGatherData(GatherDataEvent e) {
        super.onGatherData(e);
        final GTFBlockTagProvider p = new GTFBlockTagProvider(MODID, e.getGenerator(), new ExistingFileHelperOverride());
        e.getGenerator().addProvider(p);
        e.getGenerator().addProvider(new GTFItemTagProvider(MODID, e.getGenerator(), p, new ExistingFileHelperOverride()));
        e.getGenerator().addProvider(new GTFBlockLootProvider(MODID, "GT Foods Loot generator", e.getGenerator()));
        e.getGenerator().addProvider(new GTFRecipeProvider(MODID, "GT Foods Recipe Generator", e.getGenerator()));
    }
}
