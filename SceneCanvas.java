import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Implement ActionListener to use Timer.
public class SceneCanvas extends JComponent implements ActionListener {
    
    private ArrayList<DrawingObject> shapes;
    private Timer time;

    // Instantiate shapes below:
    DrawingObject s1 = new Square(100, 100, 200, Color.BLUE);
    DrawingObject c1 = new Circle(300, 300, 200, Color.RED);
    DrawingObject l1 = new Line(50, 500, 600, 400, 50, Color.GREEN);

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.shapes = new ArrayList<DrawingObject>();
        this.time = new Timer(10, this); // Timer triggers ActionListener.
        
        

        // Add instantiated shapes to the ArrayList below:
        shapes.add(s1);
        shapes.add(c1);
        shapes.add(l1);

        time.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set RenderingHints for Anti-Aliasing:
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHints(rh);

        // Draw shapes on the canvas in order of addition to the ArrayList:
        for (DrawingObject shape:shapes) {
            shape.draw(g2d);
        }
    }

    // Perform methods per ActionEvent triggered by the Timer:
    @Override
    public void actionPerformed(ActionEvent e) {
        s1.translateX(.2);
        s1.translateY(.3);
        s1.translateRotation(.4);
        c1.translateX(.2);
        c1.translateY(-.15);
        l1.translateX(-.03);
        l1.translateY(-.15);
        l1.translateRotation(-.2);
        this.repaint();
    }
}
