package dal.datamanipulation.dataoperations;

import java.util.ArrayList;
import java.util.List;

public class UpdateOperation extends DataOperation implements I_Visitable {

    private String[] columns;
    private String[] input;

    public UpdateOperation(String...columns) {
        List<String> tempColumns = new ArrayList<>();
        List<String> tempData = new ArrayList<>();

        try {
            for (int i = 0; i < columns.length; i = i + 2) {
                tempColumns.add(columns[i]);
                tempData.add(columns[i + 1]);
            }

            this.columns = tempColumns.toArray(new String[tempColumns.size()]);
            input = tempData.toArray(new String[tempData.size()]);
        }
        catch (NullPointerException e) {
            System.err.println("Update query failed: " + e);
        }
    }

    public void doUpdate() {
        List<String> newData = new ArrayList<>();

        for(int i = 0; i < columns.length; i++) {// Iterates through each column passed in
            for (int columnIndex = 0; columnIndex < super.getRawData().getColumns().length; columnIndex++) {
                if (columns[i].equals(super.getRawData().getColumns()[columnIndex])) { // Locates column index in "table" for column(s) in statement
                    for (int index = 0; index < super.getRawData().getData().size(); index++) {
                        for (int whereIndex = 0; whereIndex < super.getWhereData().getData().size(); whereIndex++) {
                            if (super.getRawData().getData().get(index).equals(super.getWhereData().getData().get(whereIndex))) {
                                String[] tempArray = super.getRawData().getData().get(index).split(",");
                                tempArray[columnIndex] = input[i];
                                String newLine = "";

                                for (int j = 0; j < tempArray.length; j++) {
                                    newLine += tempArray[j];
                                    if (j != tempArray.length - 1) {
                                        newLine += ",";
                                    }
                                }

                                super.getRawData().getData().set(index, newLine);
                                super.getWhereData().getData().set(whereIndex, newLine);
                            }
                        }
                    }
                }
            }
        }

    }

    public void accept(I_Visitor visitor) {
        visitor.visit(this);
    }
}
