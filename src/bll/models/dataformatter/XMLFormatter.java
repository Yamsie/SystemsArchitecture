package bll.models.dataformatter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import bll.models.parser.MyElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLFormatter implements I_DataFormatter {

    private String rootName;
    private Document document;
    private List<MyElement> list = new ArrayList<>();

    public void convertFile(String rootName, List<MyElement> list) {
        this.list = list;
        this.rootName = rootName;
        createDocument();
    }

    private void createDocument() {
        try {
            DocumentBuilderFactory xml_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = xml_factory.newDocumentBuilder();
            this.document = docBuilder.newDocument();
            Element rootElement = document.createElement("root");
            document.appendChild(rootElement);
            createElements(document, rootElement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createElements(Document document, Element rootElement) {

        Element element, id, elementName, elementClass, elementType, elementHomeURL;

        for (MyElement el : list) {
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
        writeFile();
    }

    private void writeFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src/xml/pages/" + rootName + ".xml"));
            transformer.transform(source, result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}