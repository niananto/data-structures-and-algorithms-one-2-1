import java.util.Scanner;

public class PillowPassingGame {
    private final Element head;
    private static Element current;
    private static int currentRemainingTime;
    private static int totalElapsedTime;
    private static String direction;
    private static int totalAttendedPlayers;

    public PillowPassingGame() {
        this.head = new Element();
    }

    public Element getHead() {
        return head;
    }

    private static Element findCurrent(int inputTime) {

        int totalRemainingTime = inputTime - totalElapsedTime;

        if (totalRemainingTime <= currentRemainingTime) {
            currentRemainingTime = currentRemainingTime - totalRemainingTime;
            totalElapsedTime = inputTime;

        } else {

            totalRemainingTime = totalRemainingTime - currentRemainingTime;
            while (true) {
                if (direction.equals("forward")) current = current.getNext();
                else current = current.getPrev();

                if (totalRemainingTime <= current.getReflex()) {
                    currentRemainingTime = current.getReflex() - totalRemainingTime;
                    totalElapsedTime = inputTime;

                    break;
                }

                totalRemainingTime = totalRemainingTime - current.getReflex();
            }
        }

        return current;
    }

    public static void main(String[] args) {

        PillowPassingGame ppg = new PillowPassingGame();

        Scanner sc = new Scanner(System.in);
        int numberOfPlayers = Integer.parseInt(sc.nextLine());

        String[] reflexesS = sc.nextLine().split(" ");
        int[] reflexes = new int[reflexesS.length];
        for (int i = 0; i < reflexes.length; i++) {
            reflexes[i] = Integer.parseInt(reflexesS[i]);
        }

        current = ppg.getHead();
        current.setValue(1);
        current.setReflex(reflexes[0]);

        current.setPrev(current);
        current.setNext(current);

        currentRemainingTime = ppg.getHead().getReflex();
        totalElapsedTime = 0;
        direction = "forward";
        totalAttendedPlayers = numberOfPlayers;

        for (int i = 1; i < numberOfPlayers; i++) {
            current.addElementAfter(new Element());
            current = current.getNext();
            current.setValue(i+1);
            current.setReflex(reflexes[i]);
        }
        current.setNext(ppg.getHead());
        ppg.getHead().setPrev(current);

        current = ppg.getHead();

        label:
        while (true) {
            String[] inputs = sc.nextLine().split(" ");
            int inputTime = Integer.parseInt(inputs[0]);
            String inputCommand = inputs[1];

            findCurrent(inputTime);

            switch (inputCommand) {
                case "M": {

                    System.out.println("Player " + current.getValue() + " has been eliminated at t=" + inputTime);

                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    --numberOfPlayers;

                    if (direction.equals("forward")) current = current.getNext();
                    else current = current.getPrev();
                    currentRemainingTime = current.getReflex();

                    break;
                }

                case "R": {

                    if (direction.equals("forward")) direction = "reverse";
                    else direction = "forward";

                    break;
                }

                case "I": {

                    int inputReflex = Integer.parseInt(inputs[2]);

                    if (direction.equals("forward")) {
                        current.addElementBefore(new Element((++totalAttendedPlayers), inputReflex));
                    } else {
                        current.addElementAfter(new Element((++totalAttendedPlayers), inputReflex));
                    }
                    ++numberOfPlayers;

                    break;
                }

                case "P": {

                    System.out.println("Player " + current.getValue() + " is holding the pillow at t=" + inputTime);

                    break;
                }

                case "F": {

                    String printStatement = "Game over : Player " + current.getValue()
                            + " is holding the pillow at t=" + inputTime + ", pillow passing sequence :";

                    for (int i = 0; i < numberOfPlayers; i++) {
                        printStatement = printStatement + ' ' + current.getValue();

                        if (direction.equals("forward")) current = current.getNext();
                        else current = current.getPrev();
                    }

                    System.out.println(printStatement);
                    break label;
                }
            }

            if (numberOfPlayers == 1) {
                System.out.println("Game over : Player " + current.getValue() + " wins!!");
                break;
            }
        }
    }
}
