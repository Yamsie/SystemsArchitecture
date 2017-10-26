package ui.controllers;


import ui.controllers.FactoryController;

public class SingletonFactory {

    private static volatile FactoryController instance = null;

    public static FactoryController getInstance(){
        if(instance == null){
            return instance = new FactoryController();
        }
        else
            return instance;
    }
}
