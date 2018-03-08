package model;

import controller.DrawShapeCommand;
import controller.ICommand;
import model.interfaces.IApplicationState;

import java.io.IOException;


public class ProcessPaint  {
    StartAndEndPointMode mode;
    ShapeType shape;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ICommand command = null;
    int start_x,start_y,end_x,end_y;


    public ProcessPaint(int start_x, int start_y, int end_x, int end_y) {
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;

    }

//    public void run() throws IOException {
//
//
//       switch (mode.toString().toLowerCase()){
//           case "draw":
//               command = new DrawShapeCommand(shape, start_x, start_y, end_x, end_y);
//                break;
//           case "ellipse":
//               command = new DrawShapeCommand(shape, start_x, start_y, end_x, end_y);
//               break;
//       }
//
//       command.run();
//    }


}
