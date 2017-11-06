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
    private String selected = "";

    public TestSelectionController () { }

    public void initialize(URL location, ResourceBundle resources) {

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.doQuery();
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
    protected void handleRunButtonAction() {
        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("*"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", selected));
        queryBuilder.doQuery();
        Query query = queryBuilder.getResult();
        List<String> data = query.getResult();

        //all data returned is in data.get(0), should be separated out into diff indexes
        //for(int i =0; i < data.size(); i++){
        //    System.out.println(data.get(i)); }

        TestCase tc = new TestCase(data);
        tc.runTest();
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
            ex.printStackTrace();
        }
    }
}

