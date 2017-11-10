package ui.controllers;

import bll.models.*;
import bll.models.parser.MyElement;
import bll.models.parser.MyJSONParser;
import bll.models.parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
                new XMLTestCreator().createTest(name, testList);
                nameMessage.setText("Test has been saved.");
                model.insertOperation(name, Settings.getInstance().getProperty("XML_TEST_PATH") + name + ".xml");
            }

            else {
                testName.clear();
                nameMessage.setText("A test with this name already exists. Please choose a different name");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        XMLParser xmlParser = new XMLParser();
        MyJSONParser jsonParser = new MyJSONParser();

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
        model.editCells(testTable, testColumns);
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
        I_Controller c = SingletonFactory.getFactoryInstance().createController("MainMenuController");
        c.changeScene((Stage) mainMenuBtn.getScene().getWindow());
    }
}