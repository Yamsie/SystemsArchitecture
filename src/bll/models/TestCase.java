package bll.models;

import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase {

    private int id;
    private String name;
    private String xml;
    private String input;
    private List<MyElement> elements;

    public TestCase(List<String> data) {
        //splitting data at the comma, all in data.get(0), separates fine
        String[] ar = data.get(0).split(",");
        //for(int i =0; i < ar.length; i++){
          //  System.out.println(ar[i]); }
        this.id = Integer.parseInt(ar[0]);
        this.name = ar[1];
        this.xml = ar[2];
        this.input = ar[3];
        setElements();
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElements(){
        XMLParser parser = new XMLParser();
        elements = parser.parse(this.xml);
    }

    public void runTest(){

        try{
            WebDriver driver = new FirefoxDriver();
            for(MyElement e : elements) {
                System.out.println(e.getElementName());
                driver.get(e.getPageURL());
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //makes driver wait until page is fully loaded
                WebElement element = driver.findElement(By.id(e.getElementID()));
                //System.out.println(e.getElementID());
                //element.click();
                /*if(e.getElementType().equals("input")) {
                    element.sendKeys(this.input);
                    System.out.println(this.input);
                }*/
                //element.submit();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //driver.close();
    }
}