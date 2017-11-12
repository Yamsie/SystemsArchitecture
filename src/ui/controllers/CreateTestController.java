package ui.controllers;

import bll.*;
import bll.models.*;
import bll.parser.MyElement;
import bll.parser.MyJSONParser;
import bll.parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML private ChoiceBox<String> loadDropDown;
    private XMLParser xmlParser = new XMLParser();
    private TestModel model;

    private ObservableList<MyElement> elementList, testList;
    private ArrayList<TableColumn<MyElement, String>> elementColumns = new ArrayList<>();
    private ArrayList<TableColumn<MyElement, String>> testColumns = new ArrayList<>();
    private Caretaker caretaker = new Caretaker();


    public CreateTestController() {
        elementList = FXCollections.observableArrayList();
        testList = FXCollections.observableArrayList();
        DataOriginator originator = new DataOriginator();
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
    private void createTest()
    {
        String name = testName.getText().equals("") ? "Default" : testName.getText();
        if(testList.size() > 0)
        {
            if(model.checkUniqueName(name))
            {
                testName.clear();
                new XMLTestCreator().createTest(name.replaceAll(" ", ""), testList);
                nameMessage.setText("Test has been saved.");
                model.insertOperation(name, Settings.getInstance().getProperty("XML_TEST_PATH") + name + ".xml");
            }

            else {
                testName.clear();
                nameMessage.setText("A test with this name already exists. Please choose a different name");
            }
        }
    }

    @FXML
    public void loadTest() {
        if(loadDropDown.getValue().equals("Load Test"))
            testList.clear();
        else {
            testList.clear();
            testList.addAll(xmlParser.parse(Settings.getInstance().getProperty("XML_TEST_PATH") + loadDropDown.getValue()));
            testTable.setItems(testList);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        MyJSONParser jsonParser = new MyJSONParser();
        loadDropDown.getItems().removeAll(loadDropDown.getItems());
        loadDropDown.getItems().add("Load Test");
        loadDropDown.getSelectionModel().select("Load Test");

        for(File f: getFiles(Settings.getInstance().getProperty("XML_TEST_PATH")))
            loadDropDown.getItems().add(f.getName());

        for (String COLUMN_ATTRIBUTE : TestModel.getAttributes())
        {
            TableColumn<MyElement, String> eCol = new TableColumn<>(COLUMN_ATTRIBUTE.toUpperCase());
            TableColumn<MyElement, String> tCol = new TableColumn<>(COLUMN_ATTRIBUTE.toUpperCase());
            eCol.setCellValueFactory(new PropertyValueFactory<>(COLUMN_ATTRIBUTE));
            tCol.setCellValueFactory(new PropertyValueFactory<>(COLUMN_ATTRIBUTE));
            elementColumns.add(eCol);
            testColumns.add(tCol);
        }

        for(File f: getFiles(Settings.getInstance().getProperty("XML_PATH")))
            elementList.addAll(xmlParser.parse(Settings.getInstance().getProperty("XML_PATH") + f.getName()));

        for(File f: getFiles(Settings.getInstance().getProperty("JSON_PATH")))
            elementList.addAll(jsonParser.parse(Settings.getInstance().getProperty("JSON_PATH") + f.getName()));

        elementTable.setItems(elementList);
        testTable.setItems(testList);

        for(int i = 0; i < TestModel.getAttributes().length; i++)
        {
            if(i < 5) elementTable.getColumns().add(elementColumns.get(i));
            testTable.getColumns().add(testColumns.get(i));
            testColumns.get(i).setSortable(false);
        }
        addListeners();
        editCells();
    }

    private void editCells() {
        testTable.setEditable(true);
        for(int i = 0; i < TestModel.getAttributes().length; i++)
            testColumns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
        testColumns.get(0).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setPageURL(e.getNewValue()));
        testColumns.get(1).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementType(e.getNewValue()));
        testColumns.get(2).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementID(e.getNewValue()));
        testColumns.get(3).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementName(e.getNewValue()));
        testColumns.get(4).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementClass(e.getNewValue()));
        testColumns.get(5).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setElementXPath(e.getNewValue()));
        testColumns.get(6).setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setInput(e.getNewValue()));
    }

    @FXML
    private void restore() {
        if(caretaker.getMementoStackSize() != 0) {
            caretaker.undoOperation();
            if(caretaker.getMementoStackSize() != 0) {
                testList = updateTestList(caretaker.getDataValue());
                testTable.setItems(testList);
            }
            else {
                testList.remove(0,testList.size());
                testTable.setItems(testList);
            }
        }
        else {
            testList.remove(0,testList.size());
            testTable.setItems(testList);
        }
    }

    private ObservableList<MyElement> updateTestList(ArrayList<MyElement> undoOperation)
    {
        ObservableList<MyElement> temp = FXCollections.observableArrayList();
        if(undoOperation.size()!=0){
            temp.addAll(undoOperation);
        }
        return temp;
    }

    private ArrayList<MyElement> translateIntoArrayList(ObservableList<MyElement> testList){
        ArrayList<MyElement> temp = new ArrayList<>();
        temp.addAll(testList);
        return temp;
    }

    private void addListeners() {
        elementTable.setOnMousePressed(e -> {
            if(e.getClickCount() == 2)
            {
                try {
                    MyElement clone = elementList.get(elementTable.getFocusModel().getFocusedCell().getRow()).clone();
                    testList.add(clone);
                    testTable.setItems(testList);
                    caretaker.setOriginatorValue(translateIntoArrayList(testList));
                }
                catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }});

        testTable.setOnMousePressed(event ->
        {
            if(event.getClickCount() == 2)
                testTable.getItems().remove(testTable.getFocusModel().getFocusedCell().getRow());
        });

        addElement.setOnMousePressed(event ->
        {
            testTable.getItems().add(new MyElement());
            testTable.setItems(testList);
        });
    }

    @Override
    public void changeScene(Stage st)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateTestView.fxml"));
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
        I_Controller c = SingletonFactory.getFactoryInstance().getController("MainMenuController");
        c.changeScene((Stage) mainMenuBtn.getScene().getWindow());
    }
}