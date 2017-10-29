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

    public MyElement(String pageURL, String elementType, String id, String name, String url, String classType) {
        this.pageURL = pageURL;
        this.elementType = elementType;
        this.elementID = id;
        this.elementName = name;
        this.elementClass = classType;
        this.elementURL = url;
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
}
