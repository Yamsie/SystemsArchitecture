package bll.models.parser;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.ArrayList;
import java.util.List;

public class TestParser {

    public ArrayList<MyElement> parse(String url) {

        ArrayList<MyElement> myElements = new ArrayList<>();
        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            Document document = saxBuilder.build(url);
            Element classElement = document.getRootElement();
            List<Element> elementList = classElement.getChildren();

            for (Element e : elementList) {
                myElements.add(new MyElement(
                        e.getChild("home").getValue(),
                        e.getChild("type").getValue(),
                        e.getChild("id").getText(),
                        e.getChild("name").getText(),
                        e.getChild("class").getText(),
                        e.getChild("xpath").getText(),
                        e.getChild("input").getText()
                ));
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return myElements;
    }
}
