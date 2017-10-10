package ui.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewTestScenarioView implements I_View{

    public void NewTestScenario(){ }

    public void runView(Scene s){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testselection.fxml"));
            s.setRoot(root);
        }
        catch(IOException ex){
            System.out.println("Error - IO exception");
        }
    }
}
