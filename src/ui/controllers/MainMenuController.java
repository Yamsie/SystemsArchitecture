package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import ui.views.ConcreteViewCreator;
import ui.views.I_View;

public class MainMenuController {

    @FXML
    private Button exitApplication;


    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        exitApplication.setText("Button Pressed");
    }

    @FXML
    protected void handleButtonAction(ActionEvent event) throws Exception {
        ConcreteViewCreator vc = new ConcreteViewCreator();
        I_View x = vc.createView("newTestScenario");
        x.runView(exitApplication.getScene());
    }
}
