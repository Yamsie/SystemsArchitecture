package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager instance = null;

    File file;
    List<String> data = new ArrayList<>();


    public DataManager() {
        try(BufferedReader br = new BufferedReader(new FileReader("data/TEST_SCENARIOS.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            for(int i = 0; line != null; i++) {
                sb.append(line);
                sb.append(System.lineSeparator());
                data.add(br.readLine());
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
