package bll.models.logger;

public class TestingStatementInterceptor implements Interceptor{
    Boolean statement = false;
    @Override
    public void before(Action action) {
        boolean temp = checkTestingResult(action.getTestingStatement());
        if(temp)
            statement = true;
        else
            statement = false;
        System.out.println("before : Testing Statement Interceptor");
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
            System.out.println("This testing have valued result!");
        }
        else{
            System.out.println("This testing don't have valued result!");
        }
    }

    public boolean checkTestingResult(String result){
        if(result == "Succeed" || result == "Failed")
            return true;
        else
            return false;
    }
}