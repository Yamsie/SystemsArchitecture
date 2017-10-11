package dal.datamanipulation.dataoperations;

import java.util.List;

public interface Visitor {

    List<String> visit(SelectOperation select);
    List<String> visit(DeleteOperation select);
    List<String> visit(InsertOperation select);
    List<String> visit(UpdateOperation select);

}
