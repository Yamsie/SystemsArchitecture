package ui.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController extends Application{

    @FXML
    private Button exitApplication;

    private FactoryController fc;

    public MainMenuController() {
        this.fc = SingletonFactory.getFactoryInstance();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainmenu.fxml"));
        //right after this line the constructor is called again
        Scene scene = new Scene(root);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
        setFc(SingletonFactory.getFactoryInstance());
    }

    @FXML
    protected void handleExit() {   Platform.exit();    }

    @FXML
    protected void handleCreateTest(){
        I_Controller c = fc.createController("CreateTestController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleTestSelection(){
        I_Controller c = fc.createController("TestSelectionController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleNewTestScenario(){
        I_Controller c = fc.createController("NewTestScenarioController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleParsePage(){
        I_Controller c = fc.createController("ParsePageController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    public FactoryController getFc() {
        return fc;
    }

    public void setFc(FactoryController fc) {
        this.fc = fc;
    }

}
