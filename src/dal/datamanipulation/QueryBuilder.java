package dal.datamanipulation;

import dal.DataManager;
import dal.I_TextFileTable;
import dal.datamanipulation.dataclauses.I_DataClause;
import dal.datamanipulation.dataoperations.DataOperation;

public class QueryBuilder implements I_QueryBuilder{

    private Query query;

    public QueryBuilder() {
        query = new Query();
    }

    public void setDataOperation(DataOperation dataOperation) {
        query.setDataOperation(dataOperation);
    }

    public void setTargetFile(DataManager target) {
        query.setTarget(target);
    }

    public void addClause(I_DataClause dataClause) {
        query.addClause(dataClause);
    }

    public Query getResult() {
        return query;
    }
}
