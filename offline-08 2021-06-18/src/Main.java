import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./points.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String currentLine;
        int numberOfPoints = 0;

        // first line
        try {
            currentLine = br.readLine();
            numberOfPoints = Integer.parseInt(currentLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Point[] arrayOfPoints = new Point[numberOfPoints];

        // other lines
        for(int i=0; i<numberOfPoints; i++) {
            try {
                currentLine = br.readLine();
                if (currentLine == null) break;

                String[] coordinates = currentLine.split(" ", 2);
                arrayOfPoints[i] = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), i);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("arrayOfPoints");
        for(Point p : arrayOfPoints) System.out.println(p);

        // sort wrt x and y
        Point[] X = arrayOfPoints.clone();
        MergeSortForPoints.mergeSort(X, 0);
        Point[] Y = arrayOfPoints.clone();
        MergeSortForPoints.mergeSort(Y, 1);

        // finding the closest pair
        double shortestDistance = ClosestPair.findClosestPair(X, Y);
        int index1 = ClosestPair.index1, index2 = ClosestPair.index2;

        System.out.println("Closest Pair");
        System.out.println(index1 + " " + index2);
        System.out.println(shortestDistance);

        // finding the closest pair without index1
        Point[] arrayOfPoints1 = new Point[numberOfPoints-1];
        System.arraycopy(arrayOfPoints, 0, arrayOfPoints1, 0, index1);
        System.arraycopy(arrayOfPoints, index1+1, arrayOfPoints1, index1, numberOfPoints-index1-1);
        Point[] X1 = arrayOfPoints1.clone();
        MergeSortForPoints.mergeSort(X1, 0);
        Point[] Y1 = arrayOfPoints1.clone();
        MergeSortForPoints.mergeSort(Y1, 1);

        System.out.println("X1");
        for(Point p : X1) System.out.println(p);
        System.out.println("Y1");
        for(Point p : Y1) System.out.println(p);

        double shortestDistance1 = ClosestPair.findClosestPair(X1, Y1);
        int index1_1 = ClosestPair.index1, index2_1 = ClosestPair.index2;
        System.out.println("shortestDistance1");
        System.out.println(index1_1 + " " + index2_1);
        System.out.println(shortestDistance1);

        // finding the closest pair without index2
        Point[] arrayOfPoints2 = new Point[numberOfPoints-1];
        System.arraycopy(arrayOfPoints, 0, arrayOfPoints2, 0, index2);
        System.arraycopy(arrayOfPoints, index2+1, arrayOfPoints2, index2, numberOfPoints-index2-1);
        Point[] X2 = arrayOfPoints2.clone();
        MergeSortForPoints.mergeSort(X2, 0);
        Point[] Y2 = arrayOfPoints2.clone();
        MergeSortForPoints.mergeSort(Y2, 1);

        System.out.println("X2");
        for(Point p : X2) System.out.println(p);
        System.out.println("Y2");
        for(Point p : Y2) System.out.println(p);

        double shortestDistance2 = ClosestPair.findClosestPair(X2, Y2);
        int index1_2 = ClosestPair.index1, index2_2 = ClosestPair.index2;
        System.out.println("shortestDistance2");
        System.out.println(index1_2 + " " + index2_2);
        System.out.println(shortestDistance2);

        // comparing these two
        System.out.println("Second closest pair");
        if (shortestDistance1 < shortestDistance2) {
            System.out.println(index1_1 + " " + index2_1);
            System.out.println(shortestDistance1);
        } else {
            System.out.println(index1_2 + " " + index2_2);
            System.out.println(shortestDistance2);
        }
    }
}
