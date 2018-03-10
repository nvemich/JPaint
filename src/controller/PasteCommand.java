package controller;

import model.*;
import model.Shape;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class PasteCommand implements ICommand, IUndoable{
    Clipboard clipboard;
    PaintCanvas paint;
    Shape shape;
    int new_x,new_y;
    Graphics2D graphics;
    OutlineShape outline;
    FilledInShape filled;
    OutlineAndFilledIn outfilled;

    public PasteCommand(Clipboard clipboard, PaintCanvas paint){
       this.paint = paint;
        this.clipboard = clipboard;
    }



    @Override
    public void run(){


        graphics = paint.getGraphics2D();
        int[] xPoints;
        int[] yPoints;
        for(Shape shape: clipboard){
        new_x = (shape.getEndX()-shape.getStartX()) ;
        new_y = (shape.getEndY()-shape.getStartY());

        if(shape.getShade().toString().equalsIgnoreCase("outline")){
            outline = new OutlineShape(paint,shape.getShape(),shape.getPColor(),0,0,new_x,new_y);
            outline.drawShape();
        }else if(shape.getShade().toString().equalsIgnoreCase("FILLED_IN")){
            filled = new FilledInShape(paint,shape.getShape(),shape.getPColor(),0,0,new_x,new_y);
            filled.drawShape();
        }else if(shape.getShade().toString().equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
            outfilled = new OutlineAndFilledIn(paint,shape.getShape(),shape.getPColor(),shape.getSColor(),0,0,new_x,new_y);
            outfilled.drawShape();
        }
        }
    }

    @Override
    public void undo() {
        //delete shape
    }

    @Override
    public void redo() {

    }

    public Clipboard getList() {
        return clipboard;
    }
}
