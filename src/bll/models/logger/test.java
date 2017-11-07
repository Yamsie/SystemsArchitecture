package bll.models.logger;


public class test {
    public static void test(){
        LoggerOperator operator = new LoggerOperator("src/bll/models/logger/log.txt");
        I_Interceptor dateInterceptor = new DateInterceptor();
        I_Interceptor databaseInterceptor = new DatabaseTestingLineInterceptor();
        I_Interceptor statementInterceptor = new TestingStatementInterceptor();
        InterceptorDispatcher actionInvocation = new InterceptorDispatcher();
        actionInvocation.addInterceptor(dateInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(statementInterceptor);
        I_Action action = new TestingAction();
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        operator.addData(result + "\n");
        System.out.println("I_Action result:" + result);
    }
}