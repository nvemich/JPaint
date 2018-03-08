package model;

import controller.JPaintController;
import model.interfaces.IShape;
import model.persistence.ApplicationState;


import java.security.InvalidParameterException;

public class ShapeFactory {

    public static IShape createShape(String shapeType){
        IShape shape;
        ShapeList shapes = new ShapeList();

        if(shapeType.toLowerCase().equals("ellipse")){
            //draw ellipse
            shapes.push(ApplicationState.);
            shape = new Ellipse();
        }
        else if(shapeType.toLowerCase().equals("rectangle")){
            //draw rectangle
            shape = new Rectangle();
        }
        else if(shapeType.toLowerCase().equals("triangle")){
            //draw triangle
            shape = new Triangle();
        }
        else {
            throw new InvalidParameterException("Incorrect Shape");
        }

        return shape;
    }
}
