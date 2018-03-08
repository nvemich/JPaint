package view;

import model.ProcessPaint;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

//mouse handler to handle all my mouse events, like press and release
public class mouseHandler extends MouseAdapter implements MouseListener {

    int start_x, start_y, end_x, end_y;
    ProcessPaint process;


    @Override
    public void mousePressed(MouseEvent e) {
        this.start_x = e.getX();
        this.start_y = e.getY();
        System.out.println(start_x + "," + start_y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.end_x = e.getX();
        this.end_y = e.getY();
        System.out.println(end_x + "," + end_y);

        process = new ProcessPaint(start_x,start_y,end_x,end_y);

        try {
            process.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }



    public int getStart_x() {
        return this.start_x;
    }

    public int getStart_y() {
        return this.start_y;
    }

    public int getEnd_x() {
        return this.end_x;
    }

    public int getEnd_y() {
        return this.end_y;
    }

 }