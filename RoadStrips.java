import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class RoadStrips implements DrawingObject{

    private ArrayList<DrawingObject> roadStrips;
    // private double speed;
    

    public RoadStrips() {
        roadStrips = new ArrayList<DrawingObject>();

        roadStrips.add(new Rectangle(26.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245)));
        roadStrips.add(new Triangle(26.000000, 511.000000, 42.000000, 545.000000, 10.000000, 545.000000, new Color(123, 123, 123)));
        roadStrips.add(new Triangle(178.000000, 511.000000, 194.000000, 545.000000, 162.000000, 545.000000, new Color(245, 243, 245)));
        
        roadStrips.add(new Rectangle(326.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245)));
        roadStrips.add(new Triangle(326.000000, 511.000000, 342.000000, 545.000000, 310.000000, 545.000000, new Color(123, 123, 123)));
        roadStrips.add(new Triangle(478.000000, 511.000000, 494.000000, 545.000000, 462.000000, 545.000000, new Color(245, 243, 245)));

        roadStrips.add(new Rectangle(626.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245)));
        roadStrips.add(new Triangle(626.000000, 511.000000, 642.000000, 545.000000, 610.000000, 545.000000, new Color(123, 123, 123)));
        roadStrips.add(new Triangle(778.000000, 511.000000, 794.000000, 545.000000, 762.000000, 545.000000, new Color(245, 243, 245)));
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        for (DrawingObject roadStrip: roadStrips) {
            roadStrip.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void moveStrips(double speed) {
        for (DrawingObject roadStrip: roadStrips) {
            roadStrip.adjustPosition(-speed, 0);

            if (roadStrip.getPosition()[0] <= -175) {
                roadStrip.setPosition(800, 511);
            }
        }
    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public String getAttributes() {
        return "RoadStrips";
    }
    public double[] getPosition() {
        return null;
    }

    @Override
    public void setPosition(double x, double y) {
        //
    }

    @Override
    public void setSize(double w, double h) {
        //
    }

    @Override
    public void setColor(Color c) {
        //
    }

    @Override
    public void adjustPosition(double x, double y) {
        //
    }

    @Override
    public void adjustRotation(double rotation) {
        //
    }

    @Override
    public void adjustRotation(double rotation, double x, double y) {
        //
    }
    
}
