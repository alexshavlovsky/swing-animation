package gui;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Line2D.Double implements Drawable {
    private final Color color;
    private final Stroke stroke;

    public Line(double x1, double y1, double x2, double y2, Color color, Stroke stroke) {
        super(x1, y1, x2, y2);
        this.color = color;
        this.stroke = stroke;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
        g.draw(this);
    }
}
