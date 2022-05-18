import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPair {
    static int index1, index2;

    static double findClosestPair(Point[] X, Point[] Y) {
        int n = X.length;

        // base case
        if(n==2) {
            index1 = X[0].getIndex(); index2 = X[1].getIndex();
            return X[0].distance(X[1]);
        }
        if(n==3) {
            index1 = X[0].getIndex(); index2 = X[1].getIndex();
            double min = X[0].distance(X[1]);
            if(X[1].distance(X[2]) < min) {
                index1 = X[1].getIndex(); index2 = X[2].getIndex();
                min = X[1].distance(X[2]);
            }
            if(X[2].distance(X[0]) < min) {
                index1 = X[2].getIndex(); index2 = X[0].getIndex();
                min = X[2].distance(X[0]);
            }
            return min;
        }

        //divide
        int mid = n/2;
        double leftShortestDistance = findClosestPair(Arrays.copyOfRange(X,0, mid), Y);
        double rightShortestDistance = findClosestPair(Arrays.copyOfRange(X, mid, n), Y);
        double shortestDistance = Math.min(leftShortestDistance, rightShortestDistance);

        // combine
        ArrayList<Point> S = new ArrayList<>();
        for(Point p : X) {
            if (p.getX() >= (X[mid].getX() - shortestDistance) && p.getX() <= (X[mid].getX() + shortestDistance)) {
                S.add(p);
            }
        }

        for(int i=0; i<S.size(); i++) {
            for(int j=i+1; i+j<S.size(); j++) {
//                if (Math.abs(S.get(i).getY()-S.get(i+j).getY()) > shortestDistance) continue;
                double couldBeShortestDistance = S.get(i).distance(S.get(i+j));
                if(shortestDistance > couldBeShortestDistance) {
                    shortestDistance = couldBeShortestDistance;
                    index1 = S.get(i).getIndex(); index2 = S.get(i+j).getIndex();
                }
            }
        }

        return shortestDistance;
    }
}
