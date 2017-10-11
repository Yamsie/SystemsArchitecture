package bll.models.logger;

public class DatabaseTestingLineInterceptor implements Interceptor{
    boolean statement = false;

    @Override
    public void before(Action action) {
        checkDatabaseTestingLineInterceptor(action.getDatabaseTestingLine());
        System.out.println("before : Checking Database Testing Line");
    }

    @Override
    public String intercept(ActionInvocation invocation, Action action) {
        before(action);
        String result = invocation.invoke();
        after(action);
        return result;
    }

    @Override
    public void after(Action action) {
        // TODO Auto-generated method stub
        if(statement == true){
            System.out.println("Checking Database Testing Line is existed!");
        }
        else{
            System.out.println("Checking Database Testing Line not existed!");
        }
    }

    public void checkDatabaseTestingLineInterceptor(String testingLine){
        //check Database Testing Line is exist
        statement = true;
    }
}