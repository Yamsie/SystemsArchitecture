package ui.controllers;


import bll.models.NewTestScenarioModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ui.views.FactoryViewCreator;
import ui.views.I_View;
import ui.views.NewTestScenarioView;

public class NewTestScenarioController implements Command{

    @FXML
    Button addTestInput;

    @FXML
    TableView tableView;

    NewTestScenarioModel model;
    NewTestScenarioView view;
    public String name = "NewTestScenarioController";

    public NewTestScenarioController() {    }


    public NewTestScenarioController(NewTestScenarioModel model, NewTestScenarioView view){
        this.model = model;
        this.view = view;
    }

    @FXML
    public void addTest(ActionEvent actionEvent) {

    }

    public void launch(String[] args) {
        Application.launch(NewTestScenarioView.class, args);
    }

    public void getTableInfo() {
        model.getData();
    }

    public void addTest() {

    }

    public void setTableView() {

    }

    public I_View execute(){
        return new NewTestScenarioView();
    }
}
