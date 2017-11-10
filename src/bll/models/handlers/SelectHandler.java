package bll.models.handlers;

import bll.models.Settings;
import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectHandler implements I_ElementHandler {

    public SelectHandler() { }

    public String getType(){ return "select"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = " Success: test for select element "+element.getElementName()+" been successful.";
        try
        {
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT"))); //sleep, allow page to load
            Select e = new Select(driver.findElement(By.id(element.getElementID())));
            e.selectByVisibleText(element.getInput());
        }
        catch(Exception ex)
        {
            loggerMessage = " Fail: test for select element "+element.getElementName()+" has failed. Stack trace : " + ex.getStackTrace();
        }
        return loggerMessage;
    }
}