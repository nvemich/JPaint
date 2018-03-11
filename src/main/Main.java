package main;

import controller.ColorList;
import controller.CommandHistory;
import controller.IJPaintController;
import controller.JPaintController;
import model.SelectedShapes;
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
        CommandHistory cmds = new CommandHistory();
        ColorList colorList = new ColorList();
 //       SelectedShapes selected = new SelectedShapes();
        PaintCanvas paintCanvas = new PaintCanvas();
        mouseHandler mouse = new mouseHandler(paintCanvas, shapes);
        paintCanvas.addMouseListener(mouse);
        IGuiWindow uiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(uiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState,mouse);
        controller.setup();
        mouse.setStates(appState,colorList,cmds);








    }
}
