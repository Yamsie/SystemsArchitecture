package ui.controllers;

import bll.models.TestCase;
import bll.models.TestModel;
import bll.models.logger.TestController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelectionController implements Initializable, I_Controller {

    @FXML private ListView list;
    @FXML private Button mainMenuBtn;
    private String selected = "";
    private TestModel model;
    private TestController testController;


    public TestSelectionController () {
        model = new TestModel();
        testController = new TestController();
    }

    public void initialize(URL location, ResourceBundle resources) {
        String cols = "name";
        List<String> data = model.selectOperation(cols);
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
        String cols = "*", where1="name";
        List<String> data = model.selectWithWhereOperation(cols, where1, selected);
        testController.run(new TestCase(data));
    }

    public void setSelected(String s){ this.selected = s; }

    public String getName(){
        return "TestSelectionController";
    }

    public void changeScene(Stage st){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestSelectionView.fxml"));
            Scene scene = new Scene(root);
            st.setTitle(this.getName());
            st.setScene(scene);
            st.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void mainMenuBtnHandler() {
        I_Controller c = SingletonFactory.getFactoryInstance().createController("MainMenuController");
        c.changeScene((Stage) mainMenuBtn.getScene().getWindow());
    }
}

