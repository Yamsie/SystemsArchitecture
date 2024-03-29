package bll.models;

import dal.TableTestCases;
import dal.I_QueryBuilder;
import dal.Query;
import dal.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.InsertOperation;
import dal.datamanipulation.dataoperations.SelectOperation;

import java.util.List;

public class TestModel {

    private I_QueryBuilder queryBuilder;
    private Query query;
    private static final String [] COLUMN_ATTRIBUTES = {"pageURL", "elementType", "elementID",
            "elementName", "elementClass", "elementXPath", "input"};


    public TestModel() {
        this.queryBuilder = new QueryBuilder();
        this.query = new Query();
    }

    public List<String> selectOperation(String cols) {
        queryBuilder.setDataOperation(new SelectOperation(cols));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        return query.getResult();
    }

    public List<String> selectWithWhereOperation(String cols, String where1, String where2) {
        queryBuilder.setDataOperation(new SelectOperation(cols));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause(where1, where2));
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        return query.getResult();
    }

    public void insertOperation(String testName, String xmlPath){
        //String i = "1"; //get largest id in file and and +1
        queryBuilder.setDataOperation(new InsertOperation(testName, xmlPath));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
    }

    public boolean checkUniqueName(String n){
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(new TableTestCases());
        queryBuilder.addClause(new WhereClause("name", n));
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        List<String> list = query.getResult();
        for(String l : list){
            System.out.println(l);
        }
        return list.size() == 0;
    }

    public static String [] getAttributes() {
       return COLUMN_ATTRIBUTES;
    }
}