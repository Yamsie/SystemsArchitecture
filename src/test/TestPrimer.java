package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit testing for logger
@RunWith(Suite.class)
@Suite.SuiteClasses({
        InterceptorDispatcherTest.class,
        DatabaseOperationTest.class
})
public class TestPrimer {
}