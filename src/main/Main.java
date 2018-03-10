package main;

import controller.ColorList;
import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import view.mouseHandler;

import java.awt.event.MouseAdapter;


public class Main {
    public static void main(String[] args){
        ShapeList shapes = new ShapeList();
        ColorList colorList = new ColorList();
        PaintCanvas paintCanvas = new PaintCanvas();
        mouseHandler mouse = new mouseHandler(paintCanvas, shapes);
        paintCanvas.addMouseListener(mouse);
        IGuiWindow uiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(uiWindow);


 //       IGuiWindow guiWindow = new GuiWindow(new PaintCanvas(),shapes);

        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        mouse.setStates(appState,colorList);








    }
}
