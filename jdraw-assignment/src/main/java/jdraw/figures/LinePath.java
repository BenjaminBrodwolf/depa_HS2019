package jdraw.figures;

import jdraw.framework.FigureEvent;

import java.awt.*;
import java.awt.geom.Path2D;

public class LinePath extends AbstractFigure {

    private final Path2D path;


    public LinePath(Point p) {
        this.path = new Path2D.Double();
        path.moveTo(p.getX(), p.getY());

    }

    @Override
    public void draw(Graphics g) {
//        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
//        g2.setStroke(new BasicStroke(5));
        g2.draw(path);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        path.lineTo(origin.getX(), origin.getY());

        path.moveTo(corner.getX(), corner.getY());
        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public void move(int dx, int dy) {
        path.moveTo(  dx,  dy);
        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }

    @Override
    public boolean contains(int x, int y) {
        return path.contains(x,y);
    }



    @Override
    public Rectangle getBounds() {
        return path.getBounds();
    }
}
