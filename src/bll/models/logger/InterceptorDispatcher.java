package bll.models.logger;

import java.util.ArrayList;
import java.util.List;

public class InterceptorDispatcher implements  ActionInvocation {

    int index = 0;

    private Action action;

    private List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void addInterceptor(Interceptor interceptors) {
        this.interceptors.add(interceptors);
    }

    @Override
    public String invoke() {
        // TODO Auto-generated method stub
        String result = "";
        if (index == interceptors.size()) {
            result = action.execute();
        } else {
            Interceptor interceptor = interceptors.get(index);
            index++;
            result = interceptor.intercept(this, action);
        }
        return result;
    }
}
