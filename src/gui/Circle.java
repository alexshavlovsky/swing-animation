package gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Circle extends Point2D.Double implements Drawable {
    private final Color color;
    private final Stroke stroke;
    private final Shape shape;

    public Circle(double x, double y, double r, Color color, Stroke stroke) {
        setLocation(x, y);
        this.color = color;
        this.stroke = stroke;
        shape = new Ellipse2D.Double(x - r / 2, y - r / 2, r, r);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
        g.draw(shape);
    }
}
