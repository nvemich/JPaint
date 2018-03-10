package controller;

import model.*;
import model.Shape;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class MoveCommand implements IMODE {
    SelectedShapes selectedShapes;
    PaintCanvas paintCanvas;
    ShapeList shapeList;
    int new_x,new_y, new_end_x, new_end_y;
    Graphics2D graphics;
    OutlineShape outline;
    FilledInShape filled;
    OutlineAndFilledIn outfilled;

    public MoveCommand(SelectedShapes selectedShapes, ShapeList shapeList, PaintCanvas paintCanvas, int new_x, int new_y, int end_x, int end_y){
        this.selectedShapes = selectedShapes;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.new_x = new_x;
        this.new_y = new_y;
        this.new_end_x = end_x;
        this.new_end_y = end_y;
        graphics = paintCanvas.getGraphics2D();
    }

    @Override
    public void run() {

        // find the offsets of the mouse drag
        int dx = new_end_x - new_x;
        int dy = new_end_y - new_y;

        // for each selected shape, move it by the offsets by creating a new shape with those offsets
        if (!selectedShapes.isEmpty()) {
            for (Shape selected : selectedShapes) {
                for (Shape list : shapeList) {
                    if (selected.getShape().equals(list.getShape()) && (selected.getStartX() == list.getStartX()) &&
                            (selected.getStartY() == list.getStartY())) {                                   // if shape has been selected matches shapelist
                        Shape newShape = new Shape(list.getShape(), list.getStartX() + dx, (list.getStartY() + dy), (list.getEndX() + dx),
                                (list.getEndY() + dy), list.getPColor(), list.getSColor(), list.getShade());
                        shapeList.add(newShape);
                        break;
                    }
                }
                shapeList.remove(selected);
            }

            selectedShapes.clear();
            graphics.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
            reDrawShapes();
        }
    }


    public void reDrawShapes(){
        System.out.println("ReDrawing Shapes");
        for(Shape shape: shapeList){
            System.out.println("New ShapeList: " + shape.getShape());
            if(shape.getShade().toString().equalsIgnoreCase("outline")){
                outline = new OutlineShape(paintCanvas,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                outline.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("FILLED_IN")){
                filled = new FilledInShape(paintCanvas,shape.getShape(),shape.getPColor(),shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
                filled.drawShape();
            }else if(shape.getShade().toString().equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
                outfilled = new OutlineAndFilledIn(paintCanvas,shape.getShape(),shape.getPColor(),shape.getSColor(),shape.getStartX(),
                        shape.getStartY(),shape.getEndX(),shape.getEndY());
                outfilled.drawShape();
            }
        }
    }
}
