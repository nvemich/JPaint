package controller;

import model.ShapeType;
import model.interfaces.IShape;
import view.gui.PaintCanvas;
import view.mouseHandler;

import java.awt.*;


public class DrawShapeCommand extends PaintCanvas implements ICommand {
    ShapeType shape;
    public int start_x, start_y, end_x, end_y;

    public DrawShapeCommand(ShapeType shape, int s_x, int s_y, int e_x, int e_y){
        this.shape = shape;
        this.start_x = s_x;
        this.start_y = s_y;
        this.end_x = e_x;
        this.end_y = e_y;
    }

    public Graphics2D getGraphics2D() { return (Graphics2D)getGraphics(); }

    @Override
    public void run(){
        Graphics2D graphics = getGraphics2D();
        int width, height;

        height = end_y - start_y;
        width = end_x - start_x;


        if(shape.toString().toLowerCase().equals("rectangle")){
            graphics.drawRect(start_x, start_y, width, height);
        }
        else if(shape.toString().toLowerCase().equals("ellipse")){
            graphics.drawOval(start_x,start_y,height,width);
        }
        else if(shape.toString().toLowerCase().equals("triangle")){
            //graphics.drawPolygon();
        }


    }



}
