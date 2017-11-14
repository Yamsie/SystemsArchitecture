package dal.datamanipulation.dataoperations;

import dal.I_Visitor;

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
        update.doUpdate();
    }

}
