package ui.views;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class NewTestScenarioView extends Application implements I_View{

    @FXML
    TableView tableView;

    public void NewTestScenario(){ }

    public void runView(Scene s){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/newtestscenario.fxml"));
            s.setRoot(root);
        }
        catch(IOException ex){
            System.out.println("Error - IO exception");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/newtestscenario.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setTableView(TableView<List<String>> tableView) {
        this.tableView = tableView;
    }
}
