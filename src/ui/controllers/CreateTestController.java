package ui.controllers;

import bll.models.Caretaker;
import bll.models.DataOriginator;
import bll.models.TestModel;
import bll.models.XMLTestCreator;
import bll.models.parser.MyElement;
import bll.models.parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateTestController implements Initializable, I_Controller {

    @FXML private Button addElement;
    @FXML private TextField testName;
    @FXML private TableView<MyElement> elementTable, testTable;
    @FXML private Label nameMessage;
    @FXML private Button mainMenuBtn;
    private static final String XML_PATH = "src/xml/pages/";
    private static final String XML_TEST_PATH = "src/xml/tests/";
    private static final String [] COLUMN_ATTRIBUTES = {"pageURL", "elementType", "elementID", "elementName", "elementClass", "elementXPath", "input"};
    private ObservableList<MyElement> elementList, testList;
    private ArrayList<TableColumn<MyElement, String>> elementColumns = new ArrayList<>();
    private ArrayList<TableColumn<MyElement, String>> testColumns = new ArrayList<>();
    private Caretaker caretaker = new Caretaker();
    private DataOriginator originator = new DataOriginator();
    private TestModel model;

    public CreateTestController() {
        elementList = FXCollections.observableArrayList();
        testList = FXCollections.observableArrayList();
        caretaker.setDataOriginator(originator);
        model = new TestModel();
    }

    public String getName() {
        return "CreateTestController";
    }

    public void clearTable() {
        testList.remove(0,testList.size());
        testTable.setItems(testList);
        caretaker.setOriginatorValue(translateIntoArrayList(testList));
    }

    private File [] getFiles(String path) {
        return new File(path).listFiles();
    }

    @FXML
    private void createTest() {
        if(testList.size() > 0) {
            String name = testName.getText();
            boolean unique = model.checkUniqueName(name);
            if(unique == true) {
                testName.clear(); //clear
                new XMLTestCreator().createTest(name.equals("") ? "Default" : name, testList);
                nameMessage.setText("Test has been saved.");
                model.insertOperation(name, XML_TEST_PATH + name + ".xml");
            }
            else {
                testName.clear();
                nameMessage.setText("A test with this name already exists. Please choose a different name");
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (String COLUMN_ATTRIBUTE : COLUMN_ATTRIBUTES) {
            TableColumn<MyElement, String> eCol = new TableColumn<>(COLUMN_ATTRIBUTE.toUpperCase());
            TableColumn<MyElement, String> tCol = new TableColumn<>(COLUMN_ATTRIBUTE.toUpperCase());
            eCol.setCellValueFactory(new PropertyValueFactory<>(COLUMN_ATTRIBUTE));
            tCol.setCellValueFactory(new PropertyValueFactory<>(COLUMN_ATTRIBUTE));
            elementColumns.add(eCol);
            testColumns.add(tCol);
        }

        for(File f: getFiles(XML_PATH))
            elementList.addAll(new XMLParser().parse(XML_PATH + f.getName()));

        elementTable.setItems(elementList);
        testTable.setItems(testList);

        for(int i = 0; i < COLUMN_ATTRIBUTES.length; i++) {
            if(i < 5) elementTable.getColumns().add(elementColumns.get(i));
            testTable.getColumns().add(testColumns.get(i));
            testColumns.get(i).setSortable(false);
        }
        addListeners();
        editCells();
    }

    private void editCells() {
        testTable.setEditable(true);
        for(int i = 1; i < COLUMN_ATTRIBUTES.length; i++)
            testColumns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
        testColumns.get(1).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementType(e.getNewValue()));
        testColumns.get(2).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementID(e.getNewValue()));
        testColumns.get(3).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementName(e.getNewValue()));
        testColumns.get(4).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementClass(e.getNewValue()));
        testColumns.get(5).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementXPath(e.getNewValue()));
        testColumns.get(6).setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setInput(e.getNewValue()));
    }

    @FXML
    private void restore() {
        try {
            if(caretaker.getMementoStackSize() != 0){
                caretaker.undoOperation();
                if(caretaker.getMementoStackSize() != 0){
                    testList = updateTestList(caretaker.getDataValue());
                    testTable.setItems(testList);
                }
                else{
                    testList.remove(0,testList.size());
                    testTable.setItems(testList);
                }
            }
            else {
                testList.remove(0,testList.size());
                testTable.setItems(testList);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<MyElement> updateTestList(ArrayList<MyElement> undoOperation){
        ObservableList<MyElement> temp = FXCollections.observableArrayList();
        if(undoOperation.size()!=0){
            for(int i = 0; i < undoOperation.size(); ++i){
                temp.add(undoOperation.get(i));
            }
        }
        return temp;
    }

    public ArrayList<MyElement> translateIntoArrayList(ObservableList<MyElement> testList){
        ArrayList<MyElement> temp = new ArrayList<>();
        for(int i = 0; i < testList.size(); ++i){
            temp.add(testList.get(i));
        }
        return temp;
    }

    private void addListeners() {
        elementTable.setOnMousePressed(e -> {
            if(e.getClickCount() == 2) {
                try {
                    MyElement cloneObject = elementList.get(elementTable.getFocusModel().getFocusedCell().getRow()).clone();
                    testList.add(cloneObject);
                    testTable.setItems(testList);
                    caretaker.setOriginatorValue(translateIntoArrayList(testList));
                }
                catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }});

        testTable.setOnMousePressed(event -> {
            if(event.getClickCount() == 2)
                testTable.getItems().remove(testTable.getFocusModel().getFocusedCell().getRow());
        });

        addElement.setOnMousePressed(event -> {
            testTable.getItems().add(new MyElement());
            testTable.setItems(testList);
        });
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

    public void mainMenuBtnHandler() {
        I_Controller c = SingletonFactory.getFactoryInstance().createController("MainMenuController");
        c.changeScene((Stage) mainMenuBtn.getScene().getWindow());
    }
}