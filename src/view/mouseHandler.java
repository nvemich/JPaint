package view;


import controller.*;
import model.*;
import model.Shape;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


//mouse handler to handle all my mouse events, like press and release
public class mouseHandler extends MouseAdapter implements MouseListener {

    int start_x, start_y, end_x, end_y;
    PaintCanvas paint;
    ApplicationState state;
    ShapeList shapeList;
    ColorList colorList;
    IMODE mode;
    CommandHistory commands;
    Clipboard clipboard;

    public mouseHandler(PaintCanvas paint, ShapeList list) {
        this.paint = paint;
        this.shapeList = list;
        clipboard = new Clipboard();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        this.start_x = e.getX();
        this.start_y = e.getY();
        System.out.println(start_x+","+start_y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.end_x = e.getX();
        this.end_y = e.getY();
        System.out.println(end_x+","+end_y);


        if (state.getActiveStartAndEndPointMode().toString().equalsIgnoreCase("Select")) {
            for (Shape shape : shapeList) {
                if(start_x==end_x){
                if ((shape.getStartX() <= end_x) && (shape.getEndX() >= end_x) && (shape.getStartY() <= end_y) && (shape.getEndY() >= end_y)) {
                    {
                        System.out.println("Selected Shape: " + shape.getShape().toString());
                        SelectedShapes.add(shape);
                    }
                }else
                    SelectedShapes.clear();
                }else if((shape.getStartX() > start_x) && (shape.getStartY() > getStart_y()) // Checks the top left corner of the shape and the rectangle
                            && ((shape.getEndX() < e.getX()) && ((shape.getEndY() < e.getY())))){
                    System.out.println("Selected Shape: " + shape.getShape().toString());
                    SelectedShapes.add(shape);
                }
            }
        }else {
            switch (state.getActiveStartAndEndPointMode().toString()) {
                case "DRAW":
                    mode = new DrawMode(paint, shapeList, colorList, state, start_x, start_y, end_x, end_y);
                    break;
                case "MOVE":
                    mode = new MoveCommand(shapeList, paint, start_x,start_y,end_x,end_y);
                    break;
            }
            mode.run();
        }

    }

    public void setStates(ApplicationState state, ColorList list, CommandHistory commands){
        this.commands = commands;
        this.colorList = list;
        this.state = state;
    }

    public Clipboard getClipboard(){
        return clipboard;
    }

    public PaintCanvas getCanvas(){
        return paint;
    }

    public ShapeList getShapeList(){
        return shapeList;
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