package bll.models.parser;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.util.ArrayList;
import java.util.List;

public class XMLParser
{
    // will make this local and send somewhere to populate a dropdown for selection, this is whats used for selenium to create tests
    private ArrayList<MyElement> elementObjects = new ArrayList<>();

    public void parse(String url) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(url);
            Element classElement = document.getRootElement();
            List<Element> elementList = classElement.getChildren();

            for (Element e : elementList) {
                elementObjects.add(new MyElement(document.getRootElement().getAttributeValue("page"),
                        e.getAttribute("type").getValue(), e.getChild("id").getText(), e.getChild("name").getText(),
                        e.getChild("url").getText(), e.getChild("class").getText()));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
