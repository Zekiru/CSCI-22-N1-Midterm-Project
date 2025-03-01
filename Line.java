import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject{
    
    private double x1, y1, x2, y2, size, rotation;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, double size, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.size = size;
        this.rotation = 0;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double line = new Path2D.Double();
        double rise = y2 - y1;
        double run = x2 - x1;
        line.moveTo(x1, y1);
        line.lineTo(x2, y2);
        line.lineTo(x2 + size * (rise / (rise + run)), y2 - size * (run / (rise + run)));
        line.lineTo(x1 + size * (rise / (rise + run)), y1 - size * (run / (rise + run)));
        line.closePath();
        
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), (x1 + x2) / 2 + (size/2),  (y1 + y2) / 2 + (size/2)); 

        g2d.fill(line);
        g2d.setTransform(reset);
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public void setPosition(double x, double y) { 
        this.x2 += x - x1;
        this.y2 += y - y1;
        this.x1 = x;
        this.y1 = y;
    }

    public void setSize(double w, double h) {
        this.size = (w > h) ? w: h;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x1 += x;
        this.y1 += y;
        this.x2 += x;
        this.y2 += y;
    }

    public void adjustRotation(double rotation) {
        this.rotation += rotation;
    }
}
