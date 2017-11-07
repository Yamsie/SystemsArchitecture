package bll.models;

import dal.TableTestCases;
import dal.datamanipulation.I_QueryBuilder;
import dal.datamanipulation.Query;
import dal.datamanipulation.QueryBuilder;
import dal.datamanipulation.dataclauses.WhereClause;
import dal.datamanipulation.dataoperations.SelectOperation;

import java.util.List;

public class TestModel {
    I_QueryBuilder queryBuilder;
    Query query;

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
}