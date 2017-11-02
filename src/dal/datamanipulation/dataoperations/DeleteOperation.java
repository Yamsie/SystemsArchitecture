package dal.datamanipulation.dataoperations;

import dal.datamanipulation.DataCapsule;

import java.util.ArrayList;
import java.util.List;

public class DeleteOperation extends DataOperation {

    public List<String> doDelete() {
        return super.getDataCapsule().getData();
    }

    public List<String> accept(I_Visitor visitor) {
        return visitor.visit(this);
    }
}
