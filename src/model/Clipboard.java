package model;


import controller.ICommand;
import controller.IList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Clipboard extends ArrayList<Shape> implements ICommand{
    private ArrayList<Shape> shapes;

    public void push(Shape t) {
        if (t == null) throw new IllegalArgumentException();
        this.add(t);
    }

        public Shape pop(){
        if (this.isEmpty()) throw new EmptyStackException();
        return this.remove(this.size()-1);
    }

    @Override
    public void run() throws IOException {
        shapes.toString();
    }



}