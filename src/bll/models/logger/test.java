package bll.models.logger;


public class test {
    public static void test(){
        LoggerOperator operator = new LoggerOperator("src/bll/models/logger/log.txt");
        Interceptor dateInterceptor = new DateInterceptor();
        Interceptor databaseInterceptor = new DatabaseTestingLineInterceptor();
        Interceptor statementInterceptor = new TestingStatementInterceptor();
        InterceptorDispatcher actionInvocation = new InterceptorDispatcher();
        actionInvocation.addInterceptor(dateInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(statementInterceptor);
        Action action = new TestingAction();
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        operator.addData(result + "\n");
        System.out.println("Action result:" + result);
    }
}