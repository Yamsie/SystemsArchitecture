package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputHandler implements IElementHandler {

    public String getType(){ return "input"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = "Success: test for element "+element.getElementName()+" been successful";
        try{
            WebElement e = driver.findElement(By.id(element.getElementID()));
            String in = element.getInput();
            e.clear();
            e.sendKeys(in);
        }
        catch(Exception ex){
            loggerMessage += "Fail: test for element "+element.getElementName()+" has failed" + ex.getStackTrace();
        }
        return loggerMessage;
    }
}
