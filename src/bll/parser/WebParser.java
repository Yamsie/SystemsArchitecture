package bll.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.dataformatter.I_DataFormatter;
import bll.dataformatter.XMLFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebParser
{
    private I_DataFormatter fileFormat;

    public WebParser()
    {
        this.fileFormat = new XMLFormatter();
    }

    public void setFileFormat(I_DataFormatter fileFormat)
    {
        this.fileFormat = fileFormat;
    }

    public boolean parse(String nameOfFile, String file)
    {
        List<MyElement> list = new ArrayList<>();
        try
        {
            org.jsoup.nodes.Document document = Jsoup.connect(file).get();
            Elements elements = document.body().select("a, input[type=email], input[type=password], input[type=submit], input[type=text], input[type=radio], input[type=checkbox], button, select");
            for(Element e: elements)
            {
                list.add(new MyElement(
                        file,
                        e.attr("type").matches("(submit|radio|checkbox)") ? "button" : e.nodeName(),
                        e.attr("id"),
                        e.attr("name"),
                        e.attr("class")
                ));
            }
            fileFormat.convertFile(nameOfFile, list);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return list.size() != 0;
    }
}