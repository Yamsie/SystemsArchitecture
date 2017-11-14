package bll.dataformatter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import bll.models.Settings;
import bll.XMLWriter;
import bll.parser.MyElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class XMLFormatter implements I_DataFormatter
{
    private String rootName;
    private List<MyElement> list = new ArrayList<>();

    public void convertFile(String rootName, List<MyElement> list)
    {
        this.list = list;
        this.rootName = rootName;
        createDocument();
    }

    private void createElements(Document document, Element rootElement)
    {
        Element element, id, elementName, elementClass, elementType, elementHomeURL;
        for (MyElement el : list)
        {
            if(el.isEmpty()) continue;
            element = document.createElement("element");
            elementHomeURL = document.createElement("home");
            elementType = document.createElement("type");
            id = document.createElement("id");
            elementName = document.createElement("name");
            elementClass = document.createElement("class");

            elementHomeURL.appendChild(document.createTextNode(el.getPageURL()));
            elementType.appendChild(document.createTextNode(el.getElementType()));
            id.appendChild(document.createTextNode(el.getElementID()));
            elementName.appendChild(document.createTextNode(el.getElementName()));
            elementClass.appendChild(document.createTextNode(el.getElementClass()));

            element.appendChild(elementHomeURL);
            element.appendChild(elementType);
            element.appendChild(id);
            element.appendChild(elementName);
            element.appendChild(elementClass);
            rootElement.appendChild(element);
        }
        XMLWriter.writeTest(rootName, Settings.getInstance().getProperty("XML_PATH"), document);
    }

    private void createDocument()
    {
        try
        {
            DocumentBuilderFactory xml_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = xml_factory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element rootElement = document.createElement("root");
            document.appendChild(rootElement);
            createElements(document, rootElement);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}