package bll.models;

import bll.models.parser.MyElement;
import javafx.collections.ObservableList;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLTestCreator {
    private DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
    private Element [] elementArray = new Element[7];

    public XMLTestCreator() {

    }

    public void createTest(String nameOfTest, ObservableList<MyElement> arrayList) {
        try {
            DocumentBuilder docBuilder = xmlFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element root = document.createElement("test");
            document.appendChild(root);

            for(MyElement e: arrayList) {
                Element element = document.createElement("element");
                root.appendChild(element);
                elementArray[0] = document.createElement("homepage");
                elementArray[0].appendChild(document.createTextNode(e.getPageURL()));
                elementArray[1] = document.createElement("type");
                elementArray[1].appendChild(document.createTextNode(e.getElementType()));
                elementArray[2] = document.createElement("id");
                elementArray[2].appendChild(document.createTextNode(e.getElementID()));
                elementArray[3] = document.createElement("class");
                elementArray[3].appendChild(document.createTextNode(e.getElementClass()));
                elementArray[4] = document.createElement("name");
                elementArray[4].appendChild(document.createTextNode(e.getElementName()));
                elementArray[5] = document.createElement("url");
                elementArray[5].appendChild(document.createTextNode(e.getElementURL()));
                elementArray[6] = document.createElement("xpath");
                elementArray[6].appendChild(document.createTextNode(e.getElementXPath()));
                elementArray[6] = document.createElement("input");
                elementArray[6].appendChild(document.createTextNode(e.getInput()));
                for (Element el : elementArray)
                    element.appendChild(el);
            }
            writeTest(nameOfTest, document);
        }

        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void writeTest(String nameOfTest, Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src/xml/tests/" + nameOfTest + ".xml"));
            transformer.transform(source, result);
        }

        catch (TransformerException | DOMException e) {
            e.printStackTrace();
        }
    }
}
