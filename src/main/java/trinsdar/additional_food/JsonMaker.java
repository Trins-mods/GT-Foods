package trinsdar.additional_food;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.minecraft.item.Item;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.File;
import java.io.FileWriter;

public class JsonMaker {
    public static void initModels(){
        File lang = new File("/home/trinsdar/IdeaProjects/modprojects/Additional-Food/src/main/resources/assets/additional_food/lang/en_us.json");
        JsonWriter writerLang;
        try {
            lang.createNewFile();
            writerLang = new JsonWriter(new FileWriter(lang));
            writerLang.beginObject();
            writerLang.setIndent("  ");
            writerLang.name("itemGroup.additional_food").value("Additional Food");
            for(Item item : RegistryItem.getToRegister()){
                try {
                    String name = item.getRegistryName().toString().replaceAll("additional_food:", "");
                    String capitalizedName = capitilization(name);
                    writerLang.name("item." + item.getRegistryName().toString().replace(':', '.')).value(capitalizedName);

                    File file = new File("/home/trinsdar/IdeaProjects/modprojects/Additional-Food/src/main/resources/assets/additional_food/models/item/" + name + ".json");
                    file.createNewFile();
                    JsonWriter writer = new JsonWriter(new FileWriter(file));
                    writer.beginObject();
                    writer.setIndent("  ");
                    writer.name("parent").value("item/generated");
                    writer.name("textures");
                    writer.beginObject();
                    writer.name("layer0").value("additional_food:item/" + name);
                    writer.endObject();
                    writer.endObject();
                    writer.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            writerLang.endObject();
            writerLang.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String capitilization(String original){
        String newString = original.substring(0, 1).toUpperCase() + original.substring(1);
        newString = newString.replace('_', ' ');
        return newString;
    }
}
