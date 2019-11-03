package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractFigure implements Figure {

    List<FigureListener> figureListeners = new CopyOnWriteArrayList<>();

    protected final void propagateFigureEvent(){
        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        if (listener != null && !figureListeners.contains(listener)) {
            figureListeners.add(listener);
        }
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        figureListeners.remove(listener);
    }


    @Override
    public Figure clone() {
        return null;
    }

    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

}
