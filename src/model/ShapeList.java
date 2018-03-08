package model;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ShapeList extends ArrayList<ShapeType>{
    public void push(ShapeType t){
        if ( t == null) throw new IllegalArgumentException();
        this.add(t);
    }

//    public Integer pop(){
//        if (this.isEmpty()) throw new EmptyStackException();
//        return this.remove(this.size());
//    }

}
