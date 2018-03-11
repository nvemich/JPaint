package model;


import controller.ICommand;
import controller.IList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Clipboard extends ArrayList<Shape>{
    private ArrayList<Shape> shapes;

    public void push(Shape t) {
        if (t == null) throw new IllegalArgumentException();
        this.add(t);
    }

        public Shape pop(){
        if (this.isEmpty()) throw new EmptyStackException();
        return this.remove(this.size()-1);
    }



}