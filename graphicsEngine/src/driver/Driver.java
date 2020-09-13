package driver;

import graphics.GraphicsFrame;
import graphics.GraphicsPanel;

import javax.swing.*;

public class Driver {

    public static void main(String[] args) {

        GraphicsFrame frame = new GraphicsFrame();

        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsPanel panel = new GraphicsPanel(frame.getWidth(), frame.getHeight());

        frame.add(panel);

        frame.setVisible(true);

    }


}
