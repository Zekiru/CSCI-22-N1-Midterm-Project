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
    private JTextField size;
    private ArrayList<JButton> buttons;
    private ArrayList<JTextField> rgb;
    private JPanel sampleColor;

    public EditorFrame() {
        frame = new JFrame();
        editorCanvas = new EditorCanvas();
        editorCanvas.addMouseListener(this);
        editorCanvas.addMouseMotionListener(this);

        drawObject = "Rectangle";

        panel = new JPanel();
        mouse = new JLabel("(0, 0)");

        buttons = new ArrayList<JButton>();
        buttons.add(new JButton("Rectangle"));
        buttons.add(new JButton("Ellipse"));
        buttons.add(new JButton("Square"));
        buttons.add(new JButton("Circle"));
        buttons.add(new JButton("Triangle"));
        buttons.add(new JButton("Hexagon"));
        buttons.add(new JButton("Line"));
        buttons.add(new JButton("Path"));
        buttons.add(new JButton("closePath"));
        buttons.add(new JButton("fillPath"));
        buttons.add(new JButton("Undo"));
        buttons.add(new JButton("Print"));

        size = new JTextField("1");
        sampleColor = new JPanel();

        rgb = new ArrayList<JTextField>();
        rgb.add(new JTextField("0"));
        rgb.add(new JTextField("0"));
        rgb.add(new JTextField("0"));

        delay = 10;
        time = new Timer(delay, this);
        time.start();
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();
        frame.setLayout(new BorderLayout());

        cp.add(editorCanvas, BorderLayout.CENTER);

        panel.setLayout(new GridLayout(18,1));

        for (JButton button: buttons) {
            panel.add(button);
            button.addActionListener(this);
        }

        panel.add(size);

        sampleColor.setBackground(Color.BLACK);
        panel.add(sampleColor);

        for (JTextField color: rgb) {
            panel.add(color);
            color.addActionListener(this);
        }

        panel.add(mouse);
        cp.add(panel, BorderLayout.EAST);

        frame.setTitle("Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateMouse(MouseEvent e) {
        mouse.setText("(" + e.getX() + ", " + e.getY() + ")");
    }

    private Color getColor() {
        if (this.rgb == null) return new Color(0, 0, 0);

        int r = Integer.parseInt(rgb.get(0).getText());
        int g = Integer.parseInt(rgb.get(1).getText());
        int b = Integer.parseInt(rgb.get(2).getText());

        return new Color(r, g, b);
    }

    private void createRectangle(MouseEvent e, boolean init) {
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

        drawObj = new Rectangle(x, y, w, h, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createEllipse(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Ellipse(x1, y1, 0, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double w = Math.abs(x2 - x1);
        double h = Math.abs(y2 - y1);

        drawObj = new Ellipse(x, y, w, h, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createSquare(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Square(x1, y1, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double s = (Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2): Math.abs(y1 - y2);

        drawObj = new Square(x, y, s, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createCircle(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Circle(x1, y1, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double s = (Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2): Math.abs(y1 - y2);

        drawObj = new Circle(x, y, s, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createTriangle(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Triangle(x1, y1, x1, y1, x1, y1, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = (e.getX() > x1) ? e.getX(): x1;
        y2 = (e.getY() > y1) ? e.getY(): y1;
        double x = (x2 > x1) ? x1: x1;
        double y = (y2 > y1) ? y1: y2;

        double x3 = x + (x - e.getX());
        double y3 = (y2 > y) ? y2: y;

        drawObj = new Triangle(x, y, x2, y2, x3, y3, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createHexagon(MouseEvent e, boolean init) {
        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Hexagon(x1, y1, 0, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        double x = (x2 > x1) ? x1: x2;
        double y = (y2 > y1) ? y1: y2;
        double s = (Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2): Math.abs(y1 - y2);

        drawObj = new Hexagon(x, y, s, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);
    }

    private void createLine(MouseEvent e, boolean init) {
        double setSize = Integer.parseInt(size.getText());

        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            drawObj = new Line(x1, y1, x1, y1, setSize, Color.BLUE);
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        drawObj = new Line(x1, y1, x2, y2, setSize, getColor());

        editorCanvas.removeLastDrawingObject();
        editorCanvas.addDrawingObject(drawObj);

        // System.out.printf("Rectangle(%f, %f, %f, %f, Color.BLUE)\n", x, y, w, h);
    }

    private void createPath(MouseEvent e, boolean init) {
        double setSize = Integer.parseInt(size.getText());

        ArrayList<double[]> points = new ArrayList<double[]>();
        double[] point = new double[2];

        if (init) {
            x1 = e.getX();
            y1 = e.getY();
            
            point[0] = x1;
            point[1] = y1;
            points.add(point);

            drawObj = new Path(points, setSize, getColor());
            editorCanvas.addDrawingObject(drawObj);
            return;
        }

        x2 = e.getX();
        y2 = e.getY();

        Path pathObj = (Path) drawObj;
        pathObj.addPath(x2, y2);
        editorCanvas.repaint();

        // editorCanvas.removeLastDrawingObject();
        // editorCanvas.addDrawingObject(drawObj);

        // System.out.printf("Rectangle(%f, %f, %f, %f, Color.BLUE)\n", x, y, w, h);
    }

    private void closePath(Path p) {
        p.toggleClose();
        editorCanvas.repaint();
    }

    private void fillPath(Path p) {
        p.toggleFill();
        editorCanvas.repaint();
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

        if (drawObject == "Square") {
            createSquare(e, init);
            return;
        }

        if (drawObject == "Circle") {
            createCircle(e, init);
            return;
        }

        if (drawObject == "Triangle") {
            createTriangle(e, init);
            return;
        }

        if (drawObject == "Hexagon") {
            createHexagon(e, init);
            return;
        }

        if (drawObject == "Line") {
            createLine(e, init);
            return;
        }

        if (drawObject == "Path") {
            createPath(e, init);
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

        if (e.getSource() == buttons.get(2)) {
            drawObject = "Square";
        }

        if (e.getSource() == buttons.get(3)) {
            drawObject = "Circle";
        }

        if (e.getSource() == buttons.get(4)) {
            drawObject = "Triangle";
        }

        if (e.getSource() == buttons.get(5)) {
            drawObject = "Hexagon";
        }

        if (e.getSource() == buttons.get(6)) {
            drawObject = "Line";
        }

        if (e.getSource() == buttons.get(7)) {
            drawObject = "Path";
        }

        if (e.getSource() == buttons.get(8)) {
            if (drawObj instanceof Path) {
                Path pathObj = (Path) drawObj;
                closePath(pathObj);
            }
        }

        if (e.getSource() == buttons.get(9)) {
            if (drawObj instanceof Path) {
                Path pathObj = (Path) drawObj;
                fillPath(pathObj);
            }
        }

        if (e.getSource() == buttons.get(buttons.size() - 2)) {
            editorCanvas.removeLastDrawingObject();
        }

        if (e.getSource() == buttons.get(buttons.size() - 1)) {
            ArrayList<DrawingObject> drawObjects = editorCanvas.getDrawingObjects();

            for (DrawingObject drawObject: drawObjects) {
                System.out.println(drawObject.getAttributes());
            }
        }

        if (e.getSource() == rgb.get(0) || e.getSource() == rgb.get(1) || e.getSource() == rgb.get(2)) {
            sampleColor.setBackground(getColor());
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
