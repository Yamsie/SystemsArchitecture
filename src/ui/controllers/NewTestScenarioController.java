package ui.controllers;


import bll.models.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

//import javax.xml.ws.RequestWrapper;
import java.net.URL;
import java.util.*;

public class NewTestScenarioController implements Command, Initializable {



    @FXML private Button addTestInput;
    @FXML private TextArea textArea;
    @FXML private TextField newItem;
    @FXML private Button addItemBtn;

    private NewTestScenarioModel model;
    private ObservableList<TestCase> data;
    private StringBuilder sb;
    private Stack<DataOriginator> originators;
    private Stack<I_Memento> mementos;
    private DataOriginator originator;

    public NewTestScenarioController() {
        model = new NewTestScenarioModel();
        sb = new StringBuilder();
        originators = new Stack<>();
        mementos = new Stack<>();
    }

    @FXML
    public void addTest(ActionEvent actionEvent) {

    }

    public void getTableInfo() {
        model.getData();
    }

    public void setTableView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

        originator = new DataOriginator(sb.toString());
        originators.push(originator);
        mementos.push(originator.createMemento());
        setTextAreaText();
    }

    public void addItemHandler(ActionEvent actionEvent) {
        sb.append(newItem.getText());
        sb.append("\n");
        originator = new DataOriginator(sb.toString());
        originators.push(originator);
        mementos.push(originator.createMemento());
        newItem.clear();
        setTextAreaText();
    }

    private void setTextAreaText() {
        textArea.setText(sb.toString());
    }

    public void undoAddItemHandler(ActionEvent actionEvent) {
        try {
            originator = originators.pop();
            originator.restore(mementos.pop());
            sb = new StringBuilder(originators.peek().getText());
        }
        catch(EmptyStackException e) {
            System.err.println("Stack is empty");
        }
        setTextAreaText();
    }
}
