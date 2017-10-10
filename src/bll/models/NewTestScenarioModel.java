package bll.models;

import dal.DataManager;

import java.util.ArrayList;
import java.util.List;

public class NewTestScenarioModel {

    private DataManager dataManager;
    private List<TestCase> data;
    
    public NewTestScenarioModel() {
        dataManager = DataManager.getInstance();
        dataToTestCase();
    }

    private void dataToTestCase() {
        for(int i = 0; i < dataManager.getData().size(); i++) {
            String[] splitData = dataManager.getData().get(i).split(",");
            TestCase testCase = new TestCase(splitData);
            data.add(testCase);
        }
    }

    public List<TestCase> getData() {
        return data;
    }
}
