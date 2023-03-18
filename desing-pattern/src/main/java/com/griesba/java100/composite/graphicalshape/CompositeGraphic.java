package com.griesba.java100.composite.graphicalshape;


import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void print();
}

class Eclipse implements Graphic {

    @Override
    public void print() {
        System.out.println("Eclipse");
    }
}

public class CompositeGraphic implements Graphic {

    private List<Graphic> graphicList = new ArrayList<>();

    @Override
    public void print() {
        for (Graphic graphic:
             graphicList) {
            graphic.print();
        }
    }

    public void add(Graphic graphic) {
        graphicList.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphicList.remove(graphic);
    }
}

class Programme {
    public static void main(String[] args) {
        Eclipse eclipse1 = new Eclipse();
        Eclipse eclipse2 = new Eclipse();
        Eclipse eclipse3 = new Eclipse();
        Eclipse eclipse4 = new Eclipse();

        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        graphic1.add(eclipse1);
        graphic1.add(eclipse2);
        graphic1.add(eclipse3);

        graphic2.add(eclipse4);

        graphic.add(graphic2);
        graphic.add(graphic1);

        graphic.print();
    }
}
