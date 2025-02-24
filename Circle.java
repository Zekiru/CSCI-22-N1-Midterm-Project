import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject{
    
    private double x, y, size, rotation;
    private Color color;

    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = 0;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Ellipse2D.Double shape = new Ellipse2D.Double(x, y, size, size);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), x + (size/2),  y + (size/2)); 

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
