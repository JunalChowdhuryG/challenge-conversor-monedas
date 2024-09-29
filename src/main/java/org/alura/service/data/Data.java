package org.alura.service.data;

import org.alura.dto.AllCoins;
import org.alura.service.consumeAPI.ConsumeAPI;
import com.google.gson.*;
import java.io.IOException;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.Reader;


public class Data {

    private final ConsumeAPI api;


    public Data() {
        this.api = new ConsumeAPI(System.getenv("API_KEY"));
    }

    public Map<String, Object> getCoins() throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        Gson gson2 = new Gson();

        AllCoins allCoins = gson.fromJson(api.getRequest() ,AllCoins.class);
        Map<String , Object>  map = gson2.fromJson(allCoins.conversion_rates().toString(), Map.class);
        return map;
    }

    //java/org/alura/data/list_code.json
    public Map<String , Object> getCurrencyCode() throws FileNotFoundException {
        String file = "src/main/java/org/alura/data/list_code.json";
        Gson gson = new Gson();
        Reader reader = new FileReader(file);
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        Map<String, Object> map = gson.fromJson(jsonObject, Map.class);
        return map;
    }
}
