package bll.models;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    List<I_Memento> mementos = new ArrayList<>();

    public void addMemento(I_Memento m) {
        mementos.add(m);
    }

    public I_Memento getMemento(int index) {
        return mementos.get(index);
    }
}
