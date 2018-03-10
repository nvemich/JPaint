package controller;

import model.DrawShape;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class DrawMode implements IMODE {
    PaintCanvas canvas;
    ColorList colorList;
    ApplicationState appstate;
    int s_x, s_y, e_x, e_y;
    DrawShape shape;
    ShapeList shapeList;
    public DrawMode(PaintCanvas canvas, ShapeList shapes, ColorList colorList, ApplicationState appstate, int sx, int sy, int ex, int ey){
        this.canvas = canvas;
        this.colorList = colorList;
        this.appstate = appstate;
        this.s_x = sx;
        this.s_y = sy;
        this.e_x = ex;
        this.e_y = ey;
        this.shapeList = shapes;
    }

    @Override
    public void run(){
        shape = new DrawShape(canvas, colorList, appstate.getActiveShapeType(), appstate.getActivePrimaryColor(), appstate.getActiveSecondaryColor(),
                appstate.getActiveShapeShadingType(),s_x, s_y, e_x, e_y);
        shape.draw();
    }
}
