package bll.models.dataformatter;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class JSONFormatter implements I_DataFormatter {
    public void convertFile(String rootElement, ArrayList<String[]> list) {
        JSONArray jArray = new JSONArray();
        for (String [] objects : list) {
            if (objects[1].equals("") && objects[2].equals("") && objects[3].equals("") && objects[4].equals(""))
                continue;
            JSONObject obj = new JSONObject();
            obj.put("element", objects[0]);
            for (int i = 0; i < attr.length; i++) {
                if (!objects[i+1].equals(""))
                  obj.put(attr[i], objects[i+1]);
            }
            jArray.add(obj.toJSONString());
        }
        try (FileWriter file = new FileWriter("src/json/pages/" + rootElement + ".json")) {
            file.write(jArray.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}