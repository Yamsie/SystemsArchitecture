package bll.models.dataformatter;

import java.util.List;
import bll.models.parser.MyElement;

public interface I_DataFormatter {
    void convertFile(String rootElement, List<MyElement> list);
}