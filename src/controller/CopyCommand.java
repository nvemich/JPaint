package controller;

import model.Clipboard;
import model.SelectedShapes;
import model.Shape;
import model.interfaces.IShape;

public class CopyCommand implements ICommand{
    Clipboard clipboard;

    public CopyCommand(Clipboard clipboard){
        this.clipboard = clipboard;
    }


    @Override
    public void run(){
        if(!SelectedShapes.isEmpty()){
        for(int i = 0; i < SelectedShapes.getSize(); i++){
            clipboard.add(SelectedShapes.getShape(i));
        }
    }


}
}
