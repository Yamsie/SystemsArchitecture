package dal.datamanipulation;

import dal.DataManager;
import dal.datamanipulation.dataclauses.I_DataClause;
import dal.datamanipulation.dataoperations.DataOperation;
import dal.datamanipulation.dataoperations.DataOperationVisitor;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private DataOperation dataOperation;
    private DataManager target;
    private List<I_DataClause> dataClauses = new ArrayList<>();
    private List<String> rawData = new ArrayList<>();
    private List<String> whereData = new ArrayList<>();


    public void setDataOperation(DataOperation dataOperation) {
        this.dataOperation = dataOperation;
    }

    public void setTarget(DataManager target) {
        this.target = target;
        rawData = new ArrayList<>(target.getDataCapsule().getData());
    }

    public void addClause(I_DataClause dataClause) {
        dataClauses.add(dataClause);
    }

    private void doQuery() {
        doClauses();
        doDataOperation();

        List<String> temp = new ArrayList<>(target.getDataCapsule().getData());

        if(!dataOperation.getReadOnly()) { // Here as a placeholder - can't figure out how to integrate deletion. Lots of refactoring expected after more consideration
            target.setDataCapsule(dataOperation.getRawData());
        }
    }

    public void compileQuery() {
        doQuery();
    }

    public List<String> getResult() {
        return dataOperation.getRawData().getData();
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

        whereData = new ArrayList<>(newData);
    }

    private void doDataOperation() {
        //List<String> newData = new ArrayList<>(target.getDataCapsule().getData());
        dataOperation.setWhereData(new DataCapsule(whereData, target.getDataCapsule().getColumns()));
        dataOperation.setRawData(new DataCapsule(rawData, target.getDataCapsule().getColumns()));
        DataOperationVisitor visitor = new DataOperationVisitor();
        dataOperation.accept(visitor);
    }
}
