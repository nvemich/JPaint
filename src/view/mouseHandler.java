package view;


import controller.*;
import model.DrawShape;
import model.ProcessPaint;
import model.Shape;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//mouse handler to handle all my mouse events, like press and release
public class mouseHandler extends MouseAdapter implements MouseListener {

    int start_x, start_y, end_x, end_y;
    PaintCanvas paint;
    DrawShape shape;
    ApplicationState state;
    ProcessPaint start;
    ShapeList shapeList;
    ColorAdapater primary,secondary;
    ColorList colorList;
    IMODE mode;
    Shape shapeObj;




    public mouseHandler(PaintCanvas paint, ShapeList list){
        this.paint = paint;
        this.shapeList = list;
    }




    @Override
    public void mousePressed(MouseEvent e) {
        this.start_x = e.getX();
        this.start_y = e.getY();
        System.out.println(start_x + "," + start_y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.end_x = e.getX();
        this.end_y = e.getY();
        System.out.println(end_x + "," + end_y);

        switch(state.getActiveStartAndEndPointMode().toString()){
            case "DRAW":
                mode = new DrawMode(paint,shapeList,colorList,state,start_x,start_y,end_x,end_y);
                shapeObj = new Shape(state.getActiveShapeType(), start_x, start_y, end_x, end_y);
                shapeList.push(shapeObj);
                break;
            case "SELECT":
                mode = new SelectMode(paint,shapeList,start_x,start_y,end_x,end_y);
                break;
            case "MOVE":
                break;
        }
        mode.run();

    }


    public void setStates(ApplicationState state, ColorList list){
        this.colorList = list;
        this.state = state;
    }




    public int getStart_x() {
        return this.start_x;
    }

    public int getStart_y() {
        return this.start_y;
    }

    public int getEnd_x() {
        return this.end_x;
    }

    public int getEnd_y() {
        return this.end_y;
    }

 }