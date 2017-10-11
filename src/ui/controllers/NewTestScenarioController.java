package ui.controllers;


import bll.models.NewTestScenarioModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ui.views.I_View;
import ui.views.NewTestScenarioView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NewTestScenarioController {

    @FXML
    Button addTestInput;

    @FXML
    TableView tableView;

    NewTestScenarioModel model;
    NewTestScenarioView view;

    public NewTestScenarioController() {

    }


    public NewTestScenarioController(NewTestScenarioModel model, NewTestScenarioView view){
        this.model = model;
        this.view = view;
        setTableView();
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
        Path path = Paths.get("/data/TEST_CASES.txt");
        System.out.println();
        view.setTableView(model.readTabDelimitedFileIntoTable(path));
    }
}
