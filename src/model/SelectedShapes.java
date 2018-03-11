package model;

import controller.IUndoable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SelectedShapes{
   private static final Stack<Shape> selected = new Stack<Shape>();

    public static void add(Shape shape){
        selected.push(shape);
    }

    public static void clear(){
        selected.clear();
    }

    public static Boolean isEmpty(){
        return selected.isEmpty();
    }

//    public static Iterator<Shape> iterator(){
////        return selected.iterator();
////    }

    public static Shape getShape(int i){
        return selected.get(i);
    }

    public static int getSize(){
        return selected.size();
    }
}

