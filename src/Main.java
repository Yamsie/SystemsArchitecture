import bll.models.NewTestScenarioModel;
import bll.models.parser.WebParser;
import bll.models.parser.XMLParser;
import dal.TablePlaceHolder;
import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.DeleteOperation;
import dal.datamanipulation.dataoperations.InsertOperation;
import dal.datamanipulation.dataoperations.SelectOperation;
import dal.datamanipulation.dataoperations.UpdateOperation;
import javafx.application.Application;
import ui.controllers.MainMenuController;
import ui.controllers.NewTestScenarioController;
import ui.controllers.TestWebPageController;
import ui.controllers.TestSelectionController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Application.launch(MainMenuController.class, args);
        //ConcreteViewCreator vc = new ConcreteViewCreator();
        //I_View view = vc.createView("MainWindowView");
        //view.runView(this.getScene());
        //NewTestScenarioController controller = new NewTestScenarioController();
        //controller.launch(args);

        //TestSelectionController controller = new TestSelectionController();
        //controller.launch(args);

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new UpdateOperation("url", "limerick", "element", "moyross"));
        queryBuilder.setTargetFile(new TablePlaceHolder());
        queryBuilder.addClause(new WhereClause("id", "1"));
        queryBuilder.doQuery();
        Query query = queryBuilder.getResult();

        //queryBuilder.setDataOperation(new SelectOperation("id", "element"));
        //queryBuilder.setTargetFile(new TableTestCases());
        //queryBuilder.addClause(new WhereClause("id", "2"));
        //queryBuilder.doQuery();
////
        //Query query = queryBuilder.getResult();
        //List<String> data = query.getResult();


//
        //for (int i = 0; i < data.size(); i++) {
        //    System.out.println(data.get(i));
        //}

        /*
        I_QueryBuilder queryBuilder = new QueryBuilder();
<<<<<<< Updated upstream
        //queryBuilder.setDataOperation(new DeleteOperation());
        //queryBuilder.setTargetFile(new TableTestCases());
        //queryBuilder.addClause(new WhereClause("element", "textBox"));
=======
        queryBuilder.setDataOperation(new SelectOperation("*"));
        queryBuilder.setTargetFile(new TableTestCases());
        //queryBuilder.addClause(new WhereClause("id", "1"));
        queryBuilder.addClause(new WhereClause("id", "2"));

        Query query = queryBuilder.getResult();
        List<String> data = new ArrayList<>(query.getResult());
>>>>>>> Stashed changes

        //Query query = queryBuilder.getResult();
        //List<String> data = new ArrayList<>(query.getResult());

<<<<<<< Updated upstream
        queryBuilder.setDataOperation(new InsertOperation("5", "linkedin.com", "testing", "LinkedIn", "world", "hello"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.doQuery();
        Query query = queryBuilder.getResult();
        //for (int i = 0; i < data.size(); i++) {
        //    System.out.println(data.get(i));
        //}

=======
        query.getResult();

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        */

       // new WebParser().parse("https://www.facebook.com/");
        //Application.launch(ParsePageView.class, args);
       // new XMLParser().parse("C:\\Users\\George\\Desktop\\SystemsArchitecture\\src\\xml\\pages\\google.xml");
    }
}
