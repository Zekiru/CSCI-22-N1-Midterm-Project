/**
    This class serves as the canvas where all the shapes are casted unto. 
    An instance of this canvas is created inside the SceneFrame where it 
    should be seen when the project is executed.
    @author Kristin Faith Palencia (234746), Ezekiel Villasurda (236689)
    @version 5 March 2025
    We have not discussed the Java language code in our program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.
    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
**/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Implement ActionListener to use Timer.
public class SceneCanvas extends JComponent implements ActionListener {
    
    private ArrayList<DrawingObject> drawObjects;
    private Timer time;
    private double speed;
    private boolean moving;

    // Instantiate shapes below:
    private DrawingObject sky, sun, sand, road, roadStrips, clouds, rocks, cactus, mainCar;

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.drawObjects = new ArrayList<DrawingObject>();
        this.time = new Timer(10, this); // Timer triggers ActionListener.
        this.speed = 0;
        this.moving = false;

        this.sky = new Rectangle(0.000000, 0.000000, 800.000000, 600.000000, new Color(191, 229, 239));
        this.sun = new Circle(636.000000, -76.000000, 191.000000, new Color(255, 235, 91));
        this.sand = new Rectangle(0.000000, 331.000000, 812.000000, 289.000000, new Color(213, 182, 144));
        this.road = new Rectangle(0.000000, 399.000000, 816.000000, 212.000000, new Color(123, 123, 123));
        this.roadStrips = new RoadStrips();
        this.clouds = new Cloud();
        this.rocks = new Rocks();
        this.cactus = new Cactus();
        this.mainCar = new Car(new Color(43, 66, 87));

        // Add instantiated shapes to the ArrayList below:
        this.drawObjects.add(sky);
        this.drawObjects.add(sun);
        this.drawObjects.add(sand);
        this.drawObjects.add(road);
        this.drawObjects.add(roadStrips);
        this.drawObjects.add(clouds);
        this.drawObjects.add(rocks);
        this.drawObjects.add(cactus);
        this.drawObjects.add(mainCar);

        this.time.start();
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

        if (moving) {
            if (speed < 1) speed += 0.005;
        } else {
            if (speed > 0) speed -= 0.01;
        }

        if (e.getSource() == time) {
            Car mainCar = (Car) this.mainCar;
            mainCar.spinTires(10 * speed);

            RoadStrips roadStrips = (RoadStrips) this.roadStrips;
            roadStrips.moveStrips(10 * speed);

            Cloud clouds = (Cloud) this.clouds;
            clouds.moveClouds(0.2 + 0.5 * speed);
            
            Rocks rocks = (Rocks) this.rocks;
            rocks.moveRocks(5 * speed);

            Cactus cactus = (Cactus) this.cactus;
            cactus.moveCactus(5 * speed);
            this.repaint();
        }
    }

    public void addDrawingObject(DrawingObject d) {
        drawObjects.add(d);
    }

    public void isMoving() {
        this.moving = !this.moving;
    }
}
