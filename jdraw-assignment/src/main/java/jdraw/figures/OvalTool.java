/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Christoph Denzler
 */
public class OvalTool extends AbstractDragDrawTool {


	public OvalTool(DrawContext context, String name, String icon) {
		super(context, name, icon);

	}

	@Override
	protected Figure createFigure(Point p) {
		return new Oval(p);
	}


}
