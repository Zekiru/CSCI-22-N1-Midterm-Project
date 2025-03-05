/**
    This interface is implemented by all the drawable classes in this project. 
    All abstract methods defined in this interface are common to all the simple 
    drawable objects.
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

public interface DrawingObject {
    void draw(Graphics2D g2d);
    double[] getPosition();

    void setPosition(double x, double y);
    void setSize(double w, double h);
    void setColor(Color c);
    
    void adjustPosition(double x, double y);
    void adjustRotation(double rotation);
}
