/**
    This class is a shape that draws a triangle in the canvas. An instance of 
    this object takes parameters that describe the triangle and can be modifed 
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

public class Triangle implements DrawingObject{
    
    private double x1, y1, x2, y2, x3, y3, rotation, xRotate, yRotate;
    private Color color;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.rotation = 0;

        this.xRotate = (((x1 < x2) ? x1: (x2 < x3) ? x2: x3) + ((x1 > x2) ? x1: (x2 > x3) ? x2: x3)) / 2;
        this.yRotate = (((y1 < y2) ? y1: (y2 < y3) ? y2: y3) + ((y1 > y2) ? y1: (y2 > y3) ? y2: y3)) / 2;

        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double shape = new Path2D.Double();

        shape.moveTo(x1, y1);
        shape.lineTo(x2, y2);
        shape.lineTo(x3, y3);
        
        shape.closePath();
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    public double[] getPosition() {
        double[] position = {this.x1, this.y1};
        return position;
    }

    public void setPosition(double x, double y) {
        this.x2 += x - x1;
        this.y2 += y - y1;
        this.x3 += x - x1;
        this.y3 += y - y1;

        this.x1 = x;
        this.y1 = y;
    }

    public void setSize(double w, double h) {
        return;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x1 += x;
        this.y1 += y;
        this.x2 += x;
        this.y2 += y;
        this.x3 += x;
        this.y3 += y;
    }

    public void adjustRotation(double rotation) {
        this.xRotate = (((x1 < x2) ? x1: (x2 < x3) ? x2: x3) + ((x1 > x2) ? x1: (x2 > x3) ? x2: x3)) / 2;
        this.yRotate = (((y1 < y2) ? y1: (y2 < y3) ? y2: y3) + ((y1 > y2) ? y1: (y2 > y3) ? y2: y3)) / 2;
        this.rotation += rotation;
    }
}
