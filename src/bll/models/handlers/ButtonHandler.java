package bll.models.handlers;

import bll.models.Settings;
import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonHandler implements I_ElementHandler {

    public ButtonHandler() { }

    public String getType(){ return "button"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = " Success: test for button element "+element.getElementName()+" been successful.";
        //driver.get(element.getPageURL());
        try{
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT"))); //sleep, allow page to load
            WebElement e = driver.findElement(By.id(element.getElementID()));
            e.click();
        }
        catch(Exception ex){
            loggerMessage = " Fail: test for button element "+element.getElementName()+" has failed. Stack trace : " + ex.getStackTrace();
        }
        System.out.println(loggerMessage);
        return loggerMessage;
    }
}
