import bll.models.Settings;
import javafx.application.Application;
import ui.controllers.MainMenuController;

public class Main {
    public static void main(String[] args) {
        Settings.getInstance();
        Application.launch(MainMenuController.class, args);
    }
}