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

    @Override
    public DrawingObject getShape() {
        return this;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x1 = x;
        this.y1 = y;
        this.x2 += x - x1;
        this.y2 += y - y1;
    }

    @Override
    public void translateX(double distance) {
        x1 += distance;
        x2 += distance;
    }

    @Override
    public void translateY(double distance) {
        y1 += distance;
        y2 += distance;
    }

    @Override
    public void translateRotation(double rotation) {
        this.rotation += rotation;
    }
}
