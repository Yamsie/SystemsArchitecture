package dal.datamanipulation.dataclauses;

public class WhereClause implements I_DataClause {

    private String clauseString;
    private String column;
    private String value;

    public WhereClause(String column, String value) {
        this.column = column;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }
}
