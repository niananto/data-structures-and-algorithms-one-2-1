import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void BreadthFirstSearch(ArrayList<Integer>[] adjacencyList, int[] numberOfPiecesInEachCity, int[] friendsStartingLocation) {
        ArrayList<Integer> travelledCities = new ArrayList<>();
        int[] piecesCollectedByEachFriend = new int[friendsStartingLocation.length];
        int totalPieces = Common.calculateTotalPieces(numberOfPiecesInEachCity);
        int totalPiecesCollected = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < friendsStartingLocation.length; i++) {

            // Initialize root
            queue.add(friendsStartingLocation[i]);
            travelledCities.add(friendsStartingLocation[i]);

            while (!queue.isEmpty()) {
                int front = queue.remove();
                piecesCollectedByEachFriend[i] += numberOfPiecesInEachCity[front];
                numberOfPiecesInEachCity[front] = 0;    // Zeroing it so that other friends do not rediscover them

                for (int x : adjacencyList[front]) {
                    if (!travelledCities.contains(x)) {
                        queue.add(x);
                        travelledCities.add(x);
                    }
                }
            }
            totalPiecesCollected += piecesCollectedByEachFriend[i];
        }

        Common.printResult(totalPieces, totalPiecesCollected, piecesCollectedByEachFriend);
    }
}