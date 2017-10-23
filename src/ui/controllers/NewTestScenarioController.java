package ui.controllers;


import bll.models.NewTestScenarioModel;
import bll.models.TestCase;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.views.FactoryViewCreator;
import ui.views.I_View;
import ui.views.NewTestScenarioView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class NewTestScenarioController implements Command, Initializable {



    @FXML private Button addTestInput;
    @FXML private TextArea textArea;

    private NewTestScenarioModel model;
    private NewTestScenarioView view;
    private ObservableList<TestCase> data;

    public NewTestScenarioController() {
        model = new NewTestScenarioModel();
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder sb = new StringBuilder();

        model.setData();
        List<List<String>> data = model.getData();

        for (int i = 0; i < data.get(i).size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                sb.append(data.get(j).get(i));

                try {
                    if (data.get(j + 1).get(i) != null) {
                        sb.append(",");
                    }
                }
                catch (IndexOutOfBoundsException ex) {
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
