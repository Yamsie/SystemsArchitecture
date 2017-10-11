package dal.datamanipulation.dataoperations;

import dal.datamanipulation.DataCapsule;

import java.util.List;

public class DataOperation implements I_Visitable {

    private DataCapsule dataCapsule;

    public void setDataCapsule(DataCapsule dataCapsule) {
        this.dataCapsule = dataCapsule;
    }

    public DataCapsule getDataCapsule() {
        return dataCapsule;
    }

    public List<String> accept(Visitor visitor) {
        return null;
    }
}
