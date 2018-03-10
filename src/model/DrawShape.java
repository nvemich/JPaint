package model;

import controller.ColorList;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShape {
    int start_x,start_y,end_x,end_y;
    PaintCanvas paint;
    Graphics2D graphics;
    ShapeType shape;
    ShapeShadingType shade;
    ColorList colorList;
    Color primaryColor, secondaryColor;
    OutlineShape outline;
    FilledInShape filled;
    OutlineAndFilledIn outfilled;
    ShapeList shapeList;
    Shape addToList;


    public DrawShape(PaintCanvas paint, ColorList colorlist, ShapeList shapeList, ShapeType shape, Color primary, Color secondary, ShapeShadingType shading,
                     int start_x, int start_y, int end_x, int end_y){
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
        this.paint = paint;
        this.shape = shape;
        this.primaryColor = primary;
        this.secondaryColor = secondary;
        this.shade = shading;
        this.colorList = colorlist;
        this.shapeList = shapeList;
    }


    public void draw(){
        graphics = paint.getGraphics2D();
        graphics.setColor(primaryColor);
        graphics.setColor(secondaryColor);
        addToList = new Shape(shape,start_x,start_y,end_x,end_y,primaryColor,secondaryColor,shade);
        shapeList.push(addToList);

            if(shade.toString().equalsIgnoreCase("outline")){
                outline = new OutlineShape(paint,shape,primaryColor,start_x,start_y,end_x,end_y);
                outline.drawShape();
            }else if(shade.toString().equalsIgnoreCase("FILLED_IN")){
                filled = new FilledInShape(paint,shape,primaryColor,start_x,start_y,end_x,end_y);
                filled.drawShape();
            }else if(shade.toString().equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
                outfilled = new OutlineAndFilledIn(paint, shape, primaryColor, secondaryColor, start_x, start_y, end_x, end_y);
                outfilled.drawShape();
            }



    }
}
