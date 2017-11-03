//import bll.RunTestCase;
import bll.models.NewTestScenarioModel;
import bll.models.parser.WebParser;
import bll.models.parser.XMLParser;
import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.DeleteOperation;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.application.Application;
import ui.controllers.NewTestScenarioController;
import ui.controllers.TestWebPageController;
import ui.controllers.TestSelectionController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Application.launch(MainMenuView.class, args);
        //ConcreteViewCreator vc = new ConcreteViewCreator();
        //I_View view = vc.createView("MainWindowView");
        //view.runView(this.getScene());
        //NewTestScenarioController controller = new NewTestScenarioController();
        //controller.launch(args);

        //TestSelectionController controller = new TestSelectionController();
        //controller.launch(args);

        //I_QueryBuilder queryBuilder = new QueryBuilder();
        //queryBuilder.setDataOperation(new SelectOperation("id", "element"));
        //queryBuilder.setTargetFile(new TableTestCases());
        //queryBuilder.addClause(new WhereClause("id", "2"));
////
        //Query query = queryBuilder.getResult();
        //List<String> data = query.getResult();
//
        //for (int i = 0; i < data.size(); i++) {
        //    System.out.println(data.get(i));
        //}

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url", "id", "element"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("id", "1"));

        Query query = queryBuilder.getResult();
        List<String> data = new ArrayList<>(query.getResult());


        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

       // new WebParser().parse("https://www.facebook.com/");
        //Application.launch(ParsePageView.class, args);
       // new XMLParser().parse("C:\\Users\\George\\Desktop\\SystemsArchitecture\\src\\xml\\pages\\google.xml");
    }
}
