package bll.models;

import dal.TableTestCases;
import dal.I_QueryBuilder;
import dal.Query;
import dal.QueryBuilder;
import dal.datamanipulation.dataoperations.SelectOperation;

import java.util.ArrayList;
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
        queryBuilder.setTargetFile(new TableTestCases());

        Query query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("url"));
        queryBuilder.setTargetFile(new TableTestCases());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("element"));
        queryBuilder.setTargetFile(new TableTestCases());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(new TableTestCases());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        queryBuilder = new QueryBuilder();
        queryBuilder.setDataOperation(new SelectOperation("input"));
        queryBuilder.setTargetFile(new TableTestCases());

        query = queryBuilder.getResult();
        columns.add(query.getResult());

        data = columns;
    }
}
