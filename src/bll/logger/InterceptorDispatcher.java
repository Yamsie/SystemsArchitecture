package bll.logger;

import java.util.ArrayList;
import java.util.List;
// In this Dispatcher will use priority callback strategies

public class InterceptorDispatcher{

    private I_Action action;
    private List<I_Interceptor> interceptors;
    private List<Integer> interceptorOperationOrder;

    public I_Action getAction() {
        return action;
    }

    public void setAction(I_Action action) {
        this.action = action;
    }

    public void addInterceptor(I_Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    public void removeInterceptor(int i){
        this.interceptors.remove(i);
    }

    public InterceptorDispatcher(){
        interceptors = new ArrayList<>();
        interceptorOperationOrder = new ArrayList<>();
    }

    public List<I_Interceptor> getInterceptor(){ return this.interceptors; }

    public List<Integer> getInterceptorOperationOrder(){
        return interceptorOperationOrder;
    }
    public String getInterceptorPriorityList(){
        String priorityOrder = "";
        for(I_Interceptor i: interceptors){
            priorityOrder += i.getPriority() + " ";
        }
        return priorityOrder;
    }


    public String invoke() {
        // TODO Auto-generated method stub
        String result = "";
        int maxPriority;
        int j =0;
        System.out.println("interceptor size " + interceptors.size());
        while(this.interceptors.size()!=0){                                   // Always invoke the interceptor who has max priority
            System.out.println("while interceptors != 0");
            maxPriority = getMaxPriority();                              // Get the max priority in the List
            for(int i = 0; i < interceptors.size(); ++i){                //Callback the interceptor who has max priority
                System.out.println("interceptor dispatcher line 49 for loop " + i);
                if(maxPriority == this.interceptors.get(i).getPriority()){
                    System.out.println("into if statement " + i);
                    interceptors.get(i).operation(this.action);
                    interceptors.get(i).checkOperation(this.action);
                    interceptorOperationOrder.add(i);
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
