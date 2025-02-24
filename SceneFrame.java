import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame {
    private JFrame frame;
    private SceneCanvas sceneCanvas;

    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas();
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();

        cp.add(sceneCanvas);

        frame.setTitle("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
