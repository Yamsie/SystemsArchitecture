package dal.datamanipulation.dataoperations;

import java.util.List;

public interface I_Visitable {

    List<String> accept(Visitor visitor);

}
