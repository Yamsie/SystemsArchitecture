package dal.datamanipulation.dataoperations;

import dal.datamanipulation.DataCapsule;

import java.util.ArrayList;
import java.util.List;

public class DeleteOperation extends DataOperation {

    public void doDelete() {

        for (int i  = 0; i < super.getWhereData().getData().size(); i++) {
            if (super.getRawData().getData().contains(super.getWhereData().getData().get(i))) {
                super.getRawData().getData().remove(super.getWhereData().getData().get(i));
            }
        }
    }

    public void accept(I_Visitor visitor) {
        visitor.visit(this);
    }
}
