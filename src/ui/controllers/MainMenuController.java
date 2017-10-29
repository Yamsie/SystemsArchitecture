package ui.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
    protected void handleExit() {
        exitApplication.setText("Button Pressed");
    }

    @FXML
    protected void handleTestSelection(){
        IController c = fc.createController("TestSelectionController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleNewTestScenario(){
        IController c = fc.createController("NewTestScenarioController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleParsePage(){
        IController c = fc.createController("ParsePageController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    public FactoryController getFc() {
        return fc;
    }

    public void setFc(FactoryController fc) {
        this.fc = fc;
    }

}
