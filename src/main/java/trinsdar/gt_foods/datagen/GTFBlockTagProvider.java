package trinsdar.gt_foods.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gt_foods.GTFoods;
import trinsdar.gt_foods.blocks.BlockLeaves;
import trinsdar.gt_foods.blocks.BlockLogStrippable;
import trinsdar.gt_foods.blocks.BlockPlanks;
import trinsdar.gt_foods.data.GTFData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GTFBlockTagProvider extends AntimatterBlockTagProvider {
    public GTFBlockTagProvider(String providerDomain, String providerName, boolean replace, DataGenerator gen, ExistingFileHelper helper) {
        super(providerDomain, providerName, replace, gen, helper);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        AntimatterAPI.all(BlockLogStrippable.class, domain, b -> this.tag(BlockTags.LOGS).add(b));
        AntimatterAPI.all(BlockLeaves.class, domain, b -> this.tag(BlockTags.LEAVES).add(b));
        AntimatterAPI.all(BlockPlanks.class, domain, b -> this.tag(BlockTags.PLANKS).add(b));
        this.tag(TagUtils.getBlockTag(new ResourceLocation(GTFoods.MODID, "cinnamon_logs"))).add(GTFData.CINNAMON_LOG, GTFData.STRIPPED_CINNAMON_LOG, GTFData.CINNAMON_WOOD, GTFData.STRIPPED_CINNAMON_WOOD);
    }

    public void run(DirectoryCache pCache) {
        this.builders.clear();
        this.addTags();
        ITag<Block> itag = Tag.empty();
        Function<ResourceLocation, ITag<Block>> function = (p_240523_2_) -> {
            return this.builders.containsKey(p_240523_2_) ? itag : null;
        };
        Function<ResourceLocation, Block> function1 = (p_240527_1_) -> {
            return this.registry.getOptional(p_240527_1_).orElse(null);
        };
        this.builders.forEach((p_240524_4_, p_240524_5_) -> {
            // FORGE: Add validation via existing resources
            List<ITag.Proxy> list = p_240524_5_.getUnresolvedEntries(function, function1).filter(this::missing).collect(Collectors.toList());
            if (!list.isEmpty()) {
                throw new IllegalArgumentException(String.format("Couldn't define tag %s as it is missing following references: %s", p_240524_4_, list.stream().map(Objects::toString).collect(Collectors.joining(","))));
            } else {
                JsonObject jsonobject = p_240524_5_.serializeToJson();
                Path path = this.getPath(p_240524_4_);
                if (path == null) return; //Forge: Allow running this data provider without writing it. Recipe provider needs valid tags.

                try {
                    String s = GSON.toJson((JsonElement)jsonobject);
                    String s1 = SHA1.hashUnencodedChars(s).toString();
                    if (!Objects.equals(pCache.getHash(path), s1) || !Files.exists(path)) {
                        Files.createDirectories(path.getParent());

                        try (BufferedWriter bufferedwriter = Files.newBufferedWriter(path)) {
                            bufferedwriter.write(s);
                        }
                    }

                    pCache.putNew(path, s1);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save tags to {}", path, ioexception);
                }

            }
        });
    }
}
