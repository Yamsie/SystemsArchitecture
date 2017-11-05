package bll.models.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoggerOperator {
    private List<String> data = new ArrayList<String>();
    private File csv;
    private Scanner scanner;
    private String filename;


    public LoggerOperator(String filename) {
        this.filename = filename;
        openFile(filename);
        readFile();
    }

    public String getLastResult(){
        String result = "";
        int size = data.size();
        result = data.get(size - 1);
        return result;
    }
    public String[] getRow(int id) {
        String[] row = readFileRow(id);
        return row;
    }

    public List<String> getData() {
        return data;
    }

    public void addData(String info) {
        data.add(info);
        writeData(data);
    }

    public void deleteData(String info){
        for(int i = 0; i < data.size(); ++i){
            if(info.equals(data.get(i))){
                data.remove(i);
            }
        }
        writeData(data);
    }

    public int getColumnIndex(String column) {
        String[] rowElements;
        int index = 0;
        boolean complete = false;
        rowElements = data.get(0).split(",");

        for (int i = 0; i < rowElements.length && complete == false; i++) {
            if (rowElements[i].compareTo(column) == 0) {
                index = i;
                complete = true;
            }
        }
        return index;
    }

    protected void openFile(String filename) {
        try {
            csv = new File(filename);
            scanner = new Scanner(csv);
        } catch (FileNotFoundException e) {
            //System.out.println("Exception: " + e + "\n Exiting program.");
            //System.exit(0);
        }

    }

    protected String[] readFileRow(int id) {
        String[] rowElements;
        boolean complete = false;
        for (int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            try {
                if (Integer.parseInt(rowElements[0]) == id) {
                    return rowElements;
                }
            } catch (NumberFormatException e) {
            }
        }

        return null;
    }

    protected void readFile() {
        data = new ArrayList<>();
        try {
            while (scanner.hasNext()) {
                data.add(scanner.next());
            }
        } catch (NullPointerException e) {

        }
    }

    protected void writeData(List<String> newData) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (String str : newData) {
                writer.write(str + "\n");
            }
            writer.close();
        } catch (IOException e) {
        }
    }
}