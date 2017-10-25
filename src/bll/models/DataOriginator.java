package bll.models;

public class DataOriginator implements I_Originator {

    private String text;

    public DataOriginator() {

    }

    public DataOriginator(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void restore(I_Memento m) {
        Memento memento = (Memento) m;
        this.text = memento.getState();
    }


    public I_Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(text);
        return memento;
    }
}

class Memento implements I_Memento {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
