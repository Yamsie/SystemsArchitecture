package bll.models;

import bll.models.parser.MyElement;

import java.util.ArrayList;

public class DataOriginator implements I_Originator {

    private ArrayList<MyElement> testList;

    public DataOriginator() {

    }

    public void setList(ArrayList<MyElement> testList) {
        this.testList = testList;
    }

    public ArrayList<MyElement> getList() {
        return testList;
    }

    public void restore(I_Memento m) {
        Memento memento = (Memento) m;
        this.testList = memento.getState();
    }


    public I_Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(testList);
        return memento;
    }
}

class Memento implements I_Memento {

    private ArrayList<MyElement> state;

    public ArrayList<MyElement> getState() {
        return state;
    }

    public void setState(ArrayList<MyElement> state) {
        this.state = state;
    }
}
