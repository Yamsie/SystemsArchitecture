package bll.models;

import java.io.*;
import java.util.Properties;

public class Settings
{
    private static Settings instance;
    private Properties property;

    private Settings()
    {
        property = new Properties();
        readProperty();
    }

    public static Settings getInstance()
    {
        if(instance == null)
            instance = new Settings();
        return instance;
    }

    public String getProperty(String text)
    {
        return property.getProperty(text);
    }

    private void readProperty()
    {
        try
        {
            InputStream is = new FileInputStream("dataConfig.properties");
            property.load(is);
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
