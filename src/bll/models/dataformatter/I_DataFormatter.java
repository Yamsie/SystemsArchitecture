package bll.models.dataformatter;

import java.util.ArrayList;

public interface I_DataFormatter
{
    String [] attr = {"id", "name", "url", "class"};
    void convertFile(String rootElement, ArrayList<String[]> list);
}
