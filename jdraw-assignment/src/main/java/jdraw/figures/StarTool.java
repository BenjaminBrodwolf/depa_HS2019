package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;

public class StarTool extends AbstractDragDrawTool {

    public StarTool(DrawContext context,  String name, String icon) {
        super(context, name, icon);
    }

    @Override
    protected Figure createFigure(Point p) {
        return new Star(p);
    }
}
