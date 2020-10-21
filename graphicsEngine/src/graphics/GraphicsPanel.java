package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsPanel extends JPanel {

    private static final int numOfBuffers = 2;

    private static final Color drawColor = new Color(255, 255, 255);

    private final float fieldOfView = 90.0f;
    private final float fieldOfViewRadians = 1.0f / (float) Math.tan(fieldOfView * 0.f / 180.0f * 3.14159f);
    private final float zFar = 1000.0f;
    private final float zNear = 0.1f;

    private int width;
    private int height;

    private float aspectRatio;

    private int currentBufferNum;
    private BufferedImage[] imageBuffers;

    private final String testCubePath = "graphicsEngine/src/rsc/testCube.txt";
    private Mesh testCube;
    private float[][] matProj;

    public GraphicsPanel(int width, int height) {

        this.width = width;
        this.height = height;

        setSize(width, height);
        setPreferredSize(new Dimension(width, height));

        aspectRatio = ((float) height) / ((float) width);

        currentBufferNum = 0;
        imageBuffers = new BufferedImage[numOfBuffers];

        for(int i = 0; i < numOfBuffers; i++) imageBuffers[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        testCube = new Mesh(testCubePath);

        matProj = new float[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        matProj[0][0] = aspectRatio * fieldOfViewRadians;
        matProj[1][1] = fieldOfViewRadians;
        matProj[2][2] = zFar / (zFar - zNear);
        matProj[3][2] = (-zFar * zNear) / (zFar - zNear);
        matProj[2][3] = 1.0f;
        matProj[3][3] = 0.0f;

    }

    public void paintComponent(Graphics g) {

        for(Triangle t : testCube.mesh) {

            Vector3D v1 = matMulVec(t.tri[0], matProj);
            Vector3D v2 = matMulVec(t.tri[1], matProj);
            Vector3D v3 = matMulVec(t.tri[2], matProj);

            Triangle tProj = new Triangle(v1, v2, v3);

            tProj.tri[0].x += 1.0f;
            tProj.tri[0].y += 1.0f;
            tProj.tri[1].x += 1.0f;
            tProj.tri[1].y += 1.0f;
            tProj.tri[2].x += 1.0f;
            tProj.tri[2].y += 1.0f;

            tProj.tri[0].x *= 0.5f * (float) width;
            tProj.tri[0].y *= 0.5f * (float) height;
            tProj.tri[1].x *= 0.5f * (float) width;
            tProj.tri[1].y *= 0.5f * (float) height;
            tProj.tri[2].x *= 0.5f * (float) width;
            tProj.tri[2].y *= 0.5f * (float) height;

            drawTriangle(tProj, g, drawColor);

        }

    }

    public void drawTriangle(Triangle t, Graphics g, Color c) {
        drawTriangle((int) t.tri[0].x, (int) t.tri[0].y, (int) t.tri[1].x, (int) t.tri[1]. y, (int) t.tri[2].x, (int) t.tri[2].y, g, c);
    }

    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g, Color c) {

        g.setColor(c);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

    }

    public void projectCoordinates() {

        float f = (float) (1 / (Math.tan(fieldOfView / 2)));
        float q = zFar / (zFar - zNear);



    }

    public Vector3D matMulVec(Vector3D vec, float[][] mat) {

        Vector3D out = new Vector3D(0, 0, 0);
        out.x = vec.x * mat[0][0] + vec.y * mat[1][0] + vec.z * mat[2][0] + mat[3][0];
        out.y = vec.x * mat[0][1] + vec.y * mat[1][1] + vec.z * mat[2][1] + mat[3][1];
        out.z = vec.x * mat[0][2] + vec.y * mat[1][2] + vec.z * mat[2][2] + mat[3][2];
        float w = vec.x * mat[0][3] + vec.y * mat[1][3] + vec.z * mat[2][3] + mat[3][3];

        if(w != 0.0f) {

            out.x /= w;
            out.y /= w;
            out.z /= w;

        }

        return out;
    }

}
