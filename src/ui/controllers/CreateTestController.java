package ui.controllers;

import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateTestController implements Initializable, IController {

    private static final String XML_PATH = "src/xml/pages/";
    @FXML private TableView<MyElement> elementTable, testTable;
    @FXML private TableColumn<MyElement, String> page, type, id, name, className, elPageTest;
    @FXML private TableColumn<MyElement, String> elTypeTest, elIdTest, elNameTest, elClassTest, elXPath, elInput;
    @FXML private Button addElement;

    public CreateTestController() {

    }

    public String getName() {
        return "CreateTestController";
    }

    public void clearTable() {
        testTable.getItems().clear();
    }

    private void updateElementTable() {
        page.setCellValueFactory(new PropertyValueFactory<>("pageURL"));
        type.setCellValueFactory(new PropertyValueFactory<>("elementType"));
        id.setCellValueFactory(new PropertyValueFactory<>("elementID"));
        name.setCellValueFactory(new PropertyValueFactory<>("elementName"));
        className.setCellValueFactory(new PropertyValueFactory<>("elementClass"));
    }

    private void updateTestTable() {
        elPageTest.setCellValueFactory(new PropertyValueFactory<>("pageURL"));
        elTypeTest.setCellValueFactory(new PropertyValueFactory<>("elementType"));
        elIdTest.setCellValueFactory(new PropertyValueFactory<>("elementID"));
        elNameTest.setCellValueFactory(new PropertyValueFactory<>("elementName"));
        elClassTest.setCellValueFactory(new PropertyValueFactory<>("elementClass"));
        elXPath.setCellValueFactory(new PropertyValueFactory<>("elementXPath"));
        elInput.setCellValueFactory(new PropertyValueFactory<>("input"));
    }

    private void addListeners(ObservableList<MyElement> eList, ObservableList<MyElement> tList) {
        elementTable.setOnMousePressed(event -> {
            if(event.getClickCount() == 2) {
                testTable.getItems().add(new MyElement(eList.get(elementTable.getFocusModel().getFocusedCell().getRow())));
                testTable.setItems(tList);
            }});

        addElement.setOnMousePressed(event -> {
            testTable.getItems().add(new MyElement());
            testTable.setItems(tList);
        });
    }

    private void editCells() {
        testTable.setEditable(true);
        elTypeTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elTypeTest.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setElementType(event.getNewValue()));
        elIdTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elIdTest.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setElementID(event.getNewValue()));
        elNameTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elNameTest.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setElementName(event.getNewValue()));
        elClassTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elClassTest.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setElementClass(event.getNewValue()));
        elXPath.setCellFactory(TextFieldTableCell.forTableColumn());
        elXPath.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setElementXPath(event.getNewValue()));
        elInput.setCellFactory(TextFieldTableCell.forTableColumn());
        elInput.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setInput(event.getNewValue()));
    }

    private File [] getFiles(String path) {
        return new File(path).listFiles();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<MyElement> elementList, testList;
        elementList = FXCollections.observableArrayList();
        testList = FXCollections.observableArrayList();
        updateElementTable();
        updateTestTable();
        addListeners(elementList, testList);
        editCells();

        for(File f: getFiles(XML_PATH))
            elementList.addAll(new XMLParser().parse(XML_PATH+f.getName()));

        elementTable.setItems(elementList);
        testTable.setItems(testList);
    }

    @Override
    public void changeScene(Stage st)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/createtest.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("Create Test");
            st.setScene(scene);
            st.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}