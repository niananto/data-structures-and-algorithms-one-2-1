public class QuickSort {
    private boolean compare(int a, int b) {
        return a < b;
    }

    private void quickSort(int[] arr, int start, int end) {
        // base case
        if (start >= end) return;

        int left = start;
        int right = end-1;
        int pivot = arr[end];

        while (left <= right) {
            // making sure the ones at the left are smaller than pivot
            // and the ones at the right are bigger
            while (left <= right && compare(arr[left], pivot)) {
                left ++;
            }
            while (left <= right && compare(pivot, arr[right])) {
                right --;
            }

            // whenever the ones at the left are bigger than pivot
            // and the ones at the right are smaller
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }
        }

        // placing pivot in its position
        int temp = arr[left];
        arr[left] = arr[end];
        arr[end] = temp;

        // making recursive calls excluding current pivot
        quickSort(arr, start, left-1);
        quickSort(arr, left+1, end);
    }

    void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
}
