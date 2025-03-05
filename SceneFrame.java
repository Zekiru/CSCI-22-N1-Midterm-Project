/**
    This class serves as the frame where the canvas is housed. This also 
    serves as a MouseListener that detects mouse presses in order to perform 
    one of the program's actions.
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame implements MouseListener{
    private JFrame frame;
    private SceneCanvas sceneCanvas;

    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas();
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();

        sceneCanvas.addMouseListener(this);
        cp.add(sceneCanvas);

        frame.setTitle("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        //
    }

    public void mousePressed(MouseEvent e) {
        sceneCanvas.isMoving();
    }

    public void mouseReleased(MouseEvent e) {
        //
    }

    public void mouseEntered(MouseEvent e) {
        //
    }

    public void mouseExited(MouseEvent e) {
        //
    }
}
