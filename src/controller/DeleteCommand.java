package controller;

import model.*;
import model.Shape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoable {
    PaintCanvas canvas;
    ShapeList shapeList;
    SelectedShapes selectedShapes;
    OutlineAndFilledIn outfilled;
    FilledInShape filled;
    OutlineShape outline;
    Graphics2D graphics;
    ArrayList<Shape> tempRemoved = new ArrayList<>();

    public DeleteCommand(PaintCanvas canvas, ShapeList shapeList) {
        this.canvas = canvas;
        this.shapeList = shapeList;
        graphics = canvas.getGraphics2D();
    }

    @Override
    public void run() {
        if (!selectedShapes.isEmpty()) {
            CommandHistory.add(this);
            for(int i =0; i < SelectedShapes.getSize(); i++){
                System.out.println("Selected Shape: " + SelectedShapes.getShape(i));
                for (Shape shapes : shapeList) {
                    System.out.println("ShapeList: " + shapes.getShape());
                    if (SelectedShapes.getShape(i).equals(shapes.getShape()) && (SelectedShapes.getShape(i).getStartX() == shapes.getStartX()) &&
                            (SelectedShapes.getShape(i).getStartY() == shapes.getStartY())) {
                        shapeList.remove(shapes);
                        tempRemoved.add(shapes);
                        break;
                    }
                }
            }

        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        reDrawShapes();
    }
    }

    public void reDrawShapes(){
        System.out.println("ReDrawing Shapes");
        for(Shape shape: shapeList){
            System.out.println("New ShapeList: " + shape.getShape());
            if(shape.getShade().toString().equalsIgnoreCase("outline")){
                outline = new OutlineShape(canvas,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                outline.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("FILLED_IN")){
                filled = new FilledInShape(canvas,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                filled.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
                outfilled = new OutlineAndFilledIn(canvas,shape.getShape(),shape.getPColor(),shape.getSColor(),shape.getStartX(),
                        shape.getStartY(),shape.getEndX(),shape.getEndY());
                outfilled.drawShape();
            }
        }
    }

    @Override
    public void undo() {
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(Shape deleted: tempRemoved) {
            shapeList.add(deleted);
        }
        reDrawShapes();
    }

    @Override
    public void redo() {
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(Shape deleted: tempRemoved) {
            shapeList.remove(deleted);
        }
        reDrawShapes();
    }
}