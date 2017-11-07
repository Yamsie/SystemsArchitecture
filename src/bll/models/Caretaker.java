package bll.models;

import bll.models.parser.MyElement;
import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
    private Stack mementoStack;
    private Stack originatorStack;
    private DataOriginator DO;

    public Caretaker(){
        mementoStack = new Stack();
        originatorStack = new Stack();
    }

    public void setDataOriginator(DataOriginator DO){
        this.DO = DO;
    }

    public void undoOperation(){
            I_Originator o = (I_Originator)originatorStack.pop();
            o.restore((I_Memento)mementoStack.pop());
    }

    public int getMementoStackSize(){
        int size = mementoStack.size();
        return size;
    }

    public void setOriginatorValue(ArrayList<MyElement> Value){
        mementoStack.push(DO.createMemento());
        originatorStack.push(DO);
        DO.setList(Value);
    }

    public ArrayList<MyElement> getDataValue(){
        return DO.getList();
    }
}
