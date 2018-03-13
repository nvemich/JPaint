package controller;

import model.*;
import model.Shape;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MoveCommand implements IMODE, IUndoable {
    PaintCanvas paintCanvas;
    ShapeList shapeList;
    int new_x,new_y, new_end_x, new_end_y;
    Graphics2D graphics;
    OutlineShape outline;
    FilledInShape filled;
    OutlineAndFilledIn outfilled;
    ArrayList<Shape> tempNew = new ArrayList<>();
    ArrayList<Shape> tempRemoved = new ArrayList<>();
    Shape selectedShape;


    public MoveCommand(ShapeList shapeList, PaintCanvas paintCanvas, int new_x, int new_y, int end_x, int end_y){
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
        CommandHistory.add(this);

        int dx = new_end_x - new_x;
        int dy = new_end_y - new_y;


        if (!SelectedShapes.isEmpty()) {
            for(int i = 0; i < SelectedShapes.getSize(); i++)
            {
                selectedShape = SelectedShapes.getShape(i);
                for (Shape list : shapeList) {
                    if (selectedShape.getShape().equals(list.getShape()) && (selectedShape.getStartX() == list.getStartX()) &&
                            (selectedShape.getStartY() == list.getStartY())) {
                        Shape newShape = new Shape(list.getShape(), list.getStartX() + dx, (list.getStartY() + dy), (list.getEndX() + dx),
                                (list.getEndY() + dy), list.getPColor(), list.getSColor(), list.getShade());
                        shapeList.add(newShape);
                        tempNew.add(newShape);
                        break;
                    }
            }
                shapeList.remove(selectedShape);
                tempRemoved.add(selectedShape);
            }

            graphics.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
            reDrawShapes();
        }
    }


    public void reDrawShapes(){
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

    @Override
    public void undo() {
        graphics.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shape added: tempNew){
            shapeList.remove(added);
        }
        for(Shape removed: tempRemoved) {
            shapeList.add(removed);
        }
        reDrawShapes();



    }

    @Override
    public void redo() {

        graphics.clearRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shape added: tempNew){
            shapeList.add(added);
        }
        for(Shape removed: tempRemoved) {
            shapeList.remove(removed);
        }
        reDrawShapes();

    }
}
