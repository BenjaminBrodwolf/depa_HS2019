/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;


import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;


public class RectTool extends AbstractDragDrawTool {


	public RectTool(DrawContext context, String name, String icon) {
		super(context, name, icon);
	}

	@Override
	protected Figure createFigure(Point p) {
		return new Rect(p);
	}


}
