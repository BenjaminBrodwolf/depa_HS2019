package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractDragDrawTool extends AbstractDrawTool{

    private final DrawContext context;
    private Point anchor;
    private Figure figure;

    protected AbstractDragDrawTool(DrawContext context, String name, String icon) {
        super( name, icon );
        this.context = context;
    }

    @Override
    public void activate() {
        context.showStatusText(getName() + " Mode");
    }

    @Override
    public void deactivate() {
        context.showStatusText("");
    }

    protected abstract Figure createFigure(Point p);

    @Override
    public final void mouseDown(int x, int y, MouseEvent e) {
        if (figure != null) {
            throw new IllegalStateException();
        }
        anchor = new Point(x, y);
        figure = createFigure(anchor);
        context.getModel().addFigure(figure);
    }

    @Override
    public final void mouseDrag(int x, int y, MouseEvent e) {
        figure.setBounds(anchor, new Point(x, y));
    }

    @Override
    public final void mouseUp(int x, int y, MouseEvent e) {
        Rectangle r = figure.getBounds();
        if (r.width== 0 && r.height== 0) {
            context.getModel().removeFigure(figure);
        }
        anchor = null;
        figure = null;
    }

}
