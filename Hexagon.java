import java.awt.*;
import java.awt.geom.*;

public class Hexagon implements DrawingObject{
    
    private double x, y, size, rotation, xRotate, yRotate;
    private Color color;

    public Hexagon(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = 0;

        this.xRotate = x + (size/2);
        this.yRotate = y + (size*Math.sqrt(3)/2);

        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double shape = new Path2D.Double();

        shape.moveTo(x, y);
        shape.lineTo(x - size/2, y + size*Math.sqrt(3)/2);
        shape.lineTo(x, y + size*Math.sqrt(3));
        shape.lineTo(x + size, y + size*Math.sqrt(3));
        shape.lineTo(x + size*3/2, y + size*Math.sqrt(3)/2);
        shape.lineTo(x + size, y);
        
        shape.closePath();
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

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
        return;
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
        this.yRotate = y + (size*Math.sqrt(3)/2);
        this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        this.xRotate = this.x + (size/2) + x;
        this.yRotate = this.y + (size/2) + y;
        this.rotation += rotation;
    }

    public String getAttributes() {
        return String.format("Hexagon(%f, %f, %f, new Color(%d, %d, %d));\n", x, y, size, color.getRed(), color.getGreen(), color.getBlue());
    }
}
