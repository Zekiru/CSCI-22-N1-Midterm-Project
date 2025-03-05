/**
    This class is a shape that draws a line in the canvas. An instance of 
    this object takes parameters that describe the line and can be modifed 
    using methods such as adjusting the position of the object.
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

public class Line implements DrawingObject{
    
    private double x1, y1, x2, y2, size, rotation, xRotate, yRotate;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, double size, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.size = size;
        this.rotation = 0;
        this.xRotate = (x1 + x2) / 2;
        this.yRotate = (y1 + y2) / 2;
        this.color = color;
    }

    public double[][] diameterEndPoints(double a, double b, double m, double r) { 
        /* Using the Quadratic formula to calculate a made up Circle(a, b)'s' diameter 
        endpoints relative to the slope of the diameter */

        // Calculate the discriminant (the part inside the square root of the Quadratic Formula)
        double discriminant = Math.pow(-2 * a - 2 * m * m * a, 2) 
            - 4 * (1 + m * m) * (Math.pow(a, 2) + m * m * Math.pow(a, 2) - Math.pow(r, 2));

        // If the discriminant is negative, there is no real solution:
        if (discriminant < 0) {
            double[][] noSolution = {{0, 0}, {0, 0}};
            return noSolution;
        }

        // Calculate x using the quadratic formula (both + and - cases)
        double x1 = (2 * a + 2 * m * m * a + Math.sqrt(discriminant)) / (2 * (1 + m * m));
        double x2 = (2 * a + 2 * m * m * a - Math.sqrt(discriminant)) / (2 * (1 + m * m));

        // Calculate y for each x value
        double y1 = m * (x1 - a) + b;
        double y2 = m * (x2 - a) + b;

        double[][] endpoints = {{x1, y1}, {x2, y2}};

        return endpoints;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double line = new Path2D.Double();

        double rise = y2 - y1;
        double run = x2 - x1;
        
        double m1 = rise / run;
        double m2 = -(1 / m1);

        double r = size / 2;

        if (m1 == 0) { // Manual plotting the points:
            line.moveTo(x1, y1 - r);
            line.lineTo(x2, y2 - r);
            line.lineTo(x2, y2 + r);
            line.lineTo(x1, y1 + r);
        } else { // If the line is perfectly horizontal, the solution below breaks:
            double[][] endpoints1 = diameterEndPoints(x1, y1, m2, r);
            double[][] endpoints2 = diameterEndPoints(x2, y2, m2, r);

            line.moveTo(endpoints1[0][0], endpoints1[0][1]);
            line.lineTo(endpoints2[0][0], endpoints2[0][1]);
            line.lineTo(endpoints2[1][0], endpoints2[1][1]);
            line.lineTo(endpoints1[1][0], endpoints1[1][1]);
        }

        line.closePath();
        
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

        g2d.fill(line);
        g2d.setTransform(reset);
    }

    public double[] getPosition() {
        double[] position = {this.x1, this.y1};
        return position;
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
        this.xRotate = (x1 + x2) / 2;
        this.yRotate = (y1 + y2) / 2;
        this.rotation += rotation;
    }
}
