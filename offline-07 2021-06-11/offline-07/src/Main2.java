import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {

        int numberOfIter = 10;
        long[] msTimeRecords = new long[numberOfIter];
        long[] qsTimeRecords = new long[numberOfIter];
        for (int k = 0; k < numberOfIter; k++) {

            int n = 1000000;
            int[] arr = generateAscendingRandom(n);

//            System.out.println("\nInput Array:");
//            for (int x: arr) {
//                System.out.println(x);
//            }

            MergeSort ms = new MergeSort();
            int[] msArr = arr.clone();
            long msStartTime = System.nanoTime();
            ms.mergeSort(msArr);
            long msEndTime = System.nanoTime();

            QuickSort qs = new QuickSort();
            int[] qsArr = arr.clone();
            long qsStartTime = System.nanoTime();
            qs.quickSort(qsArr);
            long qsEndTime = System.nanoTime();

//            System.out.println("\nMerge Sort \t\tQuick Sort");
//            for (int i=0; i<n; i++) {
//                System.out.println(msArr[i] + "\t\t\t\t" + qsArr[i]);
//            }

            msTimeRecords[k] = (msEndTime - msStartTime)/1000;
            qsTimeRecords[k] = (qsEndTime - qsStartTime)/1000;

            System.out.println("\nMerge Sort took " + msTimeRecords[k] + " microseconds");
            System.out.println("Quick Sort took " + qsTimeRecords[k] + " microseconds");
        }

        OptionalDouble msAverageTime = Arrays.stream(msTimeRecords).average();
        System.out.println("\nMerge Sort average time " + msAverageTime.getAsDouble() + " microseconds");
        OptionalDouble qsAverageTime = Arrays.stream(qsTimeRecords).average();
        System.out.println("Quick Sort average time " + qsAverageTime.getAsDouble() + " microseconds");
    }

    private static int[] generateAscendingRandom(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
//        randomNumbers[0] = Math.abs(random.nextInt());
//        for (int i = 1; i < amount; i++) {
//            randomNumbers[i] = Math.abs(randomNumbers[i-1] + Math.abs(random.nextInt()));
//        }
        double delta = max / (float)amount;
        for (int i = 0; i < amount; i++) {
            randomNumbers[i] = (int)Math.round(i*delta + random.nextDouble() * delta);
        }
        return randomNumbers;
    }

    private static int[] generateAscendingRandom(int amount) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        double delta = 10;
        for (int i = 0; i < amount; i++) {
            randomNumbers[i] = (int)Math.round(i*delta + random.nextDouble() * delta);
        }
        return randomNumbers;
    }

    private static int[] generateDescendingRandom(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        double delta = max / (float)amount;
        for (int i = 0; i < amount; i++) {
            randomNumbers[amount-i-1] = (int)Math.round(i*delta + random.nextDouble() * delta);
        }
        return randomNumbers;
    }

    private static int[] generateDescendingRandom(int amount) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        double delta = 10;
        for (int i = 0; i < amount; i++) {
            randomNumbers[amount-i-1] = (int)Math.round(i*delta + random.nextDouble() * delta);
        }
        return randomNumbers;
    }

    private static int[] generateRandom(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            randomNumbers[i] = random.nextInt(max);
        }
        return randomNumbers;
    }

    private static int[] generateRandom(int amount) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            randomNumbers[i] = random.nextInt();
        }
        return randomNumbers;
    }
}
