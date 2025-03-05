/**
    This class is a composite shape that draws multiple clouds for the 
    background of the canvas. The clouds can move to the left depending 
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

public class Cloud implements DrawingObject{

    private ArrayList<DrawingObject> cloudParts;

    public Cloud() {
        cloudParts = new ArrayList<DrawingObject>();
        cloudParts.add(new Ellipse(71.000000-80, 112.000000+20, 189.000000, 49.000000, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(193.000000-80, 89.000000+20, 178.000000, 67.000000, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(325.000000-80, 107.000000+20, 163.000000, 48.000000, new Color(231, 233, 233)));  
             
        cloudParts.add(new Ellipse(71.000000-70, 112.000000+10, 189.000000, 49.000000, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(193.000000-70, 89.000000+10, 178.000000, 67.000000, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(325.000000-70, 107.000000+10, 163.000000, 48.000000, new Color(248, 244, 244)));  
        
        cloudParts.add(new Ellipse(321, 112.000000+100, 189.000000-30, 49.000000-30, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(193.000000+250, 89.000000+100, 178.000000-30, 67.000000-30, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(325.000000+250, 107.000000+100, 163.000000-30, 48.000000-30, new Color(231, 233, 233)));  
        
        cloudParts.add(new Ellipse(71.000000+250, 112.000000+90, 189.000000-30, 49.000000-30, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(193.000000+250, 89.000000+90, 178.000000-30, 67.000000-30, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(325.000000+250, 107.000000+90, 163.000000-30, 48.000000-30, new Color(248, 244, 244))); 

        cloudParts.add(new Ellipse(71.000000+400, 112.000000-20, 189.000000+10, 49.000000+10, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(193.000000+400, 89.000000-20, 178.000000+10, 67.000000+10, new Color(231, 233, 233)));        
        cloudParts.add(new Ellipse(325.000000+400, 107.000000-20, 163.000000+10, 48.000000+10, new Color(231, 233, 233)));  
             
        cloudParts.add(new Ellipse(71.000000+410, 112.000000-30, 189.000000+10, 49.000000+10, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(193.000000+410, 89.000000-30, 178.000000+10, 67.000000+10, new Color(248, 244, 244)));        
        cloudParts.add(new Ellipse(325.000000+410, 107.000000-30, 163.000000+10, 48.000000+10, new Color(248, 244, 244))); 
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        for (DrawingObject clp: cloudParts) {
            clp.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    public void moveClouds(double speed) {
        for (DrawingObject clp: cloudParts) {
            clp.adjustPosition(-speed, 0);
            if (clp.getPosition()[0] <= -199) {
                clp.setPosition(800, clp.getPosition()[1]);
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
