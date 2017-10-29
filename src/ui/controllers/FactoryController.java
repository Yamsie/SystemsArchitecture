package ui.controllers;

import java.util.ArrayList;

public class FactoryController{

    private ArrayList<IController> handlers;

    public FactoryController(){
        this.handlers = setHandlers();
    }

    public IController createController(String name) {
        IController c = getController(name);
        return c;
    }

    public ArrayList setHandlers(){
        ArrayList h = new ArrayList<IController>();
        h.add(new TestWebPageController());
        h.add(new NewTestScenarioController());
        h.add(new TestSelectionController());
        h.add(new ParsePageController());
        return h;
    }

    public IController getController(String n){
        IController c = null;
        for(int i = 0; i < handlers.size() && c == null; i++) {
            if (handlers.get(i).getName().equals(n))
                c = handlers.get(i);
        }
        return c;
    }
}
