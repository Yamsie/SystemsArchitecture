package bll;

import bll.models.Settings;
import bll.parser.MyElement;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLTestCreator
{
    private Element [] elementArray = new Element[7];
    private DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();

    public XMLTestCreator() {}

    public void createTest(String nameOfTest, ObservableList<MyElement> arrayList)
    {
        try
        {
            DocumentBuilder docBuilder = xmlFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element root = document.createElement("test");
            document.appendChild(root);
            for(MyElement e: arrayList)
            {
                Element element = document.createElement("element");
                root.appendChild(element);
                elementArray[0] = document.createElement("home");
                elementArray[0].appendChild(document.createTextNode(e.getPageURL()));

                elementArray[1] = document.createElement("type");
                elementArray[1].appendChild(document.createTextNode(e.getElementType()));

                elementArray[2] = document.createElement("id");
                elementArray[2].appendChild(document.createTextNode(e.getElementID()));

                elementArray[3] = document.createElement("class");
                elementArray[3].appendChild(document.createTextNode(e.getElementClass()));

                elementArray[4] = document.createElement("name");
                elementArray[4].appendChild(document.createTextNode(e.getElementName()));

                elementArray[5] = document.createElement("xpath");
                elementArray[5].appendChild(document.createTextNode(e.getElementXPath()));

                elementArray[6] = document.createElement("input");
                elementArray[6].appendChild(document.createTextNode(e.getInput()));

                for (Element el : elementArray)
                    element.appendChild(el);
            }
            XMLWriter.writeTest(nameOfTest, Settings.getInstance().getProperty("XML_TEST_PATH"), document);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }
}
