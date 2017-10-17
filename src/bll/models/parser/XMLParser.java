package bll.models.parser;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.util.List;

public class XMLParser
{
    public void parse(String url)
    {
        SAXBuilder saxBuilder = new SAXBuilder();
        try
        {
            Document document = saxBuilder.build(url);
            Element classElement = document.getRootElement();
            List<Element> elementList = classElement.getChildren();

            for (int i = 0; i < elementList.size(); i++) {
                Element e = elementList.get(i);
                System.out.println("\n\n"+e.getAttribute("type").getValue() +"\t"+e.getChildren());
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
