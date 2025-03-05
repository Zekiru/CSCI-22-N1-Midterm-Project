import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Cactus implements DrawingObject{

    private ArrayList<DrawingObject> cacti;
    
    public Cactus() {
         cacti = new ArrayList<DrawingObject>();
        //cactus1
        cacti.add(new Rectangle(93.000000, 293.000000, 30.000000, 65.000000, new Color(0, 128, 0)));
        cacti.add(new Circle(93.000000, 278.000000, 30.000000, new Color(0, 128, 0))); 
        //cactus2
        cacti.add(new Rectangle(113.000000, 317.000000, 21.000000, 50.000000, new Color(36, 73, 9)));
        cacti.add(new Circle(113.000000, 305.000000, 21.000000, new Color(36, 73, 9)));
        //cactus3
        cacti.add(new Ellipse(296.000000, 322.000000, 57.000000, 31.000000, new Color(0, 128, 0)));
        cacti.add(new Ellipse(316.000000, 330.000000, 17.000000, 7.000000, new Color(50, 98, 14)));
        //cactus4
        cacti.add(new Rectangle(688.000000, 296.000000, 29.000000, 85.000000, new Color(1, 107, 1)));
        cacti.add(new Rectangle(668.000000, 331.000000, 69.000000, 21.000000, new Color(1, 107, 1)));
        cacti.add(new Circle(655.000000, 331.000000, 21.000000, new Color(1, 107, 1)));
        cacti.add(new Circle(725.000000, 331.000000, 21.000000, new Color(1, 107, 1)));
        cacti.add(new Rectangle(655.000000, 322.000000, 17.000000, 17.000000, new Color(1, 107, 1)));
        cacti.add(new Rectangle(731.000000, 298.000000, 15.000000, 43.000000, new Color(1, 107, 1)));
        cacti.add(new Circle(655.000000, 315.000000, 17.000000, new Color(1, 107, 1)));
        cacti.add(new Circle(688.000000, 280.000000, 29.000000, new Color(1, 107, 1)));
        cacti.add(new Circle(731.000000, 292.000000, 15.000000, new Color(1, 107, 1)));
        //cactus 5
        cacti.add(new Rectangle(260.000000, 302.000000, 12.000000, 29.000000, new Color(25, 52, 1)));
        cacti.add(new Circle(260.000000, 295.000000, 12.000000, new Color(25, 52, 1)));

    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        for (DrawingObject c: cacti) {
            c.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void moveCactus(double speed) {
        for (DrawingObject c: cacti) {
            double y = c.getPosition()[1];
            c.adjustPosition(-speed, 0);

            if (c.getPosition()[0] <= -69) {
                c.setPosition(800, y);
            }
        }
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
        //
    }

    public void adjustPosition(double x, double y) {
        //
    }

    public void adjustRotation(double rotation) {
        //
    }
    
}

