package dal;

import dal.datamanipulation.DataCapsule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataManager {

    private File file;
    private DataCapsule dataCapsule;


    public DataManager() {

    }

    protected void readData() {
        try(Scanner in = new Scanner(file)) {
            String[] columns = in.nextLine().split(","); //get columns, move on to first line with data
            List<String> data = new ArrayList<>();
            String line;
            while(in.hasNext()) {
                line = in.nextLine();
                data.add(line);
            }
            dataCapsule = new DataCapsule(data, columns);
        }
        catch(IOException exception) {
            System.out.println("File not found in " + getClass().getResource("").toString());
        }
    }

    public DataCapsule getDataCapsule() {
        return dataCapsule;
    }

    public File getSource() {
        return file;
    }

    public void setTarget(File file) {
        this.file = file;
    }

}
