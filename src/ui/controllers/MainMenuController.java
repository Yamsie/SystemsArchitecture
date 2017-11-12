package ui.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends Application implements Initializable, I_Controller {

    @FXML
    private Button exitApplication;

    //private FactoryController fc;

    public MainMenuController() {
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenuView.fxml"));
            //right after this line the constructor is called again
            Scene scene = new Scene(root);
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    protected void handleExit() {   Platform.exit();    }

    @FXML
    protected void handleCreateTest(){
        I_Controller c = SingletonFactory.getFactoryInstance().getController("CreateTestController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleTestSelection(){
        I_Controller c = SingletonFactory.getFactoryInstance().getController("TestSelectionController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @FXML
    protected void handleParsePage(){
        I_Controller c = SingletonFactory.getFactoryInstance().getController("ParsePageController");
        c.changeScene((Stage) exitApplication.getScene().getWindow());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public String getName() {
        return "MainMenuController";
    }

    @Override
    public void changeScene(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenuView.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle(this.getName());
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
