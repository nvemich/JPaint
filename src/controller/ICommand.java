package controller;

import model.interfaces.IShape;

import java.io.IOException;

public interface ICommand {
    void run() throws IOException;
}
