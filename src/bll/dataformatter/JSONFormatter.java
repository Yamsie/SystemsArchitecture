package bll.dataformatter;

import bll.models.Settings;
import bll.parser.MyElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONFormatter implements I_DataFormatter
{
    @Override
    public void convertFile(String rootElement, List<MyElement> list)
    {
        JSONArray jsonArray = new JSONArray();
        for (MyElement el : list)
        {
            if(el.isEmpty()) continue;
            JSONObject obj = new JSONObject();
            obj.put("home", el.getPageURL());
            obj.put("type", el.getElementType());
            obj.put("id", el.getElementID());
            obj.put("name", el.getElementName());
            obj.put("class", el.getElementClass());
            jsonArray.add(obj);
        }
        try (FileWriter file = new FileWriter(Settings.getInstance().getProperty("JSON_PATH") + rootElement + ".json"))
        {
            file.write(jsonArray.toJSONString());
            file.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}