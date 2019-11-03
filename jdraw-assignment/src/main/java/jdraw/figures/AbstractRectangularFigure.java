package jdraw.figures;

import jdraw.framework.FigureEvent;

import java.awt.*;

public abstract class AbstractRectangularFigure extends AbstractFigure{

    private final Rectangle rectangle;

    protected AbstractRectangularFigure(Point origin) {
        rectangle = new Rectangle(origin);
    }


    @Override
    public void setBounds(Point origin, Point corner) {
        rectangle.setFrameFromDiagonal(origin, corner);
        System.out.println("SET BOUNDS");
//        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
        propagateFigureEvent();
    }

    @Override
    public void move(int dx, int dy) {
        rectangle.setLocation(rectangle.x + dx, rectangle.y + dy);

        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public boolean contains(int x, int y) {
        return rectangle.contains(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(rectangle);
    }

}
