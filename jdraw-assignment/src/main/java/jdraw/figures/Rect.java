
package jdraw.figures;

import jdraw.figures.handles.NorthWestHandle;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Rect extends AbstractRectangularFigure  {
    private static final long serialVersionUID = 9120181044386552132L;

    public Rect(Point origin) {
        super(origin);
    }

    @Override
    public void draw(Graphics g) {
        Rectangle rectangle = getBounds();
        g.setColor(Color.WHITE);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.setColor(Color.BLACK);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public List<FigureHandle> getHandles(){
        List<FigureHandle> handle = new LinkedList<>();
        handle.add(new NorthWestHandle(this));
        return handle;
    }



}
