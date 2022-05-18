import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    static void DepthFirstSearch(ArrayList<Integer>[] adjacencyList, int[] numberOfPiecesInEachCity, int[] friendsStartingLocation) {
        ArrayList<Integer> travelledCities = new ArrayList<>();
        int[] piecesCollectedByEachFriend = new int[friendsStartingLocation.length];
        int totalPieces = Common.calculateTotalPieces(numberOfPiecesInEachCity);
        int totalPiecesCollected = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < friendsStartingLocation.length; i++) {

            // Initialize root
            stack.push(friendsStartingLocation[i]);
            travelledCities.add(friendsStartingLocation[i]);

            while (!stack.isEmpty()) {
                int front = stack.peek();
                piecesCollectedByEachFriend[i] += numberOfPiecesInEachCity[front];
                numberOfPiecesInEachCity[front] = 0;    // Zeroing it so that other friends do not rediscover them
                
                boolean endOfThatCity = true;
                for (int x: adjacencyList[front]) {
                    if (!travelledCities.contains(x)) {
                        endOfThatCity = false;
                        travelledCities.add(x);
                        stack.push(x);
                        break;
                    }
                }
                if (endOfThatCity) {
                    stack.pop();
                }
            }
            totalPiecesCollected += piecesCollectedByEachFriend[i];
        }

        Common.printResult(totalPieces, totalPiecesCollected, piecesCollectedByEachFriend);
    }
}
