package dal;

import java.io.File;

public class TablePlaceHolder extends DataManager {
    private static TablePlaceHolder instance = null;

    public static TablePlaceHolder getInstance() {
        if(instance == null) {
            instance = new TablePlaceHolder();
        }
        return instance;
    }

    public TablePlaceHolder() {
        super.setTarget(new File("data/PLACE_HOLDER.txt"));
        super.readData();
    }
}
