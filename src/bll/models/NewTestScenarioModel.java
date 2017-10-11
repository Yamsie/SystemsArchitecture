package bll.models;

import dal.DataManager;
import dal.TableTestCases;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewTestScenarioModel {

    private DataManager dataSource;
    private List<TestCase> data;
    
    public NewTestScenarioModel() {
        dataSource = TableTestCases.getInstance();
        data = new ArrayList<>();
        dataToTestCase();
    }

    private void dataToTestCase() {
        for(int i = 0; i < dataSource.getDataCapsule().getData().size(); i++) {
            String[] splitData = dataSource.getDataCapsule().getData().get(i).split(",");
            TestCase testCase = new TestCase(splitData);
            System.out.println(testCase.getName());
            data.add(testCase);
        }
    }

    public List<TestCase> getData() {
        return data;
    }

    public TableView<List<String>> readTabDelimitedFileIntoTable(Path file) {
        TableView<List<String>> table = new TableView<>();
        try {
            Files.lines(file).map(line -> line.split(",")).forEach(values -> {
                // Add extra columns if necessary:
                for (int i = table.getColumns().size(); i < values.length; i++) {
                    TableColumn<List<String>, String> col = new TableColumn<>("Column " + (i + 1));
                    col.setMinWidth(80);
                    final int colIndex = i;
                    col.setCellValueFactory(data -> {
                        List<String> rowValues = data.getValue();
                        String cellValue;
                        if (colIndex < rowValues.size()) {
                            cellValue = rowValues.get(colIndex);
                        } else {
                            cellValue = "";
                        }
                        return new ReadOnlyStringWrapper(cellValue);
                    });
                    table.getColumns().add(col);
                }

                // add row:
                table.getItems().add(Arrays.asList(values));
            });
        }
        catch (IOException exception) {
            System.out.println("Exception - IO");
        }
        return table ;
    }
}
