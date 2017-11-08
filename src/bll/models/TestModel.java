package bll.models;

import dal.TableTestCases;
import dal.I_QueryBuilder;
import dal.Query;
import dal.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.InsertOperation;
import dal.datamanipulation.dataoperations.SelectOperation;

import java.util.List;

import static dal.TableTestCases.getInstance;

public class TestModel {
    I_QueryBuilder queryBuilder;
    Query query;

    public TestModel() {
        this.queryBuilder = new QueryBuilder();
        this.query = new Query();
    }

    public List<String> selectOperation(String cols) {
        queryBuilder.setDataOperation(new SelectOperation(cols));
        queryBuilder.setTargetFile(getInstance());
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        return query.getResult();
    }

    public List<String> selectWithWhereOperation(String cols, String where1, String where2) {
        queryBuilder.setDataOperation(new SelectOperation(cols));
        queryBuilder.setTargetFile(getInstance());
        queryBuilder.addClause(new WhereClause(where1, where2));
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        return query.getResult();
    }

    public void insertOperation(String testName, String xmlPath){
        //String i = "1"; //get largest id in file and and +1
        queryBuilder.setDataOperation(new InsertOperation(testName, xmlPath));
        queryBuilder.setTargetFile(TableTestCases.getInstance());
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
    }

    public boolean checkUniqueName(String n){
        query = null;
        queryBuilder = null;
        queryBuilder.setDataOperation(new SelectOperation("name"));
        queryBuilder.setTargetFile(TableTestCases.getInstance());
        queryBuilder.addClause(new WhereClause("name", n));
        queryBuilder.doQuery();
        query = queryBuilder.getResult();
        List<String> list = query.getResult();
        for(String l : list){
            System.out.println(l);
        }
        if(list.size() == 0)
            return true;
        else
            return false;
    }
}