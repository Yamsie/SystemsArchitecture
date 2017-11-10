package bll.models.handlers;

import bll.models.Settings;
import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextAreaHandler implements I_ElementHandler{

    public TextAreaHandler() { }

    public String getType(){ return "textarea"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = " Success: test for textarea element "+element.getElementName()+" been successful.";
        try
        {
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT"))); //sleep, allow page to load
            WebElement e = checkElement(driver,  element);
            e.click();
            e.clear();
            e.sendKeys(element.getInput());
        }
        catch(Exception ex)
        {
            loggerMessage = " Fail: test for textarea element "+element.getElementName()+" has failed. Stack trace : " + ex.getStackTrace();
        }
        return loggerMessage;
    }

    private WebElement checkElement(WebDriver driver, MyElement element)
    {
        WebElement e;
        if(!element.getElementID().equals(""))
            e = driver.findElement(By.id(element.getElementID()));
        else e = driver.findElement(By.xpath(element.getElementXPath()));
        return e;
    }
}