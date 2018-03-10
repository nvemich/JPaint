package controller;

import model.*;
import model.Shape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.IOException;

public class DeleteCommand implements ICommand, IUndoable {
    PaintCanvas canvas;
    ShapeList shapeList;
    SelectedShapes selectedShapes;
    DrawShape draw;
    ColorList colorList;
    OutlineAndFilledIn outfilled;
    FilledInShape filled;
    OutlineShape outline;
    Graphics2D graphics;

    public DeleteCommand(PaintCanvas canvas, ShapeList shapeList, SelectedShapes selectedShapes) {
        this.canvas = canvas;
        this.shapeList = shapeList;
        this.selectedShapes = selectedShapes;
        graphics = canvas.getGraphics2D();
    }

    @Override
    public void run() {
        System.out.println(selectedShapes.toString());
        System.out.println(shapeList.toString());


        if (!selectedShapes.isEmpty()) {
            for (Shape selected : selectedShapes) {
                System.out.println("Selected Shape: " + selected.getShape());
                for (Shape shapes : shapeList) {
                    System.out.println("ShapeList: " + shapes.getShape());
                    if (selected.getShape().equals(shapes.getShape()) && (selected.getStartX() == shapes.getStartX()) &&
                            (selected.getStartY() == shapes.getStartY())) {
                        shapeList.remove(shapes);
                        break;
                    }
                }
            }
        shapeList.remove(shapeList.size()-1);
        selectedShapes.clear();
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

    }

    @Override
    public void redo() {

    }
}