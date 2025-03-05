/**
    This class is a composite shape that draws multiple road strips for the 
    background of the canvas. The road strips can move to the left depending 
    on the speed given to it.
    @author Kristin Faith Palencia (234746), Ezekiel Villasurda (236689)
    @version 5 March 2025
    We have not discussed the Java language code in our program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.
    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
**/

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class RoadStrips implements DrawingObject{

    private ArrayList<DrawingObject[]> roadStrips;
    // private double speed;
    

    public RoadStrips() {
        roadStrips = new ArrayList<DrawingObject[]>();

        DrawingObject[] roadstrip1 = new DrawingObject[3];
        DrawingObject[] roadstrip2 = new DrawingObject[3];
        DrawingObject[] roadstrip3 = new DrawingObject[3];

        roadstrip1[0] = new Rectangle(26.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245));
        roadstrip1[1] = new Triangle(26.000000, 511.000000, 42.000000, 545.000000, 10.000000, 545.000000, new Color(123, 123, 123));
        roadstrip1[2] = new Triangle(178.000000, 511.000000, 194.000000, 545.000000, 162.000000, 545.000000, new Color(245, 243, 245));

        roadStrips.add(roadstrip1);

        roadstrip2[0] = new Rectangle(326.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245));
        roadstrip2[1] = new Triangle(326.000000, 511.000000, 342.000000, 545.000000, 310.000000, 545.000000, new Color(123, 123, 123));
        roadstrip2[2] = new Triangle(478.000000, 511.000000, 494.000000, 545.000000, 462.000000, 545.000000, new Color(245, 243, 245));

        roadStrips.add(roadstrip2);

        roadstrip3[0] = new Rectangle(626.000000, 511.000000, 152.000000, 34.000000, new Color(245, 243, 245));
        roadstrip3[1] = new Triangle(626.000000, 511.000000, 642.000000, 545.000000, 610.000000, 545.000000, new Color(123, 123, 123));
        roadstrip3[2] = new Triangle(778.000000, 511.000000, 794.000000, 545.000000, 762.000000, 545.000000, new Color(245, 243, 245));

        roadStrips.add(roadstrip3);
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        for (DrawingObject[] roadStrip: roadStrips) {
            roadStrip[0].draw(g2d);
            roadStrip[1].draw(g2d);
            roadStrip[2].draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void moveStrips(double speed) {
        for (DrawingObject[] roadStrip: roadStrips) {
            roadStrip[0].adjustPosition(-speed, 0);
            roadStrip[1].adjustPosition(-speed, 0);
            roadStrip[2].adjustPosition(-speed, 0);

            if (roadStrip[0].getPosition()[0] <= -175) {
                roadStrip[0].setPosition(800, 511);
                roadStrip[1].setPosition(800, 511);
                roadStrip[2].setPosition(952, 511);
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
