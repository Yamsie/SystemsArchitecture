package bll.models.logger;

public class TestingStatementInterceptor implements Interceptor{
    Boolean statement = false;
    int priority = 1;

    @Override
    public void operation(Action action) {
        boolean temp = checkTestingResult(action.getTestingStatement());
        if(temp)
            statement = true;
        else
            statement = false;
        System.out.println("before : Testing Statement Interceptor");
    }


    @Override
    public void checkOperation(Action action) {
        // TODO Auto-generated method stub
        if(statement == true){
            System.out.println("This testing have valued result!");
        }
        else{
            System.out.println("This testing don't have valued result!");
        }
    }

    @Override
    public int getPriority(){
        return this.priority;
    }

    public boolean checkTestingResult(String result){
        if(result == "Succeed" || result == "Failed")
            return true;
        else
            return false;
    }
}