package test;

import bll.models.logger.LoggerOperator;
import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class DatabaseOperationTest {
    LoggerOperator operator = new LoggerOperator("src/bll/models/logger/log.txt");

    @Test
    public void TestAddData(){
        String newData = "yyyy-MM-dd,HH:mm:ss,JUnit_Testing_Line,JUnit_Result";
        operator.addData(newData);
        String lastData = operator.getLastResult();
        try {
            assertTrue("New result are successfully written in txt logger file", lastData.equals(newData));
            System.out.println("Database Operation Test Pass [TestAddData]!\nThe Logger was successfully wrote result into txt file!");
        }
        catch (AssertionError e) {
            System.out.println("Database Operation Test Fail [TestAddData]!\nThe Logger was not successfully wrote result into txt file!");
            fail();
        }
        operator.deleteData(newData);
        System.out.println();
    }

}