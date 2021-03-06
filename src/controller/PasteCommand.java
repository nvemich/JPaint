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
    ShapeList shapelist;
    Shape newShape;

    public PasteCommand(Clipboard clipboard, PaintCanvas paint, ShapeList shapelist){
        this.shapelist = shapelist;
       this.paint = paint;
        this.clipboard = clipboard;
    }



    @Override
    public void run(){
        CommandHistory.add(this);

        graphics = paint.getGraphics2D();
        for(Shape shape: clipboard){
        newShape = new Shape(shape.getShape(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY(),
                shape.getPColor(),shape.getSColor(),shape.getShade());
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
            shapelist.push(newShape);
        }
    }

    @Override
    public void undo() {
        shapelist.remove(newShape);
        graphics.clearRect(0, 0, paint.getWidth(), paint.getHeight());
        for(Shape shape: shapelist){
            System.out.println("New ShapeList: " + shape.getShape());
            if(shape.getShade().toString().equalsIgnoreCase("outline")){
                outline = new OutlineShape(paint,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                outline.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("FILLED_IN")){
                filled = new FilledInShape(paint,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                filled.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
                outfilled = new OutlineAndFilledIn(paint,shape.getShape(),shape.getPColor(),shape.getSColor(),shape.getStartX(),
                        shape.getStartY(),shape.getEndX(),shape.getEndY());
                outfilled.drawShape();
            }
        }

    }

    @Override
    public void redo() {
        for(Shape shape: clipboard){
            newShape = new Shape(shape.getShape(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY(),
                    shape.getPColor(),shape.getSColor(),shape.getShade());
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
            shapelist.push(newShape);
        }
    }

}
