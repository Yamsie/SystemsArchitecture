package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataManager {

    private static DataManager instance = null;

    File file;
    List<String> data = new ArrayList<>();


    public DataManager() {
        try(Scanner in = new Scanner(new FileReader("data/TEST_CASES.txt"))) {

            while(in.hasNext()) {
                data.add(in.nextLine());
            }
        }
        catch(IOException exception) {
            System.out.println("File not found in " + getClass().getResource("").toString());
        }
    }

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<String> getData() {
        return data;
    }

}
