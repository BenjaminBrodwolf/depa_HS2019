package jdraw.figures;


import java.awt.*;

/**
 * Represent Oval in JDraw
 *
 * @author Benjamin
 */
public class Oval extends AbstractRectangularFigure{


    protected Oval(Point origin) {
        super(origin);
    }

    @Override
    public void draw(Graphics g) {
        Rectangle ellipse = getBounds();
        g.setColor(Color.BLACK);
        g.fillOval((int) ellipse.getX(), (int)ellipse.getY(),(int) ellipse.getWidth(), (int)ellipse.getHeight());
        g.setColor(Color.WHITE);
        g.fillOval((int) ellipse.getX()+1, (int)ellipse.getY()+1,(int) ellipse.getWidth()-2, (int)ellipse.getHeight()-2);
    }
}
