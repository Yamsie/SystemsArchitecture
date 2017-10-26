package ui.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParsePageView extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/parsepage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Parse Page Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

