package org.example.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.CreateTripTA;
import org.example.models.LoginTA;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonTestDataHelper {
    private static JsonTestDataHelper instance;

    private static final Logger logger = LogManager.getLogger(JsonTestDataHelper.class);

    private JsonTestDataHelper(){
    }

    public static JsonTestDataHelper getInstance(){
        if (instance == null){
            //synchronized block to remove overhead
            synchronized (JsonTestDataHelper.class){
                if(instance==null){
                    // if instance is null, initialize
                    instance = new JsonTestDataHelper();
                    logger.info("JsonTestDataHelper created");
                }
            }
        }
        return instance;
    }

    public <T> Object[] getTestData(String filePath, Class<T> clazz) throws FileNotFoundException {
        logger.info("filePath: " + filePath);
        JsonReader reader = new JsonReader(new FileReader(filePath));
        List<T> testDataList = new Gson().fromJson(reader, TypeToken.getParameterized(ArrayList.class, clazz).getType());
        logger.info("TestData: " + testDataList.toString());
        return testDataList.toArray();
    }

    public static Object[][] combinedDataProvider(Object[] firstData, Object[] secondData) {
        int maxLength = Math.max(firstData.length, secondData.length);

        Object[][] combinedData = new Object[maxLength][2];

        for (int i = 0; i < maxLength; i++) {
            if (i < firstData.length) {
                combinedData[i][0] = firstData[i];
            } else {
                combinedData[i][0] = null;
            }

            if (i < secondData.length) {
                combinedData[i][1] = secondData[i];
            } else {
                combinedData[i][1] = null;
            }
        }

        return combinedData;
    }

    public static void updateJsonFieldInFile(String filePath, String fieldName, String newValue) throws IOException, InterruptedException {
        JsonReader reader = new JsonReader(new FileReader(filePath));

        Type type = new TypeToken<List<JsonObject>>(){}.getType();
        List<JsonObject> jsonObjects = new Gson().fromJson(reader, type);

        if (jsonObjects != null && !jsonObjects.isEmpty()) {
            for (JsonObject jsonObject : jsonObjects) {
                if (jsonObject.has(fieldName)) {
                    jsonObject.addProperty(fieldName, newValue);
                }
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(jsonObjects, writer);
        writer.close();
        Thread.sleep(3000);
    }
}
