import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

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

//        for(Point p : arrayOfPoints) {
//            System.out.println(p);
//        }

        MergeSortForPoints msfp = new MergeSortForPoints();
        // sort wrt x
        Point[] X = arrayOfPoints.clone();
        msfp.mergeSort(X, 0);
        // sort wrt y
        Point[] Y = arrayOfPoints.clone();
        msfp.mergeSort(Y, 1);

        // finding the closest pair
        ClosestPair scp = new ClosestPair();
        double shortestDistance = scp.findClosestPair(X, Y);
        int index1 = ClosestPair.index1, index2 = ClosestPair.index2;

        System.out.println(index1 + " " + index2);
        System.out.println(shortestDistance);

//        // finding second closest pair
//        Point[] X1 = new Point[numberOfPoints-1];
//        Point[] Y1 = new Point[numberOfPoints-1];
//        for(int i=0; i<numberOfPoints-1; i++) {
//            if(i == index1) {
//                for(int j=i+1; j<numberOfPoints-1; j++) {
//                    X1[j] = new Point(X[++i]);
//                    Y1[j] = new Point(X[++i]);
//                }
//                break;
//            }
//            X1[i] = new Point(X[i]);
//            Y1[i] = new Point(X[i]);
//        }
//        msfp.mergeSort(Y1, 1);
//
////        Arrays.sort(Y1, Comparator.comparingInt(point -> point.y));
//
//        double shortestDistance1 = scp.findClosestPair(X1, Y1);
//
//        if(shortestDistance1 < shortestDistance) {
//            shortestDistance = shortestDistance1;
//            index1 = ClosestPair.index1; index2 = ClosestPair.index2;
//        }
//
//        Point[] X2 = new Point[numberOfPoints-1];
//        Point[] Y2 = new Point[numberOfPoints-1];
//        for(int i=0; i<numberOfPoints-1; i++) {
//            if(i == index2) {
//                for(int j=i+1; j<numberOfPoints-1; j++) {
//                    X2[j] = new Point(X[++i]);
//                    Y2[j] = new Point(X[++i]);
//                }
//                break;
//            }
//            X2[i] = new Point(X[i]);
//            Y2[i] = new Point(X[i]);
//        }
//        msfp.mergeSort(Y2, 1);
////        Arrays.sort(Y2, Comparator.comparingInt(point -> point.y));
//        double shortestDistance2 = scp.findClosestPair(X2, Y2);
//
//        if(shortestDistance2 < shortestDistance) {
//            shortestDistance = shortestDistance2;
//            index1 = ClosestPair.index1; index2 = ClosestPair.index2;
//        }
//
//        System.out.println(index1 + " " + index2);
//        System.out.println(shortestDistance);
    }
}
