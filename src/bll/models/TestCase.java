package bll.models;

import bll.models.parser.MyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestCase {
    //1,google.com,textBox,"Test Google Search","hello"
    private int id;
    private String url;
    private String element;
    private MyElement e;
    private String input;
    private String name;

    public TestCase(int id, String url, String element, String input, String name) {
        this.id = id;
        this.url = url;
        this.element = element;
        this.input = input;
        this.name = name;
    }

    public TestCase(String[] data) {
        this.id = Integer.parseInt(data[0]);
        this.url = data[1];
        this.element = data[2];
        this.input = data[3];
        this.name = data[4];
    }

    public TestCase(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.url = data.get(1);
        this.element = data.get(2);
        this.input = data.get(3);
        this.name = data.get(4);
    }

    /*public TestCase(String name){
        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", name));

        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();

        for(int i =0; i < data.size(); i ++){
            System.out.println(data.get(i));
        }
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTextBox() {
        return element;
    }

    public void setTextBox(String textBox) {
        this.element = textBox;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void runTest(){
        WebDriver driver = new FirefoxDriver();
        String site = "https://" + this.url;
        driver.get(site);
      //  WebElement element = driver.findElement(By.id(this.e.getElementID()));
      //  element.click();
      //  element.sendKeys(this.input);
      //  element.submit();
      //  System.out.println("Page title is: " + driver.getTitle());
    }
}
