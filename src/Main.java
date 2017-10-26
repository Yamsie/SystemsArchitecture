import bll.RunTestCase;
import bll.models.NewTestScenarioModel;
import bll.models.parser.WebParser;
import bll.models.parser.XMLParser;
import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.application.Application;
import ui.controllers.MainMenuController;
import ui.controllers.NewTestScenarioController;

import ui.controllers.TestWebPageController;

import ui.controllers.TestSelectionController;

import ui.views.I_View;
import ui.views.MainMenuView;
import ui.views.NewTestScenarioView;
import ui.views.ParsePageView;

import java.util.List;

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

       // new WebParser().parse("https://www.facebook.com/");
       // new XMLParser().parse("C:\\Users\\George\\Desktop\\SystemsArchitecture\\src\\xml\\pages\\google.xml");

    }
}
