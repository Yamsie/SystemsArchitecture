package ui.controllers;

import java.util.ArrayList;

public class FactoryController {

    private ArrayList<Command> handlers;

    public FactoryController(){
        this.handlers = setHandlers();
    }

    public Command createController(String name) {
        Command c = getController(name);
        return c;
    }

    public ArrayList setHandlers(){
        ArrayList h = new ArrayList<Command>();
        h.add(new TestWebPageController());
        h.add(new NewTestScenarioController());
        h.add(new TestSelectionController());
        h.add(new ParsePageController());
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
