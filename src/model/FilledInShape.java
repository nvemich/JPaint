package model;

import controller.IShade;
import view.gui.PaintCanvas;

import java.awt.*;

public class FilledInShape implements IShade {
    PaintCanvas canvas;
    ShapeType shape;
    Color primary;
    Graphics2D graphics;
    int s_x, s_y, e_x, e_y;


    public FilledInShape(PaintCanvas canvas, ShapeType shape, Color primary, int s_x, int  s_y, int e_x, int e_y){
        this.canvas = canvas;
        this.shape = shape;
        this.primary = primary;
        this.s_x = s_x;
        this.s_y = s_y;
        this.e_x = e_x;
        this.e_y = e_y;
    }


    @Override
    public void drawShape(){
        graphics = canvas.getGraphics2D();
        graphics.setColor(primary);
        int width = e_x - s_x;
        int height = e_y - s_y;
        int[] xPoints = new int[] {s_x,e_x,s_x};
        int[] yPoints = new int[] {s_y,e_y,e_y};

        if(shape.toString().equalsIgnoreCase("ellipse")) {
            graphics.fillOval(s_x, s_y, width, height);
        }else if(shape.toString().equalsIgnoreCase("rectangle")){
            graphics.fillRect(s_x,s_y,width,height);
        }else if(shape.toString().equalsIgnoreCase("triangle")){
            graphics.fillPolygon(xPoints,yPoints,3);
        }
    }

}
