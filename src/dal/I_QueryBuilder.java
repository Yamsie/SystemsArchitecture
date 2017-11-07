package dal;

import dal.datamanipulation.dataclauses.I_DataClause;
import dal.datamanipulation.dataoperations.DataOperation;

public interface I_QueryBuilder {

    void setDataOperation(DataOperation dataOperation);

    void setTargetFile(DataManager target);

    void addClause(I_DataClause dataClause);

    void doQuery();

    Query getResult();
}
