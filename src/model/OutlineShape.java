package model;

import controller.IShade;
import view.gui.PaintCanvas;

import java.awt.*;

public class OutlineShape implements IShade {
    PaintCanvas canvas;
    ShapeType shape;
    Color primary;
    Graphics2D graphics;
    int start_x,start_y, end_x, end_y;


    public OutlineShape(PaintCanvas canvas, ShapeType shape, Color primary, int start_x, int  start_y, int end_x, int end_y){
        this.canvas = canvas;
        this.shape = shape;
        this.primary = primary;
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }

    @Override
    public void drawShape(){
        graphics = canvas.getGraphics2D();
        graphics.setColor(primary);
        int width = end_x - start_x;
        int height = end_y - start_y;
        int[] xPoints = new int[] {start_x,end_x,start_x};
        int[] yPoints = new int[] {start_y,end_y,end_y};

        if(shape.toString().equalsIgnoreCase("ellipse")) {
            graphics.drawOval(start_x,start_y,width,height);
        }else if(shape.toString().equalsIgnoreCase("rectangle")){
            graphics.drawRect(start_x,start_y,width,height);
        }else if(shape.toString().equalsIgnoreCase("triangle")){
            graphics.drawPolygon(xPoints,yPoints,3);
        }
    }

}
