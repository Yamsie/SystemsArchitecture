package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.WebDriver;

public interface I_ElementHandler {
    String getType();
    String execute(MyElement element, WebDriver d);
}
