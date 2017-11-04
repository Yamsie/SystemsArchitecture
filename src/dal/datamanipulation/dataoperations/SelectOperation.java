package dal.datamanipulation.dataoperations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectOperation extends DataOperation implements I_Visitable{

    private String[] columns;

    public SelectOperation(String...columns) {
            this.columns = columns;
            super.setReadOnly(true);
    }

    public void doSelect() {
        List<String> newData = new ArrayList<>();

        if(columns[0].equals("*")) {
            columns = super.getWhereData().getColumns().clone();
        }

        for(int i = 0; i < columns.length; i++) { // Iterates through each column passed in
            for (int columnIndex = 0; columnIndex < super.getWhereData().getColumns().length; columnIndex++) {
                if (columns[i].equals(super.getWhereData().getColumns()[columnIndex])) { // Locates column index in "table" for column(s) in statement
                    for (int index = 0; index < super.getWhereData().getData().size(); index++) {
                        try {
                            newData.set(index, newData.get(index) + "," + super.getWhereData().getData().get(index).split(",")[columnIndex]);//.concat("," + super.getDataCapsule().getData().get(index).split(",")[columnIndex]);
                        }
                        catch(IndexOutOfBoundsException e) {
                            newData.add(super.getWhereData().getData().get(index).split(",")[columnIndex]);
                        }
                    }
                }
            }
        }

        //for (int index = 0; index < super.getDataCapsule().getData().size(); index++) {
        //    newData.add(super.getDataCapsule().getData().get(index).split(",")[columnIndex]);
        //}

        super.getWhereData().setData(newData);
    }

    public void accept(I_Visitor visitor) {
        visitor.visit(this);
    }
}
