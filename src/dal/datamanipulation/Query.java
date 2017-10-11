package dal.datamanipulation;

import dal.DataManager;
import dal.I_TextFileTable;
import dal.datamanipulation.dataclauses.I_DataClause;
import dal.datamanipulation.dataoperations.DataOperation;
import dal.datamanipulation.dataoperations.DataOperationVisitor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private DataOperation dataOperation;
    private DataManager target;
    private List<I_DataClause> dataClauses = new ArrayList<>();
    private List<String> data = new ArrayList<>();


    public void setDataOperation(DataOperation dataOperation) {
        this.dataOperation = dataOperation;
    }

    public void setTarget(DataManager target) {
        this.target = target;
    }

    public void addClause(I_DataClause dataClause) {
        dataClauses.add(dataClause);
    }

    private void doQuery() {
        doClauses();
        doDataOperation();
    }

    public List<String> getResult() {
        doQuery();
        return data;
    }

    private void doClauses() {
        List<String> newData = new ArrayList<>(target.getDataCapsule().getData());
        List<String> tempData = new ArrayList<>();
        int columnIndex;

        for (int dataClauseIndex = 0; dataClauseIndex < dataClauses.size(); dataClauseIndex++) {
            for (columnIndex = 0; columnIndex < target.getDataCapsule().getColumns().length; columnIndex++) {
                if (dataClauses.get(dataClauseIndex).getColumn().equals(target.getDataCapsule().getColumns()[columnIndex])) { // Locates column index in "table" for column in clause
                    break;
                }
            }

            for (int dataIndex = 0; dataIndex < newData.size(); dataIndex++) {
                if(newData.get(dataIndex).split(",")[columnIndex].equals(dataClauses.get(dataClauseIndex).getValue())) {//if this column and row equals value in where clause, add to new list
                    tempData.add(newData.get(dataIndex));
                }
            }
            newData = new ArrayList<>(tempData);
            tempData.clear();
        }

        data = new ArrayList<>(newData);
    }

    private void doDataOperation() {
        //List<String> newData = new ArrayList<>(target.getDataCapsule().getData());
        dataOperation.setDataCapsule(new DataCapsule(data, target.getDataCapsule().getColumns()));

        DataOperationVisitor visitor = new DataOperationVisitor();
        data = new ArrayList<>(dataOperation.accept(visitor));
    }

}
