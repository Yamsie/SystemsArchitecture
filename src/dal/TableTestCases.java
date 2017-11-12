package dal;

import bll.models.Settings;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableTestCases extends DataManager {
    public TableTestCases() {
        super.setTarget(new File(Settings.getInstance().getProperty("TEST_CASES")));
        super.readData();
    }
}
