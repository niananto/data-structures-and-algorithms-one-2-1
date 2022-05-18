import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // CRLF Input
        int[] crlfInput = new int[4];
        for (int i = 0; i < 4; i++) {
            crlfInput[i] = scanner.nextInt();
        }

        // Adjacency List
        ArrayList<Integer>[] adjacencyList = new ArrayList[crlfInput[0]];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Roads
        for (int i = 0; i < crlfInput[1]; i++) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            if (!adjacencyList[c2].contains(c1))
                adjacencyList[c2].add(c1);
            if (!adjacencyList[c1].contains(c2))
                adjacencyList[c1].add(c2);
        }

        // Pieces
        int[] numberOfPiecesInEachCity = new int[crlfInput[0]];
        for (int i = 0; i < crlfInput[2]; i++) {
            int location = scanner.nextInt();
            int pieces = scanner.nextInt();
            numberOfPiecesInEachCity[location] = pieces;
        }

        // Friends' starting location
        int[] friendsStartingLocation = new int[crlfInput[3]];
        for (int i = 0; i < crlfInput[3]; i++) {
            int location = scanner.nextInt();
            int friend = scanner.nextInt();
            friendsStartingLocation[friend] = location;
        }

        // BFS
        System.out.println("\nBFS");
        BFS.BreadthFirstSearch(adjacencyList, numberOfPiecesInEachCity.clone(), friendsStartingLocation);

        // DFS
        System.out.println("\nDFS");
        DFS.DepthFirstSearch(adjacencyList, numberOfPiecesInEachCity.clone(), friendsStartingLocation);
    }
}