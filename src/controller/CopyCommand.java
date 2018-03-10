package controller;

import model.Clipboard;
import model.SelectedShapes;
import model.Shape;
import model.interfaces.IShape;

public class CopyCommand implements ICommand, IUndoable{
    SelectedShapes selected;
    Clipboard clipboard;

    public CopyCommand(SelectedShapes selected, Clipboard clipboard){
        this.selected = selected;
        this.clipboard = clipboard;
    }


    @Override
    public void run(){
        if(!selected.isEmpty()){
        clipboard.push(selected.get(0));
        System.out.println("Copied to clipboard");
        System.out.println(clipboard.get(0).getShape());}
    }

    @Override
    public void undo() {
        clipboard.pop();
    }

    @Override
    public void redo() {
        clipboard.push(selected.get(0));
    }

    public Clipboard getList() {
        return clipboard;
    }
}
