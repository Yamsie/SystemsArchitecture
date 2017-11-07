package dal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableTestCases extends DataManager {

    private static class SingletonHolder {
        private static final TableTestCases INSTANCE = new TableTestCases();
    }

    public static TableTestCases getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private TableTestCases() {
        super.setTarget(new File("data/TEST_CASES.txt"));
        super.readData();
    }
}
