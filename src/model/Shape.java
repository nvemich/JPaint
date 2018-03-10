package model;

import model.interfaces.IShape;

import java.awt.*;

public class Shape implements IShape{
    ShapeType shape;
    Color primary,seconday;
    ShapeShadingType shading;
    int start_x,start_y,end_x,end_y;


    public Shape(ShapeType shape, int start_x, int start_y, int end_x,
        int end_y)
    {
        this.shape =shape;
//        this.primary = primary;
//        this.seconday = seconday;
//        this.shading = shading;
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }


    @Override
    public ShapeType getShape() {
        return  shape;
    }

//    @Override
//    public Color getPColor() {
//        return primary;
//    }
//
//    @Override
//    public Color getSColor() {
//        return seconday;
//    }
//
//    @Override
//    public ShapeShadingType getShade() {
//        return shading;
//    }

    @Override
    public int getStartX() {
        return start_x;
    }

    @Override
    public int getStartY() {
        return start_y;
    }

    @Override
    public int getEndX() {
        return end_x;
    }

    @Override
    public int getEndY() {
        return end_y;
    }

    public int getWidth(){
        return end_x-start_x;
    }

    public int getHeight(){
        return end_y-end_x;
    }
}
