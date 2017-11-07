package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class DataManager {

    private File file;
    private DataCapsule dataCapsule;

    void readData() {
        try(Scanner in = new Scanner(file)) {
            String[] columns = in.nextLine().split(","); //get columns, move on to first line with data
            List<String> data = new ArrayList<>();
            String line;
            while(in.hasNext()) {
                line = in.nextLine();
                data.add(line);
            }
            dataCapsule = new DataCapsule(data, columns);
            in.close();
        }
        catch(IOException exception) {
            System.out.println("File not found in " + getClass().getResource("").toString());
        }
    }

    void writeData() {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file))) {

            for(int i = 0; i < dataCapsule.getColumns().length; i++) {
                out.write(dataCapsule.getColumns()[i]);
                if(i != (dataCapsule.getColumns().length - 1)) {
                    out.write(",");
                }
            }

            for(int i = 0; i < dataCapsule.getData().size(); i++) {
                out.write("\n");
                out.write(dataCapsule.getData().get(i));
            }

            out.close();
        }
        catch(IOException exception) {
            System.out.println("File not found in " + getClass().getResource("").toString());
        }

        readData();
    }

    public DataCapsule getDataCapsule() {
        return dataCapsule;
    }

    public void setDataCapsule(DataCapsule dataCapsule) {
        this.dataCapsule = dataCapsule;
        writeData();
    }

    public File getSource() {
        return file;
    }

    void setTarget(File file) {
        this.file = file;
    }

}
