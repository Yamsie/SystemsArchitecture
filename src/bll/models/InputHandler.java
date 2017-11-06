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
        String loggerMessage = "Success: test for element "+element.getElementName()+" been successful";
        try{
            WebElement e = driver.findElement(By.id(element.getElementID()));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //makes driver wait until page is fully loaded
            String in = element.getInput();
            e.clear();
            e.sendKeys(in);
        }
        catch(Exception ex){
            loggerMessage = "Fail: test for element "+element.getElementName()+" has failed" + ex.getStackTrace();
        }
        return loggerMessage;
    }
}
