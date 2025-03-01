import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Implement ActionListener to use Timer.
public class SceneCanvas extends JComponent implements ActionListener {
    
    private ArrayList<DrawingObject> drawObjects;
    private Timer time;

    // Instantiate shapes below:
    private DrawingObject s1 = new Square(100, 100, 200, Color.BLUE);
    private DrawingObject c1 = new Circle(300, 300, 200, Color.RED);
    private DrawingObject l1 = new Line(50, 500, 600, 400, 50, Color.GREEN);

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.drawObjects = new ArrayList<DrawingObject>();
        this.time = new Timer(10, this); // Timer triggers ActionListener.
        
        

        // Add instantiated shapes to the ArrayList below:
        drawObjects.add(s1);
        drawObjects.add(c1);
        drawObjects.add(l1);

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
        for (DrawingObject drawObject:drawObjects) {
            drawObject.draw(g2d);
        }
    }

    // Perform methods per ActionEvent triggered by the Timer:
    @Override
    public void actionPerformed(ActionEvent e) {
        s1.adjustPosition(.2, .3);
        s1.adjustRotation(.4);
        c1.adjustPosition(.2, -.15);
        l1.adjustPosition(-.03, -.15);
        l1.adjustRotation(-.2);
        this.repaint();
    }

    public void addDrawingObject(DrawingObject d) {
        drawObjects.add(d);
    }
}
