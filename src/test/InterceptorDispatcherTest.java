package test;
import bll.logger.*;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;
//JUnit testing for logger
public class InterceptorDispatcherTest {
    private I_Interceptor dateInterceptor = new DateInterceptor();
    private I_Interceptor databaseInterceptor = new DatabaseTestingLineInterceptor();
    private I_Interceptor statementInterceptor = new TestingStatementInterceptor();
    private InterceptorDispatcher actionInvocation = new InterceptorDispatcher();

    @Test
    public void TestInvoke(){
        actionInvocation.addInterceptor(statementInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(dateInterceptor);
        I_Action action = new TestingAction();
        action.setDate("yyyy-MM-dd,HH:mm:ss");
        action.setDatabaseTestingLine("JUnit_Testing_Line");
        action.setTestingStatement("JUnit_Result");
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        List order = actionInvocation.getInterceptorOperationOrder();
        int first_Interceptor = (Integer)order.get(0);
        int second_Interceptor = (Integer)order.get(1);
        int third_Interceptor = (Integer)order.get(2);
        try {
            assertTrue("", first_Interceptor >= second_Interceptor && second_Interceptor >= third_Interceptor);
            System.out.println("I_Interceptor Dispatcher Test Pass [TestInvoke]!\nThe Dispatcher was successfully invoked interceptors by each priority!");
        }
        catch (AssertionError e) {
            System.out.println("I_Interceptor Dispatcher Test Fail [TestInvoke]!\nThe Dispatcher was not successfully invoked interceptors by each priority!");
            fail();
        }
        System.out.println();
    }

    @Test
    public void TestLoggerResultForm(){
        actionInvocation.addInterceptor(statementInterceptor);
        actionInvocation.addInterceptor(databaseInterceptor);
        actionInvocation.addInterceptor(dateInterceptor);
        I_Action action = new TestingAction();
        action.setDate("yyyy-MM-dd,HH:mm:ss");
        action.setDatabaseTestingLine("JUnit_Testing_Line");
        action.setTestingStatement("JUnit_Result");
        actionInvocation.setAction(action);
        String result = actionInvocation.invoke();
        String resultArray[] = result.split(",");

        boolean result_part1 = resultArray[0].equals("yyyy-MM-dd");
        boolean result_part2 = resultArray[1].equals("HH:mm:ss");
        boolean result_part3 = resultArray[2].equals("JUnit_Testing_Line");
        boolean result_part4 = resultArray[3].equals("JUnit_Result");

        try {
            assertTrue("", result_part1 && result_part2 && result_part3 && result_part4);
            System.out.println("I_Interceptor Dispatcher Test Pass [TestLoggerResultForm]!\nThe Logger was successfully created logger result form!");
        }
        catch (AssertionError e) {
            System.out.println("I_Interceptor Dispatcher Test Fail [TestLoggerResultForm]!\nThe Dispatcher was not successfully created logger result form!");
            fail();
        }
        System.out.println();
    }
}