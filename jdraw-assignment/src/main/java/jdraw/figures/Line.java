package jdraw.figures;

import jdraw.framework.FigureEvent;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends AbstractFigure {

    private final Line2D line;

    public Line(Point p) {
        this.line = new Line2D.Double(p.getX(), p.getY() ,p.getX(), p.getY());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        line.setLine(origin, corner);
        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public void move(int dx, int dy) {
        line.setLine((int) line.getX1() + dx, (int) line.getY1() + dy, (int) line.getX2() + dx, (int) line.getY2() + dy);
        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public boolean contains(int x, int y) {
        return line.contains(x, y);
    }


    @Override
    public Rectangle getBounds() {
        return line.getBounds();
    }
}
