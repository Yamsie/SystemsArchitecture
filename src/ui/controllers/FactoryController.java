package ui.controllers;

import java.util.ArrayList;
import java.util.List;

public class FactoryController{

    private List<IController> handlers;

    public FactoryController(){
        handlers = new ArrayList<>();
        setHandlers();
    }

    public IController createController(String name) {
        IController c = getController(name);
        return c;
    }

    public void setHandlers(){
        this.handlers.add(new TestWebPageController());
        this.handlers.add(new NewTestScenarioController());
        this.handlers.add(new TestSelectionController());
        this.handlers.add(new ParsePageController());
        this.handlers.add(new CreateTestController());
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
