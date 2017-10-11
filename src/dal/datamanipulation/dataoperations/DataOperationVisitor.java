package dal.datamanipulation.dataoperations;

import java.util.List;

public class DataOperationVisitor implements Visitor {

    public List<String> visit(SelectOperation select) {
        return select.doSelect();
    }

    public List<String> visit(DeleteOperation select) {
        return null;
    }

    public List<String> visit(InsertOperation select) {
        return null;
    }

    public List<String> visit(UpdateOperation select) {
        return null;
    }
}
