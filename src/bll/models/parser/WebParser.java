package bll.models.parser;

import java.io.IOException;
import java.util.ArrayList;

import bll.models.dataformatter.IDataFormatter;
import bll.models.dataformatter.XMLFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


public class WebParser {
    private IDataFormatter fileFormat;

    public WebParser() {
        this.fileFormat = new XMLFormatter();
    }

    public WebParser(IDataFormatter fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setFileFormat(IDataFormatter fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void parse(String file) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            org.jsoup.nodes.Document document = Jsoup.connect(file).get();

            for(Element e: document.body().select("a, input, button, textarea")) {
                list.add(new String[]{
                        e.nodeName(),
                        e.attr("id"),
                        e.attr("name"),
                        e.attr("abs:href")
                });
            }
            fileFormat.convertFile(document.title().replaceAll("([^A-Za-z0-9])", "").toLowerCase(), list);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}