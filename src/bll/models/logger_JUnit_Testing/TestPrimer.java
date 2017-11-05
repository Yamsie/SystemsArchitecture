package bll.models.logger_JUnit_Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InterceptorDispatcherTest.class,
        DatabaseOperationTest.class
})
public class TestPrimer {
}