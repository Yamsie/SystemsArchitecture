package bll.models.handlers;

import bll.models.Settings;
import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpanHandler implements I_ElementHandler {

    public SpanHandler() { }

    public String getType(){ return "span"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = "Success: test for span element "+element.getElementName()+" been successful";
        driver.get(element.getPageURL());
        try
        {
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT"))); //sleep, allow page to load
            WebElement e = driver.findElement(By.id(element.getElementID())); //for span element, just check that it exists
        }
        catch(Exception ex)
        {
            loggerMessage = "Fail: test for span element "+element.getElementName()+" has failed" + ex.getStackTrace();
        }
        return loggerMessage;
    }
}
