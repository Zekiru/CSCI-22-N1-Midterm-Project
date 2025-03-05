import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Car implements DrawingObject{

    private ArrayList<DrawingObject> parts;
    private Color color;
    private DrawingObject fronttireSpin, reartireSpin;

    public Car(Color  c) {
        this.color = c;
        parts = new ArrayList<DrawingObject>();
        //body
        parts.add(new Rectangle(241.000000, 367.000000, 353.000000, 90.000000, color));
        parts.add(new Rectangle(306.000000, 292.000000, 187.000000, 80.000000, color));
        parts.add(new Triangle(306.000000, 291.000000, 333.000000, 367.000000, 279.000000, 367.000000, color));
        parts.add(new Triangle(493.000000, 292.000000, 557.000000, 367.000000, 429.000000, 367.000000, color));
        parts.add(new Ellipse(224.000000, 367.000000, 33.000000, 90.000000, color));
        parts.add(new Ellipse(557.000000, 367.000000, 72.000000, 90.000000, color));

        //glass window
        parts.add(new Rectangle(315.000000, 302.000000, 91.000000, 65.000000, new Color(217, 223, 219))); 
        parts.add(new Rectangle(417.000000, 302.000000, 72.000000, 65.000000, new Color(217, 223, 219)));
        parts.add(new Triangle(315.000000, 302.000000, 338.000000, 367.000000, 292.000000, 367.000000, new Color(217, 223, 219)));
        parts.add(new Triangle(489.000000, 302.000000, 544.000000, 367.000000, 434.000000, 367.000000, new Color(217, 223, 219)));

        //door handle
        parts.add(new Rectangle(292.000000, 375.000000, 39.000000, 9.000000, new Color(217, 223, 219)));
        parts.add(new Rectangle(417.000000, 373.000000, 39.000000, 9.000000, new Color(217, 223, 219)));

        //lights
        parts.add(new Ellipse(233.000000, 389.000000, 9.000000, 22.000000, new Color(196, 57, 29)));//
        parts.add(new Rectangle(237.000000, 389.000000, 18.000000, 22.000000, new Color(196, 57, 29)));//
        parts.add(new Ellipse(577.000000, 383.000000, 37.000000, 17.000000, new Color(243, 234, 192)));//

        //wheels
        parts.add(new Circle(275.000000, 414.000000, 76.000000, new Color(37, 37, 37)));
        parts.add(new Circle(288.000000, 427.000000, 50.000000, new Color(123, 123, 123)));      
        parts.add(new Circle(294.000000, 433.000000, 38.000000, new Color(37, 37, 37)));
        parts.add(new Circle(306.000000, 446.000000, 13.000000, new Color(123, 123, 123)));  
        
        parts.add(new Circle(495.000000, 414.000000, 76.000000, new Color(37, 37, 37)));
        parts.add(new Circle(508.000000, 427.000000, 50.000000, new Color(123, 123, 123)));      
        parts.add(new Circle(514.000000, 433.000000, 38.000000, new Color(37, 37, 37)));
        parts.add(new Circle(526.000000, 446.000000, 13.000000, new Color(123, 123, 123)));

        reartireSpin = new Square(300.000000, 439.000000, 26.000000, new Color(123, 123, 123));
        parts.add(reartireSpin);
        parts.add(new Circle(298.000000, 438.000000, 29.000000, new Color(37, 37, 37)));
        parts.add(new Circle(303.000000, 443.000000, 20.000000, new Color(123, 123, 123)));

        fronttireSpin = new Square(520.000000, 439.000000, 26.000000, new Color(123, 123, 123));
        parts.add(fronttireSpin);
        parts.add(new Circle(518.000000, 438.000000, 29.000000, new Color(37, 37, 37)));
        parts.add(new Circle(523.000000, 443.000000, 20.000000, new Color(123, 123, 123)));
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        for (DrawingObject part: parts) {
            part.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void spinTires(double speed) {
        fronttireSpin.adjustRotation(speed);
        reartireSpin.adjustRotation(speed);
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public double[] getPosition() {
        return null;
    }

    public void setPosition(double x, double y) {
        //
    }

    public void setSize(double w, double h) {
        //
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        //
    }

    public void adjustRotation(double rotation) {
        //
    }

    public void adjustRotation(double rotation, double x, double y) {
        //
    }

    public String getAttributes() {
        return "Car";
    }
}
