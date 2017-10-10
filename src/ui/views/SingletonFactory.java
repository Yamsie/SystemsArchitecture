package ui.views;


public class SingletonFactory {

    private static volatile FactoryViewCreator instance = null;

    public static FactoryViewCreator getInstance(){
        if(instance == null){
            return instance = new FactoryViewCreator();
        }
        else
            return instance;
    }
}
