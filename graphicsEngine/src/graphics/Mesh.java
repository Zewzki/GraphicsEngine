package graphics;

import java.io.*;
import java.util.ArrayList;

public class Mesh {

    public ArrayList<Triangle> mesh;

    public Mesh() {
        mesh = new ArrayList<>();
    }

    public Mesh(ArrayList<Triangle> mesh) {
        this.mesh = mesh;
    }

    public Mesh(String path) {

        mesh = new ArrayList<>();

        BufferedReader reader;
        File f = new File(path);

        try {

            reader = new BufferedReader(new FileReader(f));

        } catch (FileNotFoundException e) {
            System.err.println("Could not open file: " + f.getAbsolutePath());
            return;
        }

        String line;
        int lineNum = 0;

        try {

            while((line = reader.readLine()) != null) {

                if(line.charAt(0) == '/') {
                    lineNum++;
                    continue;
                }

                line = line.replace("(", "");
                line = line.replace(")", "");
                String[] vals = line.split(",");

                if(vals.length != 9) {
                    System.err.println("Error reading line " + lineNum + ". Expected 9 arguments and received " + line);
                    lineNum++;
                    continue;
                }

                Vector3D[] vecs = new Vector3D[3];

                for(int i = 0; i < 3; i++) {
                    vecs[i] = new Vector3D(Float.parseFloat(vals[i]), Float.parseFloat(vals[i + 1]), Float.parseFloat(vals[i + 2]));
                }

                mesh.add(new Triangle(vecs[0], vecs[1], vecs[2]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addTriangle(Triangle triangle) { mesh.add(triangle); }

}
