package view.gui;

import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseListener;


import view.mouseHandler;

public class PaintCanvas extends JComponent implements IPaintCanvas {

    public PaintCanvas(){

        mouseHandler mouse = new mouseHandler();
        addMouseListener(mouse);


    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
