package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.WebDriver;

public interface IElementHandler {
    String getType();
    String execute(MyElement element, WebDriver d);
}
