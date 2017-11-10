package bll.models;

import bll.models.logger.TestController;

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
