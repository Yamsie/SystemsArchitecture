package bll.models.logger;

public class DatabaseTestingLineInterceptor implements Interceptor{
    boolean statement = false;
    int priority = 2;

    @Override
    public void operation(Action action) {
        checkDatabaseTestingLineInterceptor(action.getDatabaseTestingLine());
        System.out.println("before : Checking Database Testing Line");
    }

    @Override
    public void checkOperation(Action action) {
        // TODO Auto-generated method stub
        if(statement == true){
            System.out.println("Checking Database Testing Line is existed!");
        }
        else{
            System.out.println("Checking Database Testing Line not existed!");
        }
    }

    @Override
    public int getPriority(){
        return this.priority;
    }

    public void checkDatabaseTestingLineInterceptor(String testingLine){
        //check Database Testing Line is exist
        statement = true;
    }
}