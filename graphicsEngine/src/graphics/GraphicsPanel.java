package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsPanel extends JPanel {

    private static final int numOfBuffers = 2;

    private int width;
    private int height;

    private int currentBufferNum;
    private BufferedImage[] imageBuffers;

    public GraphicsPanel(int width, int height) {

        this.width = width;
        this.height = height;

        currentBufferNum = 0;
        imageBuffers = new BufferedImage[numOfBuffers];

        for(int i = 0; i < numOfBuffers; i++) imageBuffers[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    }

    public void paintComponent(Graphics g) {

        g.drawImage(imageBuffers[currentBufferNum], 0, 0, width, height, null);
        currentBufferNum = (currentBufferNum + 1) % numOfBuffers;

    }

}
