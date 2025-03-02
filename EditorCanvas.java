import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Implement ActionListener to use Timer.
public class EditorCanvas extends JComponent {
    
    private ArrayList<DrawingObject> drawObjects;

    // Instantiate shapes below:
    // private DrawingObject obj = new Square(100, 100, 200, Color.BLUE);

    private ArrayList<double[]> points = new ArrayList<double[]>();

    public EditorCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.drawObjects = new ArrayList<DrawingObject>();

        // double[][] p = new double[4][2];
        // p[0][0] = 100;
        // p[0][1] = 100;
        // p[1][0] = 100;
        // p[1][1] = 200;
        // p[2][0] = 400;
        // p[2][1] = 400;
        // p[3][0] = 200;
        // p[3][1] = 100;

        // for (double[] point: p) {
        //     this.points.add(point);
        // }

        // Add instantiated shapes to the ArrayList below:
        // drawObjects.add(obj);

        // drawObjects.add(new Path(points, 10, true, Color.BLUE));
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
