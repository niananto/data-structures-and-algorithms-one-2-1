import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        FileWriter fw;
        try {
            fw = new FileWriter(new File("../Reports CSV 3.csv"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        BufferedWriter bw = new BufferedWriter(fw);

        int numberOfIter = 10;
        int maxInputLength = 1000000;

        for (int order = 1; order <= 3; order++) {
            double m = 1;
            while (m <= 6) {
                int n = (int)Math.pow(10, m);

                long[] msTimeRecords = new long[numberOfIter];
                long[] qsTimeRecords = new long[numberOfIter];
                for (int k = 0; k < numberOfIter; k++) {
                    int[] arr;
                    if (order == 1) {
                        arr = generateAscendingRandom(n);
                    } else if (order == 2) {
                        arr = generateDescendingRandom(n);
                    } else {
                        arr = generateRandom(n);
                    }

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
                    System.out.println("\nQuick Sort took " + qsTimeRecords[k] + " microseconds");
                }

                OptionalDouble msAverageTime = Arrays.stream(msTimeRecords).average();
                System.out.println("Merge Sort average time " + msAverageTime.getAsDouble() + "\n");
                OptionalDouble qsAverageTime = Arrays.stream(qsTimeRecords).average();
                System.out.println("Quick Sort average time " + qsAverageTime.getAsDouble() + "\n");

                if (order == 1) {
                    try {
                        bw.write("ascending," + m +"," + msAverageTime.getAsDouble() + "," + qsAverageTime.getAsDouble() +"\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (order == 2) {
                    try {
                        bw.write("descending," + m +"," + msAverageTime.getAsDouble() + "," + qsAverageTime.getAsDouble() +"\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        bw.write("random," + m +"," + msAverageTime.getAsDouble() + "," + qsAverageTime.getAsDouble() +"\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                m = m + 0.25;

            }
        }
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

    private static int[] generateDescendingRandom(int amount) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        double delta = 10;
        for (int i = 0; i < amount; i++) {
            randomNumbers[amount-i-1] = (int)Math.round(i*delta + random.nextDouble() * delta);
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
