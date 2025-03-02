import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class RoadStrips implements DrawingObject{

    private ArrayList<DrawingObject> roadStrips;
    // private double speed;
    

    public RoadStrips() {
        roadStrips = new ArrayList<DrawingObject>();
        // this.speed = speed;

        roadStrips.add(new Rectangle(700, 471.000000, 100, 32.000000, new Color(180, 180, 180)));

        roadStrips.add(new Rectangle(500, 471.000000, 100, 32.000000, new Color(180, 180, 180)));

        roadStrips.add(new Rectangle(300, 471.000000, 100, 32.000000, new Color(180, 180, 180)));

        roadStrips.add(new Rectangle(100, 471.000000, 100, 32.000000, new Color(180, 180, 180)));

        roadStrips.add(new Rectangle(-100, 471.000000, 100, 32.000000, new Color(180, 180, 180)));
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

            if (roadStrip.getPosition()[0] <= -182) {
                roadStrip.setPosition(800, 471);
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
