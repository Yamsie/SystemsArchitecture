package bll.models.parser;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import  org.json.simple.parser.JSONParser;

public class MyJSONParser
{
    public ArrayList<MyElement> parse(String url)
    {
        ArrayList<MyElement> myElements = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try
        {
            Object obj = parser.parse(new FileReader(url));
            JSONArray jsonArray = (JSONArray) obj;
            for(int i = 0; i < jsonArray.size(); i++)
            {
                JSONObject e = (JSONObject) jsonArray.get(i);
                MyElement myElement = new MyElement(
                       (String) e.get("home"),
                       (String) e.get("type"),
                       (String) e.get("id"),
                       (String) e.get("name"),
                       (String) e.get("class"));
                if(e.size() > 5)
                {
                    myElement.setElementXPath((String) e.get("xpath"));
                    myElement.setInput((String) e.get("input"));
                }
                myElements.add(myElement);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return myElements;
    }
}
