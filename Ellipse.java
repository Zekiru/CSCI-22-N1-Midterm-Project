import java.awt.*;
import java.awt.geom.*;

public class Ellipse implements DrawingObject{
    
    private double x, y, w, h, rotation, xRotate, yRotate;
    private Color color;

    public Ellipse(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rotation = 0;
        this.xRotate = x + (w/2);
        this.yRotate = y + (h/2);
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Ellipse2D.Double shape = new Ellipse2D.Double(x, y, w, h);
        
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
        this.xRotate = x + (w/2);
        this.yRotate = y + (h/2);
        this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        this.xRotate = this.x + (this.w/2) + x;
        this.yRotate = this.y + (this.h/2) + y;
        this.rotation += rotation;
    }
}
