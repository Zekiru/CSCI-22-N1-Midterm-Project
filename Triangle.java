import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject{
    
    private double x1, y1, x2, y2, x3, y3, rotation, xRotate, yRotate;
    private Color color;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.rotation = 0;

        this.xRotate = (((x1 < x2) ? x1: (x2 < x3) ? x2: x3) + ((x1 > x2) ? x1: (x2 > x3) ? x2: x3)) / 2;
        this.yRotate = (((y1 < y2) ? y1: (y2 < y3) ? y2: y3) + ((y1 > y2) ? y1: (y2 > y3) ? y2: y3)) / 2;

        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double shape = new Path2D.Double();

        shape.moveTo(x1, y1);
        shape.lineTo(x2, y2);
        shape.lineTo(x3, y3);
        
        shape.closePath();
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public double[] getPosition() {
        double[] position = {this.x1, this.y1};
        return position;
    }

    public void setPosition(double x, double y) {
        this.x2 += x - x1;
        this.y2 += y - y1;
        this.x3 += x - x1;
        this.y3 += y - y1;

        this.x1 = x;
        this.y1 = y;
    }

    public void setSize(double w, double h) {
        return;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x1 += x;
        this.y1 += y;
        this.x2 += x;
        this.y2 += y;
        this.x3 += x;
        this.y3 += y;
    }

    public void adjustRotation(double rotation) {
        this.xRotate = (((x1 < x2) ? x1: (x2 < x3) ? x2: x3) + ((x1 > x2) ? x1: (x2 > x3) ? x2: x3)) / 2;
        this.yRotate = (((y1 < y2) ? y1: (y2 < y3) ? y2: y3) + ((y1 > y2) ? y1: (y2 > y3) ? y2: y3)) / 2;
        this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        this.xRotate = (((x1 < x2) ? x1: (x2 < x3) ? x2: x3) + ((x1 > x2) ? x1: (x2 > x3) ? x2: x3)) / 2 + x;
        this.yRotate = (((y1 < y2) ? y1: (y2 < y3) ? y2: y3) + ((y1 > y2) ? y1: (y2 > y3) ? y2: y3)) / 2 + y;
        this.rotation += rotation;
    }

    public String getAttributes() {
        return String.format("Triangle(%f, %f, %f, %f, %f, %f, new Color(%d, %d, %d));\n", x1, y1, x2, y2, x3, y3, color.getRed(), color.getGreen(), color.getBlue());
    }
}
