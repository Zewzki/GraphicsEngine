package graphics;

public class Triangle {

    public Vector3D[] tri;

    public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
        tri = new Vector3D[] {p1, p2, p3};
    }

    public Triangle(Vector3D[] tri) {
        this.tri = tri;
    }

}
