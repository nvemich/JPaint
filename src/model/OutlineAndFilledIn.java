package model;

import controller.IShade;
import view.gui.PaintCanvas;

import java.awt.*;

public class OutlineAndFilledIn implements IShade {
    PaintCanvas canvas;
    ShapeType shape;
    Color primary,secondary;
    Graphics2D graphics;
    int start_x, start_y, end_x, end_y;


    public OutlineAndFilledIn(PaintCanvas canvas, ShapeType shape, Color primary, Color secondary,int start_x, int start_y, int end_x, int end_y){
        this.canvas = canvas;
        this.shape = shape;
        this.primary = primary;
        this.secondary = secondary;
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
            graphics.fillOval(start_x,start_y,width,height);
            graphics.setColor(secondary);
            graphics.setStroke(new BasicStroke(5));
            graphics.drawOval(start_x,start_y,width,height);
        }else if(shape.toString().equalsIgnoreCase("rectangle")){
            graphics.fillRect(start_x,start_y,width,height);
            graphics.setColor(secondary);
            graphics.setStroke(new BasicStroke(5));
            graphics.drawRect(start_x,start_y,width,height);
        }else if(shape.toString().equalsIgnoreCase("triangle")){
            graphics.fillPolygon(xPoints,yPoints,3);
            graphics.setColor(secondary);
            graphics.setStroke(new BasicStroke(5));
            graphics.drawPolygon(xPoints,yPoints,3);
        }
    }


}
