import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Car implements DrawingObject{

    private ArrayList<DrawingObject> parts;

    private Color color;

    private DrawingObject fronttireSpin, reartireSpin;

    public Car(Color color) {
        this.color = color;

        parts = new ArrayList<DrawingObject>();

        parts.add(new Rectangle(143.000000, 315.000000, 340.000000, 87.000000, color));
        parts.add(new Ellipse(91.000000, 316.000000, 111.000000, 86.000000, color));
        parts.add(new Ellipse(436.000000, 315.000000, 86.000000, 86.000000, color));
        parts.add(new Line(136.000000, 337.000000, 184.000000, 236.000000, 20.000000, color));
        parts.add(new Line(180.000000, 243.000000, 386.000000, 241.000000, 20.000000, color));
        parts.add(new Line(377.000000, 242.000000, 427.000000, 329.000000, 20.000000, color));
        parts.add(new Line(222.000000, 248.000000, 221.000000, 341.000000, 20.000000, color));
        parts.add(new Line(309.000000, 245.000000, 311.000000, 344.000000, 20.000000, color));
        parts.add(new Rectangle(461.000000, 329.000000, 48.000000, 16.000000, new Color(200, 200, 200)));
        parts.add(new Ellipse(456.000000, 328.000000, 15.000000, 17.000000, new Color(200, 200, 200)));
        parts.add(new Ellipse(500.000000, 329.000000, 15.000000, 16.000000, new Color(200, 200, 200)));
        parts.add(new Rectangle(106.000000, 333.000000, 22.000000, 23.000000, new Color(140, 0, 0)));
        parts.add(new Ellipse(99.000000, 335.000000, 15.000000, 20.000000, new Color(140, 0, 0)));
        parts.add(new Line(323.000000, 336.000000, 358.000000, 336.000000, 10.000000, new Color(200, 200, 200)));
        parts.add(new Line(235.000000, 335.000000, 267.000000, 335.000000, 10.000000, new Color(200, 200, 200)));

        parts.add(new Circle(396.000000, 356.000000, 94.000000, new Color(0, 0, 0)));
        parts.add(new Circle(124.000000, 356.000000, 94.000000, new Color(0, 0, 0)));

        parts.add(new Circle(411.000000, 371.000000, 64.000000, new Color(60, 62, 64)));
        parts.add(new Circle(139.000000, 371.000000, 64.000000, new Color(60, 62, 64)));

        // parts.add(fronttire);
        // parts.add(reartire);
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        


        for (DrawingObject part: parts) {
            part.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public void setPosition(double x, double y) {
        // this.x = x;
        // this.y = y;
    }

    public void setSize(double w, double h) {
        return;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        // this.x += x;
        // this.y += y;
    }

    public void adjustRotation(double rotation) {
        // this.xRotate = x + (size/2);
        // this.yRotate = y + (size*Math.sqrt(3)/2);
        // this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        // this.xRotate = this.x + (size/2) + x;
        // this.yRotate = this.y + (size/2) + y;
        // this.rotation += rotation;
    }

    public String getAttributes() {
        // return String.format("Hexagon(%f, %f, %f, new Color(%d, %d, %d));\n", x, y, size, color.getRed(), color.getGreen(), color.getBlue());
        return null;
    }
}
