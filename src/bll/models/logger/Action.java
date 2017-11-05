package bll.models.logger;

/**
 * @author Lenovo
 * @version $Id Action.java, v 0.1 2017-10-10 21:13 Lenovo Exp $$
 */
public interface Action {         //Interface Of Context Object
    String execute();
    String getDate();
    String getDatabaseTestingLine();
    String getTestingStatement();
    void setDate(String date);
    void setDatabaseTestingLine(String databaseTestingLine);
    void setTestingStatement(String testingStatement);
}