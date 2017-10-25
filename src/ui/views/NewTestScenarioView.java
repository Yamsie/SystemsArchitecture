package ui.views;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class NewTestScenarioView extends Application implements I_View {

    @FXML private TableView tableView;
    @FXML private TableColumn idColumn;
    @FXML private TableColumn urlColumn;
    @FXML private TableColumn elementColumn;
    @FXML private TableColumn inputColumn;

    public NewTestScenarioView(){ }

    public void runView(Stage st){
        /*try {
            Parent root = FXMLLoader.load(getClass().getResource("/testselection.fxml"));
            //Scene s = new Scene(root);
            st.setScene(new Scene(root));
            st.show();
            }
        catch(IOException ex){
            System.out.println("Error - IO exception");
        }*/
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