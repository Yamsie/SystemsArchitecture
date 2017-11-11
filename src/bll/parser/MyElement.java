package bll.parser;

public class MyElement implements Cloneable
{
    private String pageURL = "default";
    private String elementType = "";
    private String elementID = "";
    private String elementName = "";
    private String elementClass = "";
    private String elementXPath = "";
    private String input = "";

    public MyElement () {
    }

    public MyElement(String pageURL, String elementType, String elementID, String elementName, String elementClass) {
        this.pageURL = pageURL;
        this.elementType = elementType;
        this.elementID = elementID;
        this.elementName = elementName;
        this.elementClass = elementClass;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public MyElement clone() throws CloneNotSupportedException {
        return (MyElement) super.clone();
    }
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getPageURL() {
        return pageURL;
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

    public boolean isEmpty() {
        return (elementID.equals("") && elementName.equals("") && elementName.equals(""));
    }
}
