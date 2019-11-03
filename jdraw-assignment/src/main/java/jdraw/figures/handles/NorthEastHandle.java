package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

public class NorthEastHandle implements FigureHandle {

    private Figure owner;
    private Point corner;

    public NorthEastHandle(Figure figure) {
        this.owner = figure;
    }

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public Point getLocation() {
        Point p = new Point((int) owner.getBounds().getWidth(), (int) owner.getBounds().getY() );
        return p;
    }

    @Override
    public void draw(Graphics g) {
        Point loc = getLocation();
        g.setColor(Color.WHITE);
        g.fillRect(loc.x -3, loc.y -3, 6, 6);
        g.setColor(Color.BLACK);
        g.fillRect(loc.x -3, loc.y -3, 6, 6);
    }

    @Override
    public boolean contains(int x, int y) {
        return owner.contains(x, y);
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
    }

    @Override
    public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
        Rectangle r = owner.getBounds();
        corner = new Point(r.x + r.width, r.y + r.height);
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
        owner.setBounds(new Point(x, y), corner);
    }

    @Override
    public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
        corner = null;
    }
}
