import java.util.Arrays;

public class MergeSort {
    private boolean compare(int a, int b) {
        return a < b;
    }

    private void merge(int[] arr1, int[] arr2, int arr[]) {
        int i=0, j=0;
        while (i+j < arr.length) {
            if (j == arr2.length || (i < arr1.length && compare(arr1[i], arr2[j]))) {
                arr[i+j] = arr1[i++];
            } else {
                arr[i+j] = arr2[j++];
            }
        }
    }

    void mergeSort(int[] arr) {
        int n = arr.length;

        // base case
        if (n < 2) return;

        // divide
        int mid = n/2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        int[] arr2 = Arrays.copyOfRange(arr, mid, n);

        // conquer
        mergeSort(arr1);
        mergeSort(arr2);

        // combine
        merge(arr1, arr2, arr);
    }
}
