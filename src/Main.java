import javafx.application.Application;
import ui.controllers.MainMenuController;

public class Main {
    public static void main(String[] args) {


        Application.launch(MainMenuController.class, args);

        //I_QueryBuilder queryBuilder = new QueryBuilder();
        //queryBuilder.setDataOperation(new SelectOperation("url"));
        //queryBuilder.setTargetFile(new TableTestCases());
        //queryBuilder.addClause(new WhereClause("id", "1"));
//
        //Query query = queryBuilder.getResult();
        //List<String> data = query.getResult();
        //
        //for (int i = 0; i < data.size(); i++) {
        //    System.out.println(data.get(i));
        //}

    }
}
