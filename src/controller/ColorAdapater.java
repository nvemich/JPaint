package controller;

import model.ShapeColor;

import java.awt.*;

public class ColorAdapater {
    Color color;
    String friendlyColor;


    public ColorAdapater(Color color, String friendlyColor){
        this.color = color;
        this.friendlyColor = friendlyColor;
    }

    @Override
    public String toString(){
        return friendlyColor;
    }


    public Color getColor(){
        return  this.color;
    }



}
