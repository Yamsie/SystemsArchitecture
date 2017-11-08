import dal.I_QueryBuilder;
import dal.Query;
import dal.QueryBuilder;
import dal.TableTestCases;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.application.Application;
import ui.controllers.MainMenuController;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Application.launch(MainMenuController.class, args);
    }
}