/*package bll.models.logger;

import bll.models.Settings;

public class test {
    public static void test(){
        LoggerOperator operator = new LoggerOperator(Settings.getInstance().getProperty("LOG_FILE"));
        I_Interceptor dateInterceptor = new DateInterceptor();
        I_Interceptor databaseInterceptor = new DatabaseTestingLineInterceptor();
        I_Interceptor statementInterceptor = new TestingStatementInterceptor();
        InterceptorDispatcher actionInvocation = new InterceptorDispatcher();
        actionInvocation.addInterceptor(dateInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(statementInterceptor);
        I_Action action = new TestingAction();
        action.setDatabaseTestingLine("Testing elements information here"); //String here, for set testing line
        action.setTestingStatement("Succeed"); // String here, statement Succeed or Failed
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        operator.addData(result + "\n");
        System.out.println("I_Action result:" + result);
    }
}*/