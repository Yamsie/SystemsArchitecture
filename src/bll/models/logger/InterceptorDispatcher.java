package bll.models.logger;

import java.util.ArrayList;
import java.util.List;
// In this Dispatcher will use priority callback strategies

public class InterceptorDispatcher{

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

    public void removeInterceptor(int i){
        this.interceptors.remove(i);
    }

    public String invoke() {

        // TODO Auto-generated method stub
        String result = "";
        int maxPriority;
        while(interceptors.size()!=0){                                   // Always invoke the interceptor who has max priority
            maxPriority = getMaxPriority();                              // Get the max priority in the List
            for(int i = 0; i < interceptors.size(); ++i){                //Callback the interceptor who has max priority
                if(maxPriority == this.interceptors.get(i).getPriority()){
                    interceptors.get(i).operation(this.action);
                    interceptors.get(i).checkOperation(this.action);
                    removeInterceptor(i);
                }
            }
        }
        result = action.execute();
        return result;
    }

    public int getMaxPriority(){
        int maxPriority = -1;
        for(int i = 0; i < this.interceptors.size(); ++i){
            if(this.interceptors.get(i).getPriority() >= maxPriority){
                maxPriority = this.interceptors.get(i).getPriority();
            }
        }
        return maxPriority;
    }
}
