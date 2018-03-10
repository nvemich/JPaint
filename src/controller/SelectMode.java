package controller;

import model.ShapeList;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class SelectMode implements IMODE {
    ShapeList shapeList;
    int start_x,start_y, end_x, end_y;
    PaintCanvas canvas;
    IShape selected;

    public SelectMode(PaintCanvas canvas,ShapeList shapeList, int start_x, int start_y, int end_x, int end_y){
        this.shapeList = shapeList;
        this.start_x = start_x;
        this.start_y =start_y;
        this.end_x = end_x;
        this.end_y = end_y;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        for (IShape shape : shapeList) {

            if ((shape.getStartX() <= end_x)&& (shape.getEndX() >= end_x) && (shape.getStartY() <= end_y) && (shape.getEndY() >= end_y)) {
                {
                    System.out.println("Shape: " + shape.getShape().toString());
                    System.out.println("Coords: (" + shape.getStartX() + "," + shape.getStartY() + ")(" + shape.getEndX() + "," + shape.getEndY() + ")");
                    selected = shape;
                }
            }


//        remove(rectangle);
            //canvas.repaint();
        }
    }
}
