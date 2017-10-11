package dal.datamanipulation.dataoperations;

import java.util.ArrayList;
import java.util.List;

public class SelectOperation extends DataOperation implements I_Visitable{

    private String column;

    public SelectOperation(String column) {
        this.column = column;
    }

    public List<String> doSelect() {
        List<String> newData = new ArrayList<>();
        int columnIndex;

        for (columnIndex = 0; columnIndex < super.getDataCapsule().getColumns().length; columnIndex++) {
            if (column.equals(super.getDataCapsule().getColumns()[columnIndex])) { // Locates column index in "table" for column in clause
                break;
            }
        }

        for (int index = 0; index < super.getDataCapsule().getData().size(); index++) {
            newData.add(super.getDataCapsule().getData().get(index).split(",")[columnIndex]);
        }

        return newData;
    }

    public List<String> accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
