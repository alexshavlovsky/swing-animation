import gui.AnimationWindow;
import gui.Circle;
import gui.Drawable;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class App {
    static private Stroke stroke = new BasicStroke(0.3f);

    public static void main(String[] args) {
        AffineTransform transform = new AffineTransform();
        transform.translate(-20, -20);
        transform.scale(25, 25);

        AnimationWindow.newInstance(w -> {
            double t = w.time;
            List<Drawable> drawables = new ArrayList<>();
            int l = 0;
            for (int y = 0; y < 40; y++)
                for (int x = 0; x < 60; x++) {
                    l++;
                    if (l / 100.0 > t) break;
                    double h = 0.3f * sin(-t / (3.0 + sin(t / 5.6)) + 0.3 * x * (1 + sin(y))) + 0.2f * cos(t + 0.3 * y);
                    Color col = Color.getHSBColor((float) h, 0.7f, 0.7f);
                    drawables.add(new Circle(
                            x + 0.8 * sin(t + 0.5 * y),
                            y + 0.8 * cos(t + 0.5 * x + y * sin(t * 0.1)),
                            1f + h / 1.8, col, stroke));
                }
            return drawables;
        }, new Dimension(1200, 900), transform);
    }
}
