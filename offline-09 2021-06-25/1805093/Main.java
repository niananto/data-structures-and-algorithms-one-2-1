import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input
        String[] inputFirstLine = sc.nextLine().split(" ");
        int numberOfPlants = Integer.parseInt(inputFirstLine[0]);
        int numberOfFriends = Integer.parseInt(inputFirstLine[1]);

        String[] inputSecondLine = sc.nextLine().split(" ");
        int[] priceOfPlants = new int[numberOfPlants];
        for (int i = 0; i < numberOfPlants; i++) {
            priceOfPlants[i] = Integer.parseInt(inputSecondLine[i]);
        }

        // sorting the prices in descending order
        QuickSort.quickSort(priceOfPlants);

        // calculating the minimum price
        int minimumPrice = 0;
        int i = 0; // this will be the flag for numberOfFriends
        int j = 0; // this will be the flag for numberOfPlants
        int priceFactor = 0;
        while (j < numberOfPlants) {
            minimumPrice += (priceFactor + 1) * priceOfPlants[j];

            priceFactor = (++i) / numberOfFriends;
            j++;
        }

        // output
        System.out.println(minimumPrice);
    }
}
