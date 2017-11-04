package bll.models.dataformatter;

import bll.models.parser.MyElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class JSONFormatter implements I_DataFormatter {

    @Override
    public void convertFile(String rootElement, List<MyElement> list) {
        JSONObject obj;
        JSONArray jsonArray = new JSONArray();

        for (MyElement el : list) {
            if(el.isEmpty()) continue;
            obj = new JSONObject();
            obj.put("home", el.getPageURL());
            obj.put("element", el.getElementType());
            obj.put("id", el.getElementID());
            obj.put("name", el.getElementName());
            obj.put("class", el.getElementClass());
            jsonArray.add(obj.toJSONString());
        }

        try (FileWriter file = new FileWriter("src/json/pages/" + rootElement + ".json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}