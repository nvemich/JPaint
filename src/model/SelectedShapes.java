package model;

import java.util.ArrayList;

public class SelectedShapes extends ArrayList<Shape> {
    private ArrayList<Shape> shapes;

    public void push(Shape t){
        if ( t == null) throw new IllegalArgumentException();
        this.add(t);
    }


}
