import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditorFrame implements ActionListener, MouseListener, MouseMotionListener{
    private JFrame frame;
    private EditorCanvas editorCanvas;

    private Timer time;
    private int delay;

    private double x1, y1, x2, y2;
    private String drawObject;

    private DrawingObject drawObj;

    private JPanel panel;
    private JLabel mouse;
    private ArrayList<JButton> buttons;
    private ArrayList<JTextField> rgb;

    public EditorFrame() {
        frame = new JFrame();
        editorCanvas = new EditorCanvas();
        editorCanvas.addMouseListener(this);
        editorCanvas.addMouseMotionListener(this);

        delay = 10;
        time = new Timer(delay, this);
        time.start();

        drawObject = "Rectangle";

        panel = new JPanel();
        mouse = new JLabel("(0, 0)");

        buttons = new ArrayList<JButton>();
        buttons.add(new JButton("Rectangle"));
        buttons.add(new JButton("Ellipse"));
        buttons.add(new JButton("Undo"));

        rgb = new ArrayList<JTextField>();
        rgb.add(new JTextField("0"));
        rgb.add(new JTextField("0"));
        rgb.add(new JTextField("0"));
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();
        frame.setLayout(new BorderLayout());

        cp.add(editorCanvas, BorderLayout.CENTER);

        panel.setLayout(new GridLayout(1,2));

        for (JButton button: buttons) {
            panel.add(button);
            button.addActionListener(this);
        }

        for (JTextField color: rgb) {
            panel.add(color);
            color.addActionListener(this);
        }

        panel.add(mouse);
        cp.add(panel, BorderLayout.SOUTH);

        frame.setTitle("Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateMouse(MouseEvent e) {
        mouse.setText("(" + e.getX() + ", " + e.getY() + ")");
    }

    public void createRectangle(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Rectangle(x1, y1, 0, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double w = Math.abs(x2 - x1);
        double h = Math.abs(y2 - y1);

        int r = Integer.parseInt(rgb.get(0).getText());
        int g = Integer.parseInt(rgb.get(1).getText());
        int b = Integer.parseInt(rgb.get(2).getText());

        Color color = new Color(r, g , b);

        drawObj = new Rectangle(x, y, w, h, color);

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);

        // System.out.printf("Rectangle(%f, %f, %f, %f, Color.BLUE)\n", x, y, w, h);
    }

    public void createEllipse(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Rectangle(x1, y1, 0, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double w = Math.abs(x2 - x1);
        double h = Math.abs(y2 - y1);

        int r = Integer.parseInt(rgb.get(0).getText());
        int g = Integer.parseInt(rgb.get(1).getText());
        int b = Integer.parseInt(rgb.get(2).getText());

        Color color = new Color(r, g , b);

        drawObj = new Ellipse(x, y, w, h, color);

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);

        // System.out.printf("Rectangle(%f, %f, %f, %f, Color.BLUE)\n", x, y, w, h);
    }

    private void drawProcess(MouseEvent e, boolean init) {
        if (drawObject == "Rectangle") {
            createRectangle(e, init);
            return;
        }

        if (drawObject == "Ellipse") {
            createEllipse(e, init);
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.get(0)) {
            drawObject = "Rectangle";
        }

        if (e.getSource() == buttons.get(1)) {
            drawObject = "Ellipse";
        }

        if (e.getSource() == buttons.get(buttons.size() - 1)) {
            editorCanvas.removeLastDrawingObject();
            return;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        return;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.printf("mousePressed(%f, %f)\n", x1, y1);
        drawProcess(e, true); 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.printf("mouseReleased(%f, %f)\n", x2, y2);
        drawProcess(e, false); 
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
        updateMouse(e);
        drawProcess(e, false); 
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMouse(e);
    }
}
