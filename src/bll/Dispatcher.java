package bll;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private Dispatcher instance;
    private List<I_Interceptor> interceptorList;

    Dispatcher() {
        instance = this;
        interceptorList = new ArrayList<>();
    }

    public Dispatcher GetInstance() {
        return instance;
    }

    public void dispatch() {

    }

    public void register(I_Interceptor interceptor) {
        interceptorList.add(interceptor);

    }

    public void remove(I_Interceptor interceptor) {
        if(interceptorList.contains(interceptor)) {
            interceptorList.remove(interceptor);
        }
    }

    public void iterate_list() {

    }

}
