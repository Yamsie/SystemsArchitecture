import javafx.application.Application;
import ui.views.MainMenuView;

public class Main {
    public static void main(String[] args) {
        Application.launch(MainMenuView.class, args);
        /*FactoryViewCreator vc = new FactoryViewCreator();
        I_View view = vc.createView("MainWindowView");
        view.runView(this.getScene());*/
    }
}
