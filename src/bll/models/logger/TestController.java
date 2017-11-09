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

    public TestController()
    {
        operator = new LoggerOperator(Settings.getInstance().getProperty("LOG_FILE"));
        dateInterceptor = new DateInterceptor();
        databaseInterceptor = new DatabaseTestingLineInterceptor();
        statementInterceptor = new TestingStatementInterceptor();
        actionInvocation = new InterceptorDispatcher();
        action = new TestingAction();
        InterceptorDispatcher actionInvocation = new InterceptorDispatcher();
        actionInvocation.addInterceptor(dateInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(statementInterceptor);
    }

    public void run(TestCase tc){
        String logMessage = tc.runTest();
        action.setDatabaseTestingLine("Test name " + tc.getName()); //String here, for set testing line
        action.setTestingStatement(logMessage);
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        operator.addData(result + "\n");
        //System.out.println(result);
    }
}