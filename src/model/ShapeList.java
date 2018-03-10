package model;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ShapeList extends ArrayList<Shape>{
    private ArrayList<Shape> shapes;

    public void push(Shape t){
        if ( t == null) throw new IllegalArgumentException();
        this.add(t);
    }

//    public Integer pop(){
//        if (this.isEmpty()) throw new EmptyStackException();
//        return this.remove(this.size());
//    }

}
