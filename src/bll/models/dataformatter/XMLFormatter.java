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

public class XMLFormatter implements I_DataFormatter
{
    public void convertFile(String rootName, ArrayList<String[]> list)
    {
        Element element, child;
        try
        {
            DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = xmlFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element rootElement = document.createElement("root");
            document.appendChild(rootElement);
            Attr type = document.createAttribute("page");
            type.setValue(rootName);
            rootElement.setAttributeNode(type);
            for(String [] array: list)
            {
                // Doesnt create elements with no attributes, looks ugly I know
                if(array[1].equals("") && array[2].equals("") && array[3].equals("") && array[3].equals("") && array[4].equals(""))
                    continue;

                    element = document.createElement("element");
                    rootElement.appendChild(element);
                    type = document.createAttribute("type");
                    type.setValue(array[0]);
                    element.setAttributeNode(type);
                    for(int i = 0; i < attr.length; i++)
                    {
                        child = document.createElement(attr[i]);
                        child.appendChild(document.createTextNode(array[i+1]));
                        element.appendChild(child);
                    }
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("src/xml/" + rootName + ".xml"));
                transformer.transform(source, result);
        }
        catch (ParserConfigurationException | TransformerException | DOMException e)
        {
            e.printStackTrace();
        }
    }
}