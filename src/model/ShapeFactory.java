package model;

import controller.ICommand;

import model.interfaces.IShape;



import java.security.InvalidParameterException;

public class ShapeFactory implements ICommand{
  //   SelectShape shape;
     int start_x, start_y, end_x, end_y;
     String mode;
     public ShapeFactory(String mode, int start_x, int start_y, int end_x, int end_y){
         this.mode = mode;
         this.start_x = start_x;
         this.start_y = start_y;
         this.end_x = end_x;
         this.end_y = end_y;

     }


    public static IShape createShape(ShapeType shapeType){
        IShape shape;
        ShapeList shapes = new ShapeList();

        if(shapeType.equals("ellipse")){
    //        shape = new Ellipse();
        }
        else if(shapeType.equals("rectangle")){
            //draw rectangle
      //      shape = new Rectangle();
        }
        else if(shapeType.equals("triangle")){
            //draw triangle
       //     shape = new Triangle();
        }
        else {
            throw new InvalidParameterException("Incorrect Shape");
        }

        return null;
    }

    public void run(){

    }
}

