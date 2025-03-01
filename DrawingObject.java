import java.awt.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    DrawingObject getDrawObject();

    void setPosition(double x, double y);
    void setSize(double w, double h);
    void setColor(Color c);
    void adjustPosition(double x, double y);
    void adjustRotation(double rotation);

    // Add more when necessary...
}
