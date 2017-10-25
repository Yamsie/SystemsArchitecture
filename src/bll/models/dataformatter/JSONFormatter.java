package bll.models.dataformatter;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class JSONFormatter implements I_DataFormatter , Runnable
{
    private String rootElement;
    private ArrayList<String []> list;

    public void convertFile(String rootElement, ArrayList<String[]> list)
    {
        this.rootElement = rootElement;
        this.list = list;
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        JSONArray jArray = new JSONArray();
        for (String [] objects : list)
        {
            JSONObject obj = new JSONObject();
            obj.put("element", objects[0]);

            for (int i = 0; i < attr.length; i++)
                obj.put(attr[i], objects[i+1].equals("") ? "null" : objects[i+1]);

            jArray.add(obj.toJSONString());
        }

        try (FileWriter file = new FileWriter("src/json/pages/" + rootElement + ".json"))
        {
            file.write(jArray.toJSONString());
            file.flush();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}