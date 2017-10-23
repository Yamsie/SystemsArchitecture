package bll.models.parser;

import java.io.IOException;
import java.util.ArrayList;
import bll.models.dataformatter.I_DataFormatter;
import bll.models.dataformatter.XMLFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class WebParser
{
    private I_DataFormatter fileFormat;

    public WebParser()
    {
        this.fileFormat = new XMLFormatter();
    }

    public WebParser(I_DataFormatter fileFormat)
    {
        this.fileFormat = fileFormat;
    }

    public void setFileFormat(I_DataFormatter fileFormat)
    {
        this.fileFormat = fileFormat;
    }

    public void parse(String file)
    {
        ArrayList<String[]> list = new ArrayList<>();
        try
        {
            org.jsoup.nodes.Document document = Jsoup.connect(file).get();
            for(Element e: document.body().select("a, input, button, textarea"))
            {
                list.add(new String [] {
                        e.nodeName(),
                        e.attr("id"),
                        e.attr("name"),
                        e.attr("abs:href"),
                        e.attr("class")
                });
            }
            fileFormat.convertFile(document.title().replaceAll("([^A-Za-z0-9])", "").toLowerCase(), list);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}