import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject{
    
    private double x, y, size, rotation;
    private Color color;

    public Square(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = 0;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Rectangle2D.Double shape = new Rectangle2D.Double(x, y, size, size);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), x + (size/2),  y + (size/2)); 

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
        this.size = (w > h) ? w: h;
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
