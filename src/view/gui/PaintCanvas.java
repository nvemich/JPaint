package view.gui;
import view.interfaces.IPaintCanvas;
import view.mouseHandler;
import javax.swing.JComponent;
import java.awt.*;


public class PaintCanvas extends JComponent implements IPaintCanvas {

    public PaintCanvas(){
//        mouseHandler mouse = new mouseHandler(this);
//        addMouseListener(mouse);


    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }


}
