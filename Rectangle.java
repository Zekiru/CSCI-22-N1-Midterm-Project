import java.awt.*;
import java.awt.geom.*;

public class Rectangle implements DrawingObject{
    
    private double x, y, w, h, rotation;
    private Color color;

    public Rectangle(double x, double y, double w, double h, Color color) {
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
        Rectangle2D.Double shape = new Rectangle2D.Double(x, y, w, h);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), x + (w/2),  y + (h/2)); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    @Override
    public DrawingObject getShape() {
        return this;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void translateX(double distance) {
        x += distance;
    }

    @Override
    public void translateY(double distance) {
        y += distance;
    }

    @Override
    public void translateRotation(double rotation) {
        this.rotation += rotation;
    }
}
