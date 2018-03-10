package model.interfaces;

import model.ShapeType;
import view.Point;

public interface IShapeList {
    void coords(Point start, Point end);
    void push();
    void pop();

 }
