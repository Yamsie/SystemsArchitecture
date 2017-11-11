package bll.models.logger;

import bll.models.Settings;
import bll.models.TestCase;

public class TestController {

    private LoggerOperator operator;
    private I_Interceptor dateInterceptor;
    private I_Interceptor databaseInterceptor;
    private I_Interceptor statementInterceptor;
    private InterceptorDispatcher actionInvocation;
    private I_Action action;

    public TestController() {
        operator = new LoggerOperator("rec/logger/text");
        dateInterceptor = new DateInterceptor();
        databaseInterceptor = new DatabaseTestingLineInterceptor();
        statementInterceptor = new TestingStatementInterceptor();
        actionInvocation = new InterceptorDispatcher();
        action = new TestingAction();
        actionInvocation.addInterceptor(dateInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(statementInterceptor);
    }

    public void run(TestCase tc){
        String logMessage = tc.runTest();
        action.setDatabaseTestingLine("test name is " + tc.getName()); //String here, for set testing line
        action.setTestingStatement(logMessage);
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        System.out.println("result is : " + result);
        operator.addData(result); // was adding to an array list and writing arraylist to file instead of writing string directly to file
    }
}