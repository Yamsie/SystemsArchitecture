package bll.models.parser;

// Entity class used to store elements for selection to create tests
public class MyElement
{
    private String pageURL;
    private String elementType;
    private String elementID;
    private String elementName;
    private String elementURL;
    private String elementClass;
    private String elementXPath;
    private int elementSleep;

    public MyElement(String pageURL, String elementType, String id, String name, String url, String classType, String xPath, int sleep) {
        this.pageURL = pageURL;
        this.elementType = elementType;
        this.elementID = id;
        this.elementName = name;
        this.elementClass = classType;
        this.elementURL = url;
        this.elementXPath = xPath;
        this.elementSleep = sleep;
    }

    public String getPageURL() {
        return pageURL;
    }

    public String getElementType() {
        return elementType;
    }

    public String getElementID() {
        return elementID;
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementURL() {
        return elementURL;
    }

    public String getElementClass() {
        return elementClass;
    }

    public String getElementXPath() {
        return elementXPath;
    }

    public void setElementXPath(String elementXPath) {
        this.elementXPath = elementXPath;
    }

    public int getElementSleep() {
        return elementSleep;
    }

    public void setElementSleep(int elementSleep) {
        this.elementSleep = elementSleep;
    }
}
