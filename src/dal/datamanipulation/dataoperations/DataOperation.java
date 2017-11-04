package dal.datamanipulation.dataoperations;

import dal.datamanipulation.DataCapsule;

import java.util.List;

public class DataOperation implements I_Visitable {

    private DataCapsule dataCapsule;
    private boolean readOnly = false;

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public void setDataCapsule(DataCapsule dataCapsule) {
        this.dataCapsule = dataCapsule;
    }

    public DataCapsule getDataCapsule() {
        return dataCapsule;
    }

    public List<String> accept(I_Visitor visitor) {
        return null;
    }
}
