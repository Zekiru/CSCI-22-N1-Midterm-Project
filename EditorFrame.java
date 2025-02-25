import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditorFrame implements ActionListener, MouseListener, MouseMotionListener{
    private JFrame frame;
    private EditorCanvas editorCanvas;

    private Timer time;
    private int delay, delta;
    
    private boolean drawState;
    private double x1, y1, x2, y2;

    private Rectangle rectangle;

    public EditorFrame() {
        frame = new JFrame();
        editorCanvas = new EditorCanvas();
        editorCanvas.addMouseListener(this);
        editorCanvas.addMouseMotionListener(this);

        delay = 10; // Delta/Delay
        delta = 0;
        time = new Timer(delay, this);
        time.start();

        drawState = false;
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();

        cp.add(editorCanvas);

        frame.setTitle("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        delta += 1;
        // Perform animation changes below:

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        return;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Test Square Fill:
        x1 = e.getX();
        y1 = e.getY();
        drawState = true;
        rectangle = new Rectangle(x1, y1, 0, 0, Color.BLUE);
        editorCanvas.addDrawingObject(rectangle);
        editorCanvas.repaint();
        // System.out.printf("mousePressed(%f, %f)\n", x1, y1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Test Square Fill:
        x2 = e.getX();
        y2 = e.getY();
        drawState = false;
        // System.out.printf("mouseReleased(%f, %f)\n", x2, y2);

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double w = Math.abs(x2 - x1);
        double h = Math.abs(y2 - y1);

        rectangle = new Rectangle(x, y, w, h, Color.BLUE);

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(rectangle);
        editorCanvas.repaint();
        
        System.out.printf("Rectangle(%f, %f, %f, %f, Color.BLUE)\n", x, y, w, h);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drawState) {
            x2 = e.getX();
            y2 = e.getY();
            double x = (x2 > x1) ? x1: x2;
            double y = (y2 > y1) ? y1: y2;
            double w = Math.abs(x2 - x1);
            double h = Math.abs(y2 - y1);
            rectangle = new Rectangle(x, y, w, h, Color.BLUE);
            editorCanvas.removeLastDrawingObject();
            editorCanvas.addDrawingObject(rectangle);
            editorCanvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        return;
    }
}
