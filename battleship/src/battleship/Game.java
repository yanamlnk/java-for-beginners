package battleship;

import java.util.Scanner;

class Game {

    static Scanner sc = new Scanner(System.in);
    static Player player1 = new Player(1);
    static Player player2 = new Player(2);

    public static void startTheGame() {
        setUpTheField(player1);
        if (Checker.showPromptToAnotherPlayer()) {
            setUpTheField(player2);
        }
        shooting();
    }

    static void setUpTheField(Player player) {
        System.out.printf("Player %d, place your ships on the game field%n", player.getNumberOfPlayer());
        int order = 1;
        while (order < 6) {
            player.outputBattleField();
            System.out.printf("Enter the coordinates of the %s (%d cells):%n", Fleet.getShipByPosition(order).name, Fleet.getShipByPosition(order).length);
            while (true) {
                String input = sc.nextLine();
                if (Checker.shipCoordinatesCorrect(input, Fleet.getShipByPosition(order), player)) {
                    player.setBattleField(Checker.shipPositionArray(input));
                    player.setBattleShip(Checker.shipPositionArray(input), Fleet.getShipByPosition(order));
                    order++;
                    break;
                }
            }
        }
        player.outputBattleField();
    }

    static void shooting() {
        int order = 1;
        while(true) {
            if (Checker.shipsPresent(getObjectByOrder(order))) {
                Checker.showPromptToAnotherPlayer();
                getObjectByOrder(order == 1? 2 : 1).outputFoggyBattleField();
                System.out.println("---------------------");
                getObjectByOrder(order).outputBattleField();
                System.out.printf("Player %d, it's your turn:%n", order);
                getObjectByOrder(order == 1? 2 : 1).shot(sc.nextLine());
                if (order == 1) {
                    order++;
                } else {
                    order--;
                }
            } else {
                sc.close();
                break;
            }
        }
    }
    private static Player getObjectByOrder(int order) {
        if (order == 1) {
            return player1;
        } else {
            return player2;
        }
    }
}
