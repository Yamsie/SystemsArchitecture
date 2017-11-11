package bll.dataformatter;

import java.util.List;
import bll.parser.MyElement;

public interface I_DataFormatter {
    void convertFile(String rootElement, List<MyElement> list);
}