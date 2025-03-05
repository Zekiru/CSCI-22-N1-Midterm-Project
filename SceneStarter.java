/**
    This class serves as main class that runs the entire program. This class 
    creates an instance of the frame which will be shown once the project is 
    running.
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

public class SceneStarter {

    public static void main(String[] args) {
        SceneFrame sf = new SceneFrame();
        sf.setUpGUI();
    }
}