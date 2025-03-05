/**
    This class is a composite shape that draws multiple rocks for the 
    background of the canvas. The rocks can move to the left depending 
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

public class Rocks implements DrawingObject{

    private ArrayList<DrawingObject> rocks;

    public Rocks() {
        rocks = new ArrayList<DrawingObject>();
        rocks.add(new Ellipse(571.000000, 322.000000, 30.000000, 21.000000, new Color(123, 123, 123)));
        rocks.add(new Ellipse(159.000000, 352.000000, 8.000000, 5.000000, new Color(123, 123, 123)));
        rocks.add(new Ellipse(463.000000, 374.000000, 5.000000, 3.000000, new Color(123, 123, 123)));
        rocks.add(new Ellipse(734.000000, 346.000000, 0.000000, 0.000000, new Color(123, 123, 123)));
        rocks.add(new Ellipse(753.000000, 343.000000, 7.000000, 5.000000, new Color(123, 123, 123)));
        rocks.add(new Ellipse(18.000000, 351.000000, 19.000000, 13.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(287.000000, 373.000000, 12.000000, 7.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(418.000000, 320.000000, 0.000000, 0.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(413.000000, 328.000000, 12.000000, 7.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(631.000000, 353.000000, 6.000000, 5.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(763.000000, 338.000000, 17.000000, 11.000000, new Color(126, 95, 76)));
        rocks.add(new Ellipse(774.000000, 343.000000, 12.000000, 8.000000, new Color(243, 234, 192)));
        rocks.add(new Ellipse(177.000000, 350.000000, 0.000000, 0.000000, new Color(243, 234, 192)));
        rocks.add(new Ellipse(170.000000, 341.000000, 20.000000, 11.000000, new Color(243, 234, 192)));
        rocks.add(new Ellipse(36.000000, 376.000000, 7.000000, 5.000000, new Color(243, 234, 192)));
        rocks.add(new Ellipse(392.000000, 352.000000, 6.000000, 4.000000, new Color(243, 234, 192)));
        rocks.add(new Ellipse(423.000000, 330.000000, 7.000000, 5.000000, new Color(231, 233, 236)));
        rocks.add(new Ellipse(593.000000, 333.000000, 16.000000, 13.000000, new Color(231, 233, 236)));
        rocks.add(new Ellipse(276.000000, 340.000000, 4.000000, 2.000000, new Color(231, 233, 236)));
        rocks.add(new Ellipse(735.000000, 373.000000, 6.000000, 4.000000, new Color(231, 233, 236)));
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        for (DrawingObject r: rocks) {
            r.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void moveRocks(double speed) {
        for (DrawingObject r: rocks) {
            double y = r.getPosition()[1];
            r.adjustPosition(-speed, 0);
            if (r.getPosition()[0] <= -30) {
                r.setPosition(800, y);
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
