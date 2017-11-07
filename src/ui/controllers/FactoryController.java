package ui.controllers;

import java.util.ArrayList;
import java.util.List;

public class FactoryController{

    private List<I_Controller> handlers;

    public FactoryController(){
        handlers = new ArrayList<>();
        setHandlers();
    }

    public I_Controller createController(String name) {
        I_Controller c = getController(name);
        return c;
    }

    public void setHandlers(){
        this.handlers.add(new NewTestScenarioController());
        this.handlers.add(new TestSelectionController());
        this.handlers.add(new ParsePageController());
        this.handlers.add(new CreateTestController());
    }

    public I_Controller getController(String n){
        I_Controller c = null;
        for(int i = 0; i < handlers.size() && c == null; i++) {
            if (handlers.get(i).getName().equals(n))
                c = handlers.get(i);
        }
        return c;
    }
}
