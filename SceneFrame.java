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
