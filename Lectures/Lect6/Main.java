import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader(args[0]);
            Scanner sc = new Scanner(file);
            Point[] points = new Point[sc.nextInt()];
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point(sc.nextDouble(), sc.nextDouble());
                System.out.println(points[i]);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file " + args[0] + "\n" + ex);
        }
    }
}