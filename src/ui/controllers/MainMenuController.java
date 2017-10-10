package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ui.views.FactoryViewCreator;
import ui.views.I_View;
import ui.views.SingletonFactory;

public class MainMenuController {

    @FXML
    private Button exitApplication;


    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        exitApplication.setText("Button Pressed");
    }

    @FXML
    protected void handleButtonAction(ActionEvent event) throws Exception {
        FactoryViewCreator vc = SingletonFactory.getInstance();
        I_View x = vc.createView("newTestScenario");
        x.runView(exitApplication.getScene());
    }
}
