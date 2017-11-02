package bll.models.dataformatter;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class XMLFormatter implements I_DataFormatter, Runnable {

    private String name, url;
    private Document document;
    private Element rootElement;
    private ArrayList<String []> list = new ArrayList<>();
    private DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();

    public void convertFile(String rootName, String url, ArrayList<String[]> list) {
        this.name = rootName;
        this.list = list;
        this.url = url;
        new Thread(this).start();
    }

    private void createElements() {
        for(String [] array: list) {
            Element element = document.createElement("element");
            rootElement.appendChild(element);
            Attr type = document.createAttribute("type");
            type.setValue(array[0]);
            Attr hurl = document.createAttribute("home");
            hurl.setValue(url);
            element.setAttributeNode(type);
            element.setAttributeNode(hurl);

            for(int i = 0; i < attr.length; i++) {
                Element child = document.createElement(attr[i]);
                child.appendChild(document.createTextNode((array[i+1].equals("")) ? "null" :  array[i+1]));
                element.appendChild(child);
            }
        }
    }

    private void transformCode() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src/xml/pages/" + name + ".xml"));
            transformer.transform(source, result);
        }

        catch (TransformerException | DOMException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            DocumentBuilder docBuilder = xmlFactory.newDocumentBuilder();
            document = docBuilder.newDocument();
            this.rootElement = document.createElement("root");
            document.appendChild(rootElement);
            Attr type = document.createAttribute("page");
            type.setValue(name);
            rootElement.setAttributeNode(type);
            createElements();
            transformCode();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}