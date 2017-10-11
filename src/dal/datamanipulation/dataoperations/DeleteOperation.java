package dal.datamanipulation.dataoperations;

import java.util.List;

public class DeleteOperation extends DataOperation {

    public List<String> accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
