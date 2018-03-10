package controller;

import model.ShapeList;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class SelectMode implements IMODE {
    ShapeList shapeList;
    int start_x,start_y, end_x, end_y;
    PaintCanvas canvas;

    public SelectMode(PaintCanvas canvas,ShapeList shapeList, int start_x, int start_y, int end_x, int end_y){
        this.shapeList = shapeList;
        this.start_x = start_x;
        this.start_y =start_y;
        this.end_x = end_x;
        this.end_y = end_y;
        this.canvas = canvas;
    }

    @Override
    public void run(){
        for (IShape shape: shapeList)
        {

            System.out.println(shape.getShape());


           if ((shape.getStartX() > start_x) && (shape.getStartY() > start_y) // Checks the top left corner of the shape and the rectangle
                    && ((shape.getStartX() + shape.getWidth()) < e.getX()) && ((shape.getY() + shape.getHeight()) < e.getY())) // Checks the bottom right corner of the shape and the rectangle
//            {
//                Selection.Add((IDraggableShape) snapshot);
//            }
        }
//        remove(rectangle);
        canvas.repaint();
    }

}
