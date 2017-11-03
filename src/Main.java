import bll.models.parser.MyElement;
import bll.models.parser.TestParser;
import javafx.application.Application;
import org.openqa.selenium.support.ui.Select;
import ui.controllers.MainMenuController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Application.launch(MainMenuController.class, args);

        ArrayList<MyElement> list = new TestParser().parse("src/xml/tests/TEST.xml");
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        WebDriver driver = new FirefoxDriver(); // Create instance of the webdriver, optional can pass a profile
        driver.get(list.get(0).getPageURL()); // open browser with page
        WebElement element;

        Select dropdown = new Select(driver.findElement(By.id("month")));
        dropdown.selectByVisibleText("Apr");

        dropdown = new Select(driver.findElement(By.id("day")));
        dropdown.selectByVisibleText("3");

        dropdown = new Select(driver.findElement(By.id("year")));
        dropdown.selectByVisibleText("1989");


        /*
        for (MyElement aList : list)
        {
            element = driver.findElement(By.id(aList.getElementID()));
            element.click();

            if(!aList.getInput().equals("")) {
                element.sendKeys(aList.getInput());
            }
        }
        */
    }
}
