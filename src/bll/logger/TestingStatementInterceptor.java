package bll.logger;

public class TestingStatementInterceptor implements I_Interceptor {
    private boolean statement = false;
    private int priority = 1;

    @Override
    public void operation(I_Action action) {
        boolean temp = checkTestingResult(action.getTestingStatement());
        if(temp)
            statement = true;
        else
            statement = false;

    }


    @Override
    public void checkOperation(I_Action action) {
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