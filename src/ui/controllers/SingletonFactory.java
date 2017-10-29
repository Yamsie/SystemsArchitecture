package ui.controllers;

public class SingletonFactory {

    private static volatile FactoryController instance = null;

    public static FactoryController getFactoryInstance(){
        if(instance == null){
            return instance = new FactoryController();
        }
        else {
            return instance;
        }
    }
}
