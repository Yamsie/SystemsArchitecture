package dal.datamanipulation.dataoperations;

import java.util.List;

public class DataOperationVisitor implements I_Visitor {

    public void visit(SelectOperation select) {
        select.doSelect();
    }

    public void visit(DeleteOperation delete) {
        delete.doDelete();
    }

    public void visit(InsertOperation insert) {
        insert.doInsert();
    }

    public void visit(UpdateOperation update) {

    }
}
