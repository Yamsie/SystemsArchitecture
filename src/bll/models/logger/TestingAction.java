package bll.models.logger;

public class TestingAction implements Action {      //Context Object
    String date = null;
    String databaseTestingLine = null;
    String testingStatement = null;

    @Override // Create the result of Interceptor and return the result to logger
    public String execute() {
        return date + "," + databaseTestingLine + "," + testingStatement;
    }

    public String getDate() {
        return date;
    }  //Get the Testing time

    public String getDatabaseTestingLine() {
        return databaseTestingLine;
    } //Get the Testing line

    public String getTestingStatement() {
        return testingStatement;
    } //Get the result of Testing

    public void setDate(String date) {
        this.date = date;
    }

    public void setDatabaseTestingLine(String databaseTestingLine) {
        this.databaseTestingLine = databaseTestingLine;
    }

    public void setTestingStatement(String testingStatement) {
        this.testingStatement = testingStatement;
    }
}