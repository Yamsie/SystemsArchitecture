package bll.models.dataformatter;

import java.util.ArrayList;

public interface I_DataFormatter {
    String [] attr = {"id", "name", "url", "class"};
    void convertFile(String rootElement, String url, ArrayList<String[]> list);
}
