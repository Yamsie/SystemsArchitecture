package dal.datamanipulation.dataoperations;

import java.util.List;

public class DataOperationVisitor implements I_Visitor {

    public List<String> visit(SelectOperation select) {
        return select.doSelect();
    }

    public List<String> visit(DeleteOperation delete) {
        return delete.doDelete();
    }

    public List<String> visit(InsertOperation insert) {
        return null;
    }

    public List<String> visit(UpdateOperation update) {
        return null;
    }
}
