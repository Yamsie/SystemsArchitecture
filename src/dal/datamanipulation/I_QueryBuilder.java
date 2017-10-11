package dal.datamanipulation;

import dal.DataManager;
import dal.I_TextFileTable;
import dal.datamanipulation.dataclauses.I_DataClause;
import dal.datamanipulation.dataoperations.DataOperation;
import dal.datamanipulation.dataoperations.SelectOperation;

public interface I_QueryBuilder {

    void setDataOperation(DataOperation dataOperation);

    void setTargetFile(DataManager target);

    void addClause(I_DataClause dataClause);

    Query getResult();
}
