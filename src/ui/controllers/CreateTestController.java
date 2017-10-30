package ui.controllers;

import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;


import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateTestController extends Application implements Initializable {


    @FXML private TableView<MyElement> elementTable;
    @FXML private TableColumn<Object, Object> page;
    @FXML private TableColumn<Object, Object> type;
    @FXML private TableColumn<Object, Object> id;
    @FXML private TableColumn<Object, Object> name;
    @FXML private TableColumn<Object, Object> className;
    @FXML private TableColumn<Object, Object> url;
    private XMLParser parser = new XMLParser();

    public CreateTestController() {

    }

    public String getName() {
        return "CreateTestController";
    }

    private void updateColumnValues() {
        page.setCellValueFactory(new PropertyValueFactory<>("pageURL"));
        type.setCellValueFactory(new PropertyValueFactory<>("elementType"));
        id.setCellValueFactory(new PropertyValueFactory<>("elementID"));
        name.setCellValueFactory(new PropertyValueFactory<>("elementName"));
        className.setCellValueFactory(new PropertyValueFactory<>("elementClass"));
        url.setCellValueFactory(new PropertyValueFactory<>("elementURL"));
        elementTable.setEditable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateColumnValues();
        ObservableList<MyElement> elementList = FXCollections.observableArrayList();
        for(File f: new File("src/xml/pages/").listFiles())
            elementList.addAll(parser.parse("src/xml/pages/"+f.getName()));
        elementTable.setItems(elementList);


        elementTable.setOnMousePressed(event -> {
            if(event.getClickCount() == 2) {
                System.out.println(elementList.get(elementTable.getFocusModel().getFocusedCell().getRow()).getElementType());
            }
        });
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/createtest.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Create Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
