package bll.models;

import dal.DataManager;
import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ui.controllers.NewTestScenarioController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewTestScenarioModel {

    private List<List<String>> data;
    
    public NewTestScenarioModel() {
        data = new ArrayList<>();
    }


    public List<List<String>> getData() {
        return data;
    }

    public void setData() {
        List<List<String>> columns = new ArrayList<List<String>>();

        I_QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("id"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());

        Query query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("element"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("input"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        data = columns;
    }
}
