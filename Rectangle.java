/**
    This class is a shape that draws a rectangle in the canvas. An instance of 
    this object takes parameters that describe the rectangle and can be modifed 
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

public class Rectangle implements DrawingObject{
    
    private double x, y, w, h, rotation, xRotate, yRotate;
    private Color color;

    public Rectangle(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rotation = 0;
        this.xRotate = x + (w/2);
        this.yRotate = y + (h/2);
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Rectangle2D.Double shape = new Rectangle2D.Double(x, y, w, h);
        
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

        g2d.fill(shape);
        g2d.setTransform(reset);
    }

    public double[] getPosition() {
        double[] position = {this.x, this.y};
        return position;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void adjustRotation(double rotation) {
        this.xRotate = x + (w/2);
        this.yRotate = y + (h/2);
        this.rotation += rotation;
    }
}
