package dal.datamanipulation.dataoperations;

import java.util.List;

public class UpdateOperation extends DataOperation implements I_Visitable {

    public void accept(I_Visitor visitor) {
        visitor.visit(this);
    }
}
