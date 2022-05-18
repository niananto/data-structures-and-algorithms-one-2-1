public class Common {
    static int calculateTotalPieces(int[] numberOfPiecesInEachCity) {
        int totalPieces = 0;
        for (int j : numberOfPiecesInEachCity) {
            totalPieces += j;
        }
        return totalPieces;
    }

    static void printResult(int totalPieces, int totalPiecesCollected, int[] piecesCollectedByEachFriend) {
        if (totalPiecesCollected < totalPieces) {
            System.out.println("Mission Impossible");
        } else {
            System.out.println("Mission Accomplished");
        }
        System.out.println(totalPiecesCollected + " out of " + totalPieces + " are collected");
        for (int i = 0; i < piecesCollectedByEachFriend.length; i++) {
            System.out.println(i + " collected " + piecesCollectedByEachFriend[i] + " pieces");
        }
    }
}
