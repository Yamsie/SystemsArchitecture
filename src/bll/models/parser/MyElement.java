package bll.models.parser;

public class MyElement
{
    private String pageURL = "null";
    private String elementType = "null";
    private String elementID = "null";
    private String elementName = "null";
    private String elementURL = "null";
    private String elementClass = "null";
    private String elementXPath = "null";
    private String input = "null";

    public MyElement() {

    }

    public MyElement(String pageURL, String elementType, String elementID, String elementName, String elementURL, String elementClass, String elementXPath) {
        this.pageURL = pageURL;
        this.elementType = elementType;
        this.elementID = elementID;
        this.elementName = elementName;
        this.elementURL = elementURL;
        this.elementClass = elementClass;
        this.elementXPath = elementXPath;
    }

    public MyElement(MyElement element) {
        this.pageURL = element.getPageURL();
        this.elementType = element.getElementType();
        this.elementID = element.getElementID();
        this.elementName = element.getElementName();
        this.elementURL = element.getElementURL();
        this.elementClass = element.getElementClass();
        this.elementXPath = element.getElementXPath();
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementID() {
        return elementID;
    }

    public void setElementID(String elementID) {
        this.elementID = elementID;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementURL() {
        return elementURL;
    }

    public void setElementURL(String elementURL) {
        this.elementURL = elementURL;
    }

    public String getElementClass() {
        return elementClass;
    }

    public void setElementClass(String elementClass) {
        this.elementClass = elementClass;
    }

    public String getElementXPath() {
        return elementXPath;
    }

    public void setElementXPath(String elementXPath) {
        this.elementXPath = elementXPath;
    }
}
