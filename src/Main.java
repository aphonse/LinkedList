import javax.swing.*;
import java.awt.*;

public class Main {

    private static final int WIDTH = 750;
    private static final int HEIGHT = 700;

    public static void main(String [] args){

        JFrame frame = new JFrame("Program");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Object to access the List class
        List object = new List();
        //Populate the Frame with the components in the List
        frame.add(object);
        frame.setVisible(true);
    }

}
