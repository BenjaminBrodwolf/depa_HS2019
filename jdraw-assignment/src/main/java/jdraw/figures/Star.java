package jdraw.figures;

import jdraw.framework.FigureEvent;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star extends AbstractFigure {

    private final GeneralPath star;
    int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Star(Point p) {
        this.star = new GeneralPath();
        this.x = (int) p.getX();
        this.y = (int) p.getY();
    }


    @Override
    public void draw(Graphics g) {
        int xPoints[] = {9, 15, 0, 18, 3};
        int yPoints[] = {0, 18, 6, 6, 18};

        Graphics2D g2d = (Graphics2D) g;
//        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();

        g2d.setColor(Color.BLACK);
        g2d.fill(star);
    }

    @Override
    public void setBounds(Point origin, Point corner) {
//        star.transform();
//            setX((int)origin.getX());
//        setY((int)origin.getY());
//        figureListeners.forEach(l -> l.figureChanged(new FigureEvent(this)));

    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public boolean contains(int x, int y) {
        return star.contains(x,y);
    }


    @Override
    public Rectangle getBounds() {
        return star.getBounds();
    }


}

