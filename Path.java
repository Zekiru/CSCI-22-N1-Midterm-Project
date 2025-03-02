import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Path implements DrawingObject{
    
    private ArrayList<double[]> points;
    private double size, rotation, xMin, xMax, yMin, yMax, xRotate, yRotate;
    // private double[][] endpoints;
    private Color color;
    private boolean shape, fill;

    public Path(ArrayList<double[]> points, double size, Color color) {
        this.shape = false;
        this.fill = false;

        this.points = points;
        this.size = size;

        xMax = points.get(0)[0];
        xMin = points.get(0)[0];
        yMax = points.get(0)[1];
        yMin = points.get(0)[1];

        for (double[] point: points) {
            if (point[0] > xMax) xMax = point[0];
            if (point[1] > yMax) yMax = point[1];
            if (point[0] < xMin) xMax = point[0];
            if (point[1] < yMin) yMax = point[1];
        }

        this.rotation = 0;
        this.xRotate = (xMin + xMax) / 2;
        this.yRotate = (yMin + yMax) / 2;

        this.color = color;
        // this.endpoints = new double[4][2];
    }

    public Path(ArrayList<double[]> points, double size, boolean fill, Color color) {
        this.shape = true;
        this.fill = fill;

        this.points = points;
        this.size = size;

        xMax = points.get(0)[0];
        xMin = points.get(0)[0];
        yMax = points.get(0)[1];
        yMin = points.get(0)[1];

        for (double[] point: points) {
            if (point[0] > xMax) xMax = point[0];
            if (point[1] > yMax) yMax = point[1];
            if (point[0] < xMin) xMax = point[0];
            if (point[1] < yMin) yMax = point[1];
        }

        this.rotation = 0;
        this.xRotate = (xMin + xMax) / 2;
        this.yRotate = (yMin + yMax) / 2;

        this.color = color;
        // this.endpoints = new double[4][2];
    }

    public double[][] diameterEndPoints(double a, double b, double m, double r) {
        // Calculate the discriminant (the part inside the square root)
        double discriminant = Math.pow(-2 * a - 2 * m * m * a, 2) 
            - 4 * (1 + m * m) * (Math.pow(a, 2) + m * m * Math.pow(a, 2) - Math.pow(r, 2));

        // If the discriminant is negative, there is no real solution
        if (discriminant < 0) {
            double[][] noSolution = {{0, 0}, {0, 0}};
            return noSolution;
        }

        // Calculate x using the quadratic formula (both + and - cases)
        double x1 = (2 * a + 2 * m * m * a + Math.sqrt(discriminant)) / (2 * (1 + m * m));
        double x2 = (2 * a + 2 * m * m * a - Math.sqrt(discriminant)) / (2 * (1 + m * m));

        // Calculate y for each x value
        double y1 = m * (x1 - a) + b;
        double y2 = m * (x2 - a) + b;

        double[][] endpoints = {{x1, y1}, {x2, y2}};

        return endpoints;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Path2D.Double path = new Path2D.Double();
        
        int i = 0;
        double x1, y1, x2, y2;

        x1 = points.get(0)[0];
        y1 = points.get(0)[1];

        path.moveTo(x1, y1);

        while (i < points.size()) {

            x2 = points.get(i)[0];
            y2 = points.get(i)[1];

            if (i == 0) {
                i++;
                continue;
            }

            if (!fill) {
                // System.out.printf("(%f, %f) to (%f, %f)\n", x1, y1, x2, y2);

                // new Line(100, 100, 600, 100, 20, Color.BLACK).draw(g2d);

                new Circle(x1 - size/2, y1 - size/2, size, color).draw(g2d);
                new Line(x1, y1, x2, y2, size, color).draw(g2d);
                if (i == points.size() - 1) new Circle(x2 - size/2, y2 - size/2, size, color).draw(g2d);

                x1 = x2;
                y1 = y2;

                if (i == points.size() - 1 && shape) {
                    x2 = points.get(0)[0];
                    y2 = points.get(0)[1];

                    new Line(x1, y1, x2, y2, size, color).draw(g2d);
                }

                i++;
                continue;
            }

            path.lineTo(x2, y2);

            if (i == points.size() - 1) {
                path.closePath();
                g2d.setColor(color);
                g2d.rotate(Math.toRadians(rotation), xRotate,  yRotate); 

                g2d.fill(path);
                g2d.setTransform(reset);
            }

            x1 = x2;
            y1 = y2;

            i++;
        }

    }

    public DrawingObject getDrawObject() {
        return this;
    }

    public void setPosition(double x, double y) {
        int i = 0;
        for (double[] point: points) {
            if (i == 0) {
                point[0] = x;
                point[1] = y;
            } else {
                point[0] += x - points.get(0)[0];
                point[1] +=  y - points.get(0)[1];
            }
            i++;
        }
    }

    public void setSize(double w, double h) {
        this.size = (w > h) ? w: h;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void addPath(double x, double y) {
        double[] e = new double[2];
        e[0] = x;
        e[1] = y;
        points.add(e);
    }

    public void toggleClose() {
        this.shape = !this.shape;
    }

    public void toggleFill() {
        this.fill = !this.fill;
        this.shape = this.fill;
    }

    public void adjustPosition(double x, double y) {
        for (double[] point: points) {
            point[0] += x;
            point[1] +=  y;
        }
    }

    public void adjustRotation(double rotation) {
        this.xRotate = (xMin + xMax) / 2;
        this.yRotate = (yMin + yMax) / 2;
        this.rotation += rotation;
    }

    public void adjustRotation(double rotation, double x, double y) {
        this.xRotate = (xMin + xMax) / 2 + x;
        this.yRotate = (yMin + yMax) / 2 + y;
        this.rotation += rotation;
    }

    public String getAttributes() {
        String path = "ArrayList<double[]> points = new ArrayList<double[]>;\ndouble[] point = new double[2]\n";

        for (double[] point: points) {
            path += String.format("\npoint[0] = %f;\npoint[1] = %f;\npoints.add(point);\n", point[0], point[1]);
        }

        String modifier;

        if (this.shape) {
            modifier = (fill) ? " true," : " false,";
        } else {
            modifier = "";
        }

        path += String.format("\nPath(ArrayList<double[]> points, %f,%s new Color(%d, %d, %d))\n", size, modifier, color.getRed(), color.getGreen(), color.getBlue());;

        

        return path;
    }
}
