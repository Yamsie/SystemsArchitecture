package bll.models.logger;

public class TestingAction implements Action {
    String date = null;
    String databaseTestingLine = null;
    String testingStatement = null;

    @Override
    public String execute() {
        return date + databaseTestingLine + "," + testingStatement;
    }

    public String getDate() {
        return date;
    }

    public String getDatabaseTestingLine() {
        return databaseTestingLine;
    }

    public String getTestingStatement() {
        return testingStatement;
    }

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