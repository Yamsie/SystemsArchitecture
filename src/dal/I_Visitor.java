package dal;

import dal.datamanipulation.dataoperations.DeleteOperation;
import dal.datamanipulation.dataoperations.InsertOperation;
import dal.datamanipulation.dataoperations.SelectOperation;
import dal.datamanipulation.dataoperations.UpdateOperation;

public interface I_Visitor {

    void visit(SelectOperation select);
    void visit(DeleteOperation select);
    void visit(InsertOperation select);
    void visit(UpdateOperation select);

}
