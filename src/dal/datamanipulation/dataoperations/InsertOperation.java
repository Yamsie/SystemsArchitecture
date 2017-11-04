package dal.datamanipulation.dataoperations;

import java.util.ArrayList;
import java.util.List;

public class InsertOperation extends DataOperation implements I_Visitable {

    private String[] row;

    public InsertOperation(String...row) {
        this.row = row;
    }

    public void doInsert() {

        String newRow = "";
        for(int i = 0; i < row.length; i++) {
            newRow += row[i];
            if(i != (row.length - 1)) {
                newRow += ",";
            }
        }

        if(!getRawData().getData().contains(newRow) && newRow.split(",").length == super.getRawData().getColumns().length) { // Do not add row if it already exists
            super.getRawData().getData().add(newRow);
        }
    }

    public void accept(I_Visitor visitor) {
        visitor.visit(this);
    }
}
