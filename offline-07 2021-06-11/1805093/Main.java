import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("What should be the length of the array, Master Wayne?");
            int n = sc.nextInt();
            if (n == 0) return;

            int[] arr;
            System.out.println("So you want an array of length " + n +
                    "\nNow should I generate it in" +
                    "\n(1) Ascending Order or" +
                    "\n(2) Descending Order or" +
                    "\n(3) Random Order ?");
            int orderInput = sc.nextInt();

            if (orderInput == 1) {
//                arr = generateAscendingRandom(n,200);
                arr = generateAscendingRandom(n);
            } else if (orderInput == 2) {
//                arr = generateDescendingRandom(n, 200);
                arr = generateDescendingRandom(n);
            } else if (orderInput == 3) {
//                arr = generateRandom(n, 200);
                arr = generateRandom(n);
            } else {
                return;
            }

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

            System.out.println("\nMerge Sort \t\tQuick Sort");
            for (int i=0; i<n; i++) {
                System.out.println(msArr[i] + "\t\t\t\t" + qsArr[i]);
            }

            System.out.println("\nMerge Sort took " + (msEndTime - msStartTime) + " nanoseconds");
            System.out.println("\nQuick Sort took " + (qsEndTime - qsStartTime) + " nanoseconds");
        }
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
