package model;

import controller.ICommand;

import java.io.IOException;

public class ProcessPaint {
    ICommand command = null;
    int start_x,start_y,end_x,end_y;
    public ProcessPaint(int start_x, int start_y, int end_x,int end_y){
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;

//        command = new DrawShapeCommand(ShapeType.RECTANGLE,start_x,start_y,end_x,end_y);
//        try {
//            command.run();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}

