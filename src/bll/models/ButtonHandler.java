package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ButtonHandler implements I_ElementHandler {

    public ButtonHandler() { }

    public String getType(){ return "button"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = "Success: test for button element "+element.getElementName()+" been successful";
        driver.get(element.getPageURL());
        try{
            Thread.sleep(10000); //sleep, allow page to load
            WebElement e = driver.findElement(By.id(element.getElementID()));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //makes driver wait until page is fully loaded
            e.click();
        }
        catch(Exception ex){
            loggerMessage = "Fail: test for button element "+element.getElementName()+" has failed" + ex.getStackTrace();
        }
        return loggerMessage;
    }
}
