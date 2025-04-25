package Framework.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class DataReader  {
    //convert .json file to List of Hashmap
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        //read .json file to string
        String jsonContent = FileUtils.readFileToString(new File("C:\\Users\\mohini.c.in\\IdeaProjects\\SeleniumFramework\\src\\test\\java\\Framework\\data\\PurchaseOrder.json"),
                StandardCharsets.UTF_8);

//        String to HashMap - Jackson Databind
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
        return data;
    }
}
