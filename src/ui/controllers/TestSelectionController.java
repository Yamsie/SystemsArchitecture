package ui.controllers;

import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelectionController implements Initializable {

    @FXML
    private ListView list;
    private String selected = "";

    public TestSelectionController () { }

    public void initialize(URL location, ResourceBundle resources) {

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(new TableTestCases());

        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            values.add(data.get(i));
        }
        list.setItems(FXCollections.observableList(values));
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String old, String newV) {
                setSelected(newV);
            }
        });
        }

    public void handleRunTest(){

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", this.selected));

        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();
        String site = "https://www." + data.get(0);

        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); // driver name and location
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null"); // directs driver log to null device to be discarded (Doesn't show weird messages in cmd prompt)
        WebDriver driver = new FirefoxDriver(); // Create instance of the webdriver, optional can pass a profile
        driver.get(site); // open browser with page
        System.out.println("Page title is: " + driver.getTitle()); // get page title
        try
        {
            Thread.sleep(3000); // Pause for 3 seconds, not recommended only for example
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.close(); // Stop and close the browser
    }

    public void setSelected(String s){ this.selected = s; }

}

