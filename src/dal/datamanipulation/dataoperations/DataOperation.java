package dal.datamanipulation.dataoperations;

import dal.datamanipulation.DataCapsule;

import javax.xml.crypto.Data;
import java.util.List;

public class DataOperation implements I_Visitable {

    private DataCapsule whereData;
    private DataCapsule rawData;
    private boolean readOnly = false;

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public void setWhereData(DataCapsule dataCapsule) {
        this.whereData = dataCapsule;
    }

    public DataCapsule getWhereData() {
        return whereData;
    }

    public void setRawData(DataCapsule dataCapsule) {
        this.rawData = dataCapsule;
    }

    public DataCapsule getRawData() {
        return rawData;
    }

    public void accept(I_Visitor visitor){ }
}
