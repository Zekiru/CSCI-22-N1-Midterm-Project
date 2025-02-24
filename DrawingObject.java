import java.awt.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    DrawingObject getShape();

    void setPosition(double x, double y);
    void translateX(double distance);
    void translateY(double distance);
    void translateRotation(double rotation);

    // Add more when necessary...
}
