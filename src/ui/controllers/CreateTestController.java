package ui.controllers;

import bll.models.XMLTestCreator;
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
import javafx.scene.control.TextField;
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
    @FXML private TableColumn<MyElement, String> page, type, id, name, className, elPageTest,
            elTypeTest, elIdTest, elNameTest, elClassTest, elXPath, elInput;
    @FXML private Button addElement;
    @FXML private TextField testName;

    public CreateTestController() {
    }

    public String getName() {
        return "CreateTestController";
    }

    private void setUp() {
        elTypeTest.setSortable(false);
        elIdTest.setSortable(false);
        elNameTest.setSortable(false);
        elClassTest.setSortable(false);
        elXPath.setSortable(false);
        elInput.setSortable(false);
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

        testTable.setOnMousePressed(event -> {
            if(event.getClickCount() == 2) {
                int num = testTable.getFocusModel().getFocusedCell().getRow();
                testTable.getItems().remove(num);
            }});
    }

    @FXML
    private void saveTest() {
        String name = testName.getText().equals("") ? "Default" : testName.getText().replaceAll(" ","");
        new XMLTestCreator().createTest(name, testTable.getItems());
        testName.clear();
    }

    private void editCells() {
        testTable.setEditable(true);
        elTypeTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elTypeTest.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementType(e.getNewValue()));
        elIdTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elIdTest.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementID(e.getNewValue()));
        elNameTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elNameTest.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementName(e.getNewValue()));
        elClassTest.setCellFactory(TextFieldTableCell.forTableColumn());
        elClassTest.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementClass(e.getNewValue()));
        elXPath.setCellFactory(TextFieldTableCell.forTableColumn());
        elXPath.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementXPath(e.getNewValue()));
        elInput.setCellFactory(TextFieldTableCell.forTableColumn());
        elInput.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setInput(e.getNewValue()));
    }

    private File [] getFiles(String path) {
        return new File(path).listFiles();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<MyElement> elementList = FXCollections.observableArrayList();
        ObservableList<MyElement> testList = FXCollections.observableArrayList();
        editCells();
        setUp();
        updateElementTable();
        updateTestTable();
        addListeners(elementList, testList);

        for(File f: getFiles(XML_PATH))
            elementList.addAll(new XMLParser().parse(XML_PATH + f.getName()));

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