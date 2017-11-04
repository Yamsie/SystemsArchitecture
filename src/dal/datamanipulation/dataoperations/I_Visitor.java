package dal.datamanipulation.dataoperations;

public interface I_Visitor {

    void visit(SelectOperation select);
    void visit(DeleteOperation select);
    void visit(InsertOperation select);
    void visit(UpdateOperation select);

}
