package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InputHandler implements IElementHandler {

    public InputHandler() { }

    public String getType(){ return "input"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = "Success: test for input element "+element.getElementName()+" been successful";
        driver.get(element.getPageURL());
        try{
            Thread.sleep(10000); //sleep, allow page to load
            WebElement e = driver.findElement(By.id(element.getElementID()));
            String in = element.getInput();
            System.out.println("input is "+in);
            e.click();
            e.clear();
            e.sendKeys(in);
            e.submit();
        }
        catch(Exception ex){
            loggerMessage = "Fail: test for input element "+element.getElementName()+" has failed" + ex.getStackTrace();
        }
        return loggerMessage;
    }
}