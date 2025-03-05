import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject{
    
    private double x, y, size, rotation, xRotate, yRotate;
    private Color color;

    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = 0;
        this.xRotate = x + (size/2);
        this.yRotate = y + (size/2);
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Ellipse2D.Double shape = new Ellipse2D.Double(x, y, size, size);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    public double[] getPosition() {
        double[] position = {this.x, this.y};
        return position;
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
        this.xRotate = x + (size/2);
        this.yRotate = y + (size/2);
        this.rotation += rotation;
    }
}
