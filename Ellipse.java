import java.awt.*;
import java.awt.geom.*;

public class Ellipse implements DrawingObject{
    
    private double x, y, w, h, rotation;
    private Color color;

    public Ellipse(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rotation = 0;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Ellipse2D.Double shape = new Ellipse2D.Double(x, y, w, h);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), x + (w/2),  y + (h/2)); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void adjustRotation(double rotation) {
        this.rotation += rotation;
    }
}
