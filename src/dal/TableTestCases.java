package dal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableTestCases extends DataManager {

    private static TableTestCases instance = null;

    public static TableTestCases getInstance() {
        if(instance == null) {
            instance = new TableTestCases();
        }
        return instance;
    }

    public TableTestCases() {
        super.setTarget(new File("data/PLACE_HOLDER.txt"));
        super.readData();
    }
}
