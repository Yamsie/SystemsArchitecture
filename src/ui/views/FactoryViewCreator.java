package ui.views;

import ui.controllers.Command;
import ui.controllers.NewTestScenarioController;
import ui.controllers.TestWebPageController;

import java.util.ArrayList;

public class FactoryViewCreator {

    private ArrayList<Command> handlers;

    public FactoryViewCreator(){
        this.handlers = setHandlers();
    }

    public I_View createView(String name) {
        Command c = getController(name);
        I_View view = c.execute();
        return view;
    }

    public ArrayList setHandlers(){
        ArrayList h = new ArrayList<Command>();
        h.add(new TestWebPageController());
        h.add(new NewTestScenarioController());
        return h;
    }

    public Command getController(String n){
        Command c = null;
        for(int i = 0; i < handlers.size(); i++) {
            if (handlers.get(i).equals(n))
                c = handlers.get(i);
        }
        return c;
    }
}
