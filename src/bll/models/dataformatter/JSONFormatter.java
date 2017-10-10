package bll.models.dataformatter;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFormatter implements IDataFormatter {

    // This is very bad inefficient code, all my stuff is but im not worried about that
    public void convertFile(String rootElement, ArrayList<String[]> list) {

        String[] attr = {"id", "name", "url"};
        JSONArray jArray = new JSONArray();


        for (String [] objects : list) {
            if (objects[1].equals("") && objects[1].equals("") && objects[1].equals(""))
                continue;

            JSONObject obj = new JSONObject(); // very bad, will work on it some more ya ya

            obj.put("element", objects[0]);

            for (int i = 0; i < attr.length; i++) {
                if (!objects[i+1].equals("")) {
                  obj.put(attr[i], objects[i+1]);
                }
            }
            jArray.add(obj.toJSONString());
        }

        try (FileWriter file = new FileWriter("src/json/" + rootElement + ".json")) {
            file.write(jArray.toJSONString());
            file.flush();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}