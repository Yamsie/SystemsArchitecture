package bll;

public interface I_Originator {
    void restore(I_Memento m);
    I_Memento createMemento();
}
