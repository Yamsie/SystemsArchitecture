package bll.models.dataformatter;

import java.util.ArrayList;

public interface IDataFormatter {
    void convertFile(String rootElement, ArrayList<String[]> list);
}
