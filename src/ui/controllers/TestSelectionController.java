package ui.controllers;

import bll.models.TestCase;
import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelectionController implements Initializable, IController{

    @FXML
    private ListView list;
    @FXML
    private Button run;
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
            @Override //is override needed?
            public void changed(ObservableValue<? extends String> observable, String old, String newV) {
                setSelected(newV); }});
        }

    @FXML
    protected void handleSubmitButtonAction() {
        //(int id, String url, String element, String input, String name) {
        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("id"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", this.selected));
        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();

        I_QueryBuilder queryBuilder2 = new QueryBuilder();
        queryBuilder2.setDataOperation(new SelectOperation("url"));
        queryBuilder2.setTargetFile(new TableTestCases());
        queryBuilder2.addClause(new WhereClause("name", this.selected));
        Query query2 = queryBuilder2.getResult();
        List<String> data2 = query2.getResult();

        I_QueryBuilder queryBuilder3 = new QueryBuilder();
        queryBuilder3.setDataOperation(new SelectOperation("element"));
        queryBuilder3.setTargetFile(new TableTestCases());
        queryBuilder3.addClause(new WhereClause("name", this.selected));
        Query query3 = queryBuilder3.getResult();
        List<String> data3 = query3.getResult();

        I_QueryBuilder queryBuilder4 = new QueryBuilder();
        queryBuilder4.setDataOperation(new SelectOperation("input"));
        queryBuilder4.setTargetFile(new TableTestCases());
        queryBuilder4.addClause(new WhereClause("name", this.selected));
        Query query4 = queryBuilder4.getResult();
        List<String> data4 = query4.getResult();

        int id = Integer.parseInt(data.get(0));
        String url = data2.get(0);
        String element = data3.get(0);
        String input = data4.get(0);

        TestCase tc = new TestCase(id, url, element, input, this.selected);
        tc.runTest();

    }

    public void handleRunTest(){

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", this.selected));

        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();
        TestCase tc = new TestCase(data);
        tc.runTest();
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

    public String getName(){
        return "TestSelectionController";
    }

    public void changeScene(Stage st){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testselection.fxml"));
            Scene scene = new Scene(root);
            st.setTitle(this.getName());
            st.setScene(scene);
            st.show();
        }
        catch(Exception ex){
            System.out.println("Exception caught in TestSelectionController changeScene()");
        }
    }
}

