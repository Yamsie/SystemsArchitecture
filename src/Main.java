import bll.models.NewTestScenarioModel;
import javafx.application.Application;
import ui.controllers.NewTestScenarioController;
import ui.views.ConcreteViewCreator;
import ui.views.I_View;
import ui.views.MainMenuView;
import ui.views.NewTestScenarioView;

public class Main {
    public static void main(String[] args) {
        //Application.launch(MainMenuView.class, args);
        //ConcreteViewCreator vc = new ConcreteViewCreator();
        //I_View view = vc.createView("MainWindowView");
        //view.runView(this.getScene());
        NewTestScenarioModel model = new NewTestScenarioModel();
        NewTestScenarioView view = new NewTestScenarioView();
        NewTestScenarioController controller = new NewTestScenarioController(model, view);
        controller.launch(args);
    }
}
