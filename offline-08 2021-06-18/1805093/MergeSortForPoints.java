import java.util.Arrays;

public class MergeSortForPoints {
    private boolean compare(Point a, Point b, int wrtXorY) {
        if(wrtXorY == 0) {
            return a.getX() < b.getX();
        } else {
            return a.getY() < b.getY();
        }
    }

    private void merge(Point[] arr1, Point[] arr2, Point arr[], int wrtXorY) {
        int i=0, j=0;
        while (i+j < arr.length) {
            if (j == arr2.length || (i < arr1.length && compare(arr1[i], arr2[j], wrtXorY))) {
                arr[i+j] = arr1[i++];
            } else {
                arr[i+j] = arr2[j++];
            }
        }
    }

    void mergeSort(Point[] arr, int wrtXorY) {
        int n = arr.length;

        // base case
        if (n < 2) return;

        // divide
        int mid = n/2;
        Point[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        Point[] arr2 = Arrays.copyOfRange(arr, mid, n);

        // conquer
        mergeSort(arr1, wrtXorY);
        mergeSort(arr2, wrtXorY);

        // combine
        merge(arr1, arr2, arr, wrtXorY);
    }
}
