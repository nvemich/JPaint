package controller;

import java.awt.*;

public class ColorList {
    Color color;
    ColorAdapater colorGen;
    ColorAdapater[] colorList = {
            new ColorAdapater(Color.black, "Black"),
            new ColorAdapater(Color.blue, "Blue"),
            new ColorAdapater(Color.cyan, "Cyan"),
            new ColorAdapater(Color.darkGray, "Dark Gray"),
            new ColorAdapater(Color.gray, "Gray"),
            new ColorAdapater(Color.green, "Green"),
            new ColorAdapater(Color.lightGray, "Light Gray"),
            new ColorAdapater(Color.magenta, "Magenta"),
            new ColorAdapater(Color.orange, "Orange"),
            new ColorAdapater(Color.pink, "Pink"),
            new ColorAdapater(Color.red, "Red"),
            new ColorAdapater(Color.white, "White"),
            new ColorAdapater(Color.yellow, "Yellow")
};

    public Color getColor(){
        return color;
    }



    public Color findColor(String colorName){
        for(int i =0; i<colorList.length; i++){
           if(colorList[i].friendlyColor.equalsIgnoreCase(colorName)){
               return colorList[i].getColor();
           }
        }
        return Color.BLACK;
    }



}
