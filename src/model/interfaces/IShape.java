package model.interfaces;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IShape {
    ShapeType getShape();
    Color getPColor();
    Color getSColor();
    ShapeShadingType getShade();
    int getStartX();
    int getStartY();
    int getWidth();
    int getHeight();
    int getEndX();
    int getEndY();
}
