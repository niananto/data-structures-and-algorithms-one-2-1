import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPair {
    static int index1, index2;

    double findClosestPair(Point[] X, Point[] Y) {
        int n = X.length;

        // base case
        if(n==2) {
            index1 = 0; index2 = 1;
            return X[0].distance(X[1]);
        }
        if(n==3) {
            double min = X[0].distance(X[1]);
            index1 = 0; index2 = 1;
            if(X[1].distance(X[2]) < min) {
                min = X[1].distance(X[2]);
                index1 = 1; index2 = 2;
            }
            if(X[2].distance(X[0]) < min) {
                min = X[2].distance(X[0]);
                index1 = 2; index2 = 0;
            }
            return min;
        }

        //divide
        int mid = n/2;
        double leftShortestDistance = findClosestPair(Arrays.copyOfRange(X,0, mid), Y);
        double rightShortestDistance = findClosestPair(Arrays.copyOfRange(X, mid, n), Y);
        double shortestDistance = Math.min(leftShortestDistance, rightShortestDistance);
//        System.out.println(shortestDistance);

        // combine
        ArrayList<Point> S = new ArrayList<>();
        for(Point p : X) {
            if (p.getX() >= (X[mid].getX() - shortestDistance) && p.getX() <= (X[mid].getX() + shortestDistance)) {
                S.add(p);
            }
        }

//        for(Point p : S) System.out.println(p);

        for(int i=0; i<S.size(); i++) {
            for(int j=i+1; j<8; j++) {
                if (i+j >= S.size()) continue;
                shortestDistance = Math.min(shortestDistance, S.get(i).distance(S.get(i+j)));
                index1 = S.get(i).getIndex(); index2 = S.get(i+j).getIndex();
            }
        }

        return shortestDistance;
    }
}
