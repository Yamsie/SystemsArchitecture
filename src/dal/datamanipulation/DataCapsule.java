package dal.datamanipulation;

import java.util.ArrayList;
import java.util.List;

public class DataCapsule {

    private List<String> data;
    private String[] columns;

    public DataCapsule(List<String> data, String[] columns) {
        this.data = new ArrayList<>(data);
        this.columns = columns;
    }

    public void setData(List<String> data) {
        this.data = new ArrayList<>(data);
    }

    public List<String> getData() {
        return data;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[] getColumns() {
        return columns;
    }
}
