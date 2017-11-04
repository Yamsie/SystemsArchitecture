package bll.models.parser;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public ArrayList<MyElement> parse(String url) {

        ArrayList<MyElement> myElements = new ArrayList<>();
        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            Document document = saxBuilder.build(url);
            Element classElement = document.getRootElement();
            List<Element> elementList = classElement.getChildren();

            for (Element e : elementList) {
                MyElement myElement = new MyElement(
                        e.getChild("home").getValue(),
                        e.getChild("type").getValue(),
                        e.getChild("id").getText(),
                        e.getChild("name").getText(),
                        e.getChild("class").getText());

                if(e.getChildren().size() > 5) {
                    myElement.setElementXPath(e.getChild("xpath").getText());
                    myElement.setInput(e.getChild("input").getText());
                }
                myElements.add(myElement);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return myElements;
    }
}