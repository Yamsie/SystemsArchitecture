package bll.models;

import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private String name;
    private String xml;
    private List<MyElement> elements;
    private List<I_ElementHandler> handlers;

    public TestCase(List<String> data) {
        handlers = new ArrayList<>();
        //splitting data at the comma, all in data.get(0), separates fine
        String[] ar = data.get(0).split(",");
        //for(int i =0; i < ar.length; i++){
          //  System.out.println(ar[i]); }
        this.name = ar[0];
        this.xml = ar[1];
        setElements();
        setHandlers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<I_ElementHandler> getHandlers() { return this.handlers; }

    public void setHandlers()
    {
        this.handlers.add(new ButtonHandler());
        this.handlers.add(new InputHandler());
    }

    public void setElements(){
        XMLParser parser = new XMLParser();
        this.elements = parser.parse(this.xml);
    }

    public I_ElementHandler lookupHandlerBy(String name){
        I_ElementHandler eh = null;
        for(int i = 0; i < handlers.size() && eh == null; i++) {
            if (handlers.get(i).getType().equals(name))
                eh = handlers.get(i);
        }
        return eh;
    }

    public String runTest()
    {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); // driver name and location
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        String message = "";

        try{
            WebDriver driver = new FirefoxDriver();
            for(MyElement e : elements)
            {
                I_ElementHandler handler = lookupHandlerBy(e.getElementType());
                message += handler.execute(e, driver);
                System.out.println(message);
            }
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT")));
            driver.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return message;
    }
}