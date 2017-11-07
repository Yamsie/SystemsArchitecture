package bll.models;

import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private int id;
    private String name;
    private String xml;
    private List<MyElement> elements;
    private List<IElementHandler> handlers;

    public TestCase(List<String> data) {
        handlers = new ArrayList<>();
        //splitting data at the comma, all in data.get(0), separates fine
        String[] ar = data.get(0).split(",");
        //for(int i =0; i < ar.length; i++){
          //  System.out.println(ar[i]); }
        this.id = Integer.parseInt(ar[0]);
        this.name = ar[1];
        this.xml = ar[2];
        setElements();
        setHandlers();
    }

    /*public TestCase(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        this.xml = data.get(2);
        this.input = data.get(3);
        setElements();
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public String getInput() {return input;}

    //public void setInput(String input) {this.input = input;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IElementHandler> getHandlers() { return this.handlers; }

    public void setHandlers()
    {
        this.handlers.add(new ButtonHandler());
        this.handlers.add(new InputHandler());
    }

    public void setElements(){
        XMLParser parser = new XMLParser();
        this.elements = parser.parse(this.xml);
    }

    public IElementHandler lookupHandlerBy(String name){
        IElementHandler eh = null;
        for(int i = 0; i < handlers.size() && eh == null; i++) {
            if (handlers.get(i).getType().equals(name))
                eh = handlers.get(i);
        }
        return eh;
    }

    public void runTest()
    {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); // driver name and location
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        try{
            WebDriver driver = new FirefoxDriver();
            for(MyElement e : elements) {
                IElementHandler handler = lookupHandlerBy(e.getElementType());
                String message = handler.execute(e, driver);
                System.out.println(message);
            }
            driver.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}