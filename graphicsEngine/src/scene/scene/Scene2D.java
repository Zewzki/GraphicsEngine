package scene.scene;

import scene.object.GraphicsObject;

import java.util.ArrayList;

public class Scene2D {

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    private ArrayList<GraphicsObject> objects;

    public Scene2D(int minX, int minY, int maxX, int maxY) {

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

        objects = new ArrayList<>();

    }

    public void addObject(GraphicsObject obj) { objects.add(obj); }

    public int getMinX() { return minX; }
    public int getMinY() { return minY; }
    public int getMaxX() { return maxX; }
    public int getMaxY() { return maxY; }

}
