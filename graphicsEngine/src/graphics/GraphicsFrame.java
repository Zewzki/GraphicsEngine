package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsFrame extends JFrame {

    private static final int W = 1200;
    private static final int H = 800;

    private GraphicsPanel panel;


    public GraphicsFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(W, H));

        panel = new GraphicsPanel(W, H);
        add(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        GraphicsFrame gFrame = new GraphicsFrame();

    }

}
