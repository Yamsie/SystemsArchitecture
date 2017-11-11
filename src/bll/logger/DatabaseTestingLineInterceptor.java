package bll.logger;

public class DatabaseTestingLineInterceptor implements I_Interceptor {
    boolean statement = false;
    int priority = 2;

    @Override
    public void operation(I_Action action) {
        checkDatabaseTestingLineInterceptor(action.getDatabaseTestingLine());
    }

    @Override
    public void checkOperation(I_Action action) {
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