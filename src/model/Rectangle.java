package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class Rectangle implements IShape{
    int start_x, start_y, end_x, end_y;
    public Rectangle(int start_x, int start_y, int end_x, int end_y) {
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }


    @Override
    public ShapeType getShape() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public int getStartX() {
        return this.start_x;
    }

    @Override
    public int getStartY() {
        return this.start_y;
    }

    @Override
    public int getWidth() {
        return this.end_x-this.start_x;
    }

    @Override
    public int getHeight() {
        return this.end_y-this.start_y;
    }

    @Override
    public int getEndX() {
        return this.end_x;
    }

    @Override
    public int getEndY() {
        return this.end_y;
    }
}