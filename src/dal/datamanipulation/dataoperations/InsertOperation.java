package dal.datamanipulation.dataoperations;

import java.util.List;

public class InsertOperation extends DataOperation implements I_Visitable {
    @Override
    public List<String> accept(Visitor visitor) {
        return visitor.visit(this);
    }
}