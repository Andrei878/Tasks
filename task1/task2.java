import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: Need to attach two files");
            return;
        }

        String pathOfCircle = args[0];
        String pathOfPoints = args[1];
        File fileCircle = new File(pathOfCircle);
        File filePoints = new File(pathOfPoints);
        Scanner scCircle;
        Scanner scPoints;
        try {
            scCircle = new Scanner(fileCircle);
            scPoints = new Scanner(filePoints);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return;
        }
        float[] circle = new float[3];
        getCoordinatesOfCircle(circle, scCircle);
        ArrayList<Float> points = new ArrayList<>();
        getCoordinatesOfPoints(points, scPoints);
        float x;
        float y;
        int status;
        for(int k = 0; k < points.size(); k += 2) {
            x = points.get(k);
            y = points.get(k + 1);
            if ((status = checkInsideCircle(x, y, circle)) == 1 || status == 0) {
                if(status == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            System.out.println(2);
        }

    }
    static private int checkInsideCircle(float x, float y, float[] circle) {
        float n = 2.0f;
        float r = (float) Math.pow(circle[2], n);
        float inside = (float) (Math.pow((circle[0] - x), n) + Math.pow((circle[1] - y), n));
        if (inside > r)
            return 2;
        else if (inside == r)
            return 0;
        else
            return 1;
    }



    static private void getCoordinatesOfCircle(float[] Circle, Scanner sc) {
        int i = 0;
        while(sc.hasNext() && i < 3) {
            Circle[i] = Float.parseFloat(sc.next());
            i++;
        }
        if (i != 3) {
            System.out.println("Error: There should be two coordinates(x,y) of circle and one radius (r) in the File1");
            System.exit(0);
        }
    }
    static private void getCoordinatesOfPoints(ArrayList<Float> points, Scanner sc) {
        while(sc.hasNext()) {
            points.add(Float.parseFloat(sc.next()));
        }
        if (points.size() % 2 != 0) {
            System.out.println("Error: There should be two coordinates(x,y) for each point in the File2");
            System.exit(0);
        }
        if (points.size() > 200) {
            System.out.println("Error: There are too many points specified. There is no more space on the chart.");
            System.exit(0);
        }
    }
}
