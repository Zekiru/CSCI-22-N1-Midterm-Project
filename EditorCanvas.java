import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Implement ActionListener to use Timer.
public class EditorCanvas extends JComponent {
    
    private ArrayList<DrawingObject> drawObjects;

    // Instantiate shapes below:
    // private DrawingObject obj = new Square(100, 100, 200, Color.BLUE);

    // private ArrayList<double[]> points = new ArrayList<double[]>();

    public EditorCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.drawObjects = new ArrayList<DrawingObject>();

        // Add instantiated shapes to the ArrayList below:
        // drawObjects.add(obj);
        drawObjects.add(new Rectangle(0.000000, 0.000000, 803.000000, 607.000000, new Color(191, 229, 239))); //sky
        drawObjects.add(new Circle(636.000000, -76.000000, 191.000000, new Color(255, 235, 91))); // sun
        drawObjects.add(new Rectangle(0.000000, 331.000000, 812.000000, 289.000000, new Color(213, 182, 144))); // sand     
        drawObjects.add(new Rectangle(0.000000, 399.000000, 816.000000, 212.000000, new Color(123, 123, 123)));  //road
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

    public ArrayList<DrawingObject> getDrawingObjects() {
        return drawObjects;
    }

    public void addDrawingObject(DrawingObject d) {
        drawObjects.add(d);
        this.repaint();
    }

    public void removeLastDrawingObject() {
        if (drawObjects.size() < 1) return;
        drawObjects.remove(drawObjects.size() - 1);
        this.repaint();
    }
}
