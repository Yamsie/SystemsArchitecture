package bll.models.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import bll.models.dataformatter.I_DataFormatter;
import bll.models.dataformatter.XMLFormatter;
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
            Elements elements = document.body().select("a, input[type=submit], input[type=text], " +
                    "select, input[type=radio], input[type=checkbox], textarea, button, span, div");

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