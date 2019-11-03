/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 *
 * @author TODO add your name here
 */
public class StdDrawModel implements DrawModel, FigureListener {

    List<Figure> figures = new ArrayList<>(); // alle Figuren in einem DrawModel
    List<DrawModelListener> drawModelListeners = new ArrayList<>(); // DrawMode = ZeichnigsFenster (Listener/Observer)

    @Override
    public void addFigure(Figure f) {
        System.out.println("StdDrawModel.addFigure");

        if (null == f || figures.contains(f)) {
            return;
        }

        this.figures.add(f);
        f.addFigureListener(this);

        notifies(f, DrawModelEvent.Type.FIGURE_ADDED);
    }

    @Override
    public Stream<Figure> getFigures() {
        System.out.println("StdDrawModel.getFigures");
        return figures.stream(); // Only guarantees, that the application starts -- has to be replaced !!!
    }

    @Override
    public void removeFigure(Figure f) {
        System.out.println("StdDrawModel.removeFigure");

        if (this.figures.remove(f)) {
            f.removeFigureListener(this);

            DrawModelEvent dme = new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED);
            drawModelListeners.forEach(l -> l.modelChanged(dme));
        }
    }

    @Override
    public void addModelChangeListener(DrawModelListener listener) {
        System.out.println("StdDrawModel.addModelChangeListener - " + listener);
        this.drawModelListeners.add(listener);
    }

    @Override
    public void removeModelChangeListener(DrawModelListener listener) {
        System.out.println("StdDrawModel.removeModelChangeListener ");
        this.drawModelListeners.remove(listener);

    }

    /**
     * The draw command handler. Initialized here with a dummy implementation.
     */
    // TODO initialize with your implementation of the undo/redo-assignment.
    private DrawCommandHandler handler = new EmptyDrawCommandHandler();

    /**
     * Retrieve the draw command handler in use.
     *
     * @return the draw command handler.
     */
    @Override
    public DrawCommandHandler getDrawCommandHandler() {
        return handler;
    }

    @Override
    public void setFigureIndex(Figure f, int index) {
        System.out.println("StdDrawModel.setFigureIndex");

        if (index < 0 || index >= figures.size()) throw new IndexOutOfBoundsException();

        int pos = figures.indexOf(f);
        if (pos < 0) throw new IllegalArgumentException();

        figures.remove(f);
        figures.add(index, f);

        notifies(null, DrawModelEvent.Type.DRAWING_CHANGED);

    }

    @Override
    public void removeAllFigures() {
        System.out.println("StdDrawModel.removeAllFigures ");

        this.figures.forEach(f -> f.removeFigureListener(this));

        notifies(null, DrawModelEvent.Type.DRAWING_CLEARED);

    }

    @Override
    public void figureChanged(FigureEvent e) {
        System.out.println("FIGURE CHANGED");
        notifies(e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED);
    }

    private void notifies(Figure f, DrawModelEvent.Type type) {
        DrawModelEvent drawModelEvent = new DrawModelEvent(this, f, type);
        drawModelListeners.forEach(l -> l.modelChanged(drawModelEvent));
    }
}
