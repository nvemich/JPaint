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
    DrawShape shape;
    ApplicationState state;
    ProcessPaint start;
    ShapeList shapeList;
    ColorAdapater primary, secondary;
    ColorList colorList;
    IMODE mode;
    Shape shapeObj;
    CommandHistory commands;
    SelectedShapes selected;
    Clipboard clipboard;
    ICommand cmd;


    public mouseHandler(PaintCanvas paint, ShapeList list, SelectedShapes selected) {
        this.paint = paint;
        this.shapeList = list;
        clipboard = new Clipboard();
        this.selected = selected;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        this.start_x = e.getX();
        this.start_y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.end_x = e.getX();
        this.end_y = e.getY();


        if (state.getActiveStartAndEndPointMode().toString().equalsIgnoreCase("Select")) {
            for (Shape shape : shapeList) {

                if ((shape.getStartX() <= end_x) && (shape.getEndX() >= end_x) && (shape.getStartY() <= end_y) && (shape.getEndY() >= end_y)) {
                    {
                        System.out.println("Selected Shape: " + shape.getShape().toString());
                        selected.push(shape);
                    }
                }
            }
        }

        switch (state.getActiveStartAndEndPointMode().toString()) {
            case "DRAW":
                mode = new DrawMode(paint, shapeList, colorList, state, start_x, start_y, end_x, end_y);
                break;
            case "MOVE":
                mode = 
                break;
        }
        mode.run();


    }

    public void setStates(ApplicationState state, ColorList list, CommandHistory commands){
        this.commands = commands;
        this.colorList = list;
        this.state = state;
    }

    public SelectedShapes getSelectedList(){
        return selected;
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