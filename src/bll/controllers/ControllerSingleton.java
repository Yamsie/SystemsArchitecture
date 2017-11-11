package bll.controllers;

import bll.controllers.TestController;

public class ControllerSingleton {

    private static volatile TestController instance = null;

    public static TestController getInstance(){
        if(instance == null){
            return instance = new TestController();
        }
        else {
            return instance;
        }
    }
}
