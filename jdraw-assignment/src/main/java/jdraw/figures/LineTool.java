package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;

public class LineTool extends  AbstractDragDrawTool{


    public LineTool(DrawContext context, String name, String icon) {
        super(context, name , icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new Line(p);
    }


}
