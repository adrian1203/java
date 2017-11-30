package lab6.kształty;

import lab3.ex2.Shape;

import java.util.LinkedList;

public class List {
    public LinkedList<Shape> lista;

    List() {
        lista = new LinkedList<Shape>();
    }

    public void add(Shape tmp) {
        lista.add(tmp);
    }
}
