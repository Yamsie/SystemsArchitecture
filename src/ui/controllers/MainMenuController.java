package ui.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ui.views.FactoryViewCreator;
import ui.views.I_View;
import ui.views.NewTestScenarioView;
import ui.views.SingletonFactory;

public class MainMenuController extends Application{

    public MainMenuController() { }

    @FXML
    private Button exitApplication;

    public void start(Stage PrimaryStage){
        Parent root = FXMLLoader.load
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        exitApplication.setText("Button Pressed");
    }

    @FXML
    protected void handleViewTestsButtonAction(ActionEvent event) throws Exception {
        /*FactoryViewCreator vc = SingletonFactory.getInstance();
        I_View testView = vc.createView("newTestScenario");
        Stage st = (Stage) exitApplication.getScene().getWindow();
        //Scene s = exitApplication.getScene();
        testView.runView(st);*/
    }
}
