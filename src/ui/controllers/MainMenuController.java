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

    FactoryController fc;

    @FXML
    private Button exitApplication;

    public MainMenuController() {
        fc = SingletonFactory.getInstance();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainmenu.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        exitApplication.setText("Button Pressed");
    }

    @FXML
    protected void handleViewTestsButtonAction(ActionEvent event) throws Exception {

    }

    @FXML
    protected void handleTestWebPage(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testselection.fxml"));
            Scene scene = new Scene(root);
            Stage st = (Stage) exitApplication.getScene().getWindow();
            st.setTitle("Test Selection");
            st.setScene(scene);
            st.show();
        }
        catch(Exception ex){
            System.out.println("blahhh");
        }
    }

    @FXML
    protected void handleNewTestScenario(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/newtestscenario.fxml"));
            Scene scene = new Scene(root);
            Stage st = (Stage) exitApplication.getScene().getWindow();
            st.setTitle("New Test Scenario");
            st.setScene(scene);
            st.show();
        }
        catch(Exception ex){
            System.out.println("blahhh");
        }
    }
}
