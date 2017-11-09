package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputHandler implements I_ElementHandler {

    public InputHandler() { }

    public String getType(){ return "input"; }

    public String execute(MyElement element, WebDriver driver){
        String loggerMessage = "Success: test for input element "+element.getElementName()+" been successful\n";
        driver.get(element.getPageURL());
        try
        {
            Thread.sleep(Integer.parseInt(Settings.getInstance().getProperty("TIME_OUT"))); //sleep, allow page to load
            WebElement e = driver.findElement(By.id(element.getElementID()));
            String in = element.getInput();
            e.click();
            e.clear();
            e.sendKeys(in);
            e.submit();
        }
        catch(Exception ex)
        {
            loggerMessage = "Fail: test for input element "+element.getElementName()+" has failed" + ex.getStackTrace()+"\n";
        }
        return loggerMessage;
    }
}