package graphics;

public class Vector3D {

    public float x, y, z;

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(float[] coords) {
        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
    }

}
