package ui.controllers;


import bll.models.NewTestScenarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ui.views.NewTestScenarioView;

public class NewTestScenarioController {

    @FXML
    Button addTestInput;

    @FXML
    TableView tableView;

    NewTestScenarioModel model;
    NewTestScenarioView view;


    public NewTestScenarioController(NewTestScenarioModel model, NewTestScenarioView view){
        this.model = model;
        this.view = view;
    }

    @FXML
    public void addTest(ActionEvent actionEvent) {

    }

    public void getTableInfo() {
        model.getData();
    }
}
