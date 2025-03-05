/**
    This class is a shape that draws a hexagon in the canvas. An instance of 
    this object takes parameters that describe the hexagon and can be modifed 
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

public class Hexagon implements DrawingObject{
    
    private double x, y, size, rotation, xRotate, yRotate;
    private Color color;

    public Hexagon(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = 0;

        this.xRotate = x + (size/2);
        this.yRotate = y + (size*Math.sqrt(3)/2);

        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Path2D.Double shape = new Path2D.Double();

        shape.moveTo(x, y);
        shape.lineTo(x - size/2, y + size*Math.sqrt(3)/2);
        shape.lineTo(x, y + size*Math.sqrt(3));
        shape.lineTo(x + size, y + size*Math.sqrt(3));
        shape.lineTo(x + size*3/2, y + size*Math.sqrt(3)/2);
        shape.lineTo(x + size, y);
        
        shape.closePath();
        
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
        return;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void adjustPosition(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void adjustRotation(double rotation) {
        this.xRotate = x + (size/2);
        this.yRotate = y + (size*Math.sqrt(3)/2);
        this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        this.xRotate = this.x + (size/2) + x;
        this.yRotate = this.y + (size/2) + y;
        this.rotation += rotation;
    }
}
