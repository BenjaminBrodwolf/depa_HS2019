package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;

public class LinePathTool extends AbstractDragDrawTool {


    public LinePathTool(DrawContext context, String name, String icon) {
        super(context, name , icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new LinePath(p);
    }
}
