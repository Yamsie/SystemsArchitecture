import javafx.application.Application;
import ui.controllers.CreateTestController;
import ui.controllers.MainMenuController;

public class Main {
    public static void main(String[] args) {
       // Application.launch(MainMenuController.class, args);
        Application.launch(CreateTestController.class, args);
    }
}