package dal.datamanipulation.dataoperations;

import java.util.List;

public class UpdateOperation extends DataOperation implements I_Visitable {
    @Override
    public List<String> accept(I_Visitor visitor) {
        return visitor.visit(this);
    }
}
