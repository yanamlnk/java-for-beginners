package battleship;

import java.io.IOException;

class Checker {

    static boolean showPromptToAnotherPlayer() {
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            while ((char)System.in.read()!= '\n') {
                continue;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    static boolean shipCoordinatesCorrect(String input, Fleet ship, BattleField battleField) {
        if (inputIsCorrect(input)) {
            if (shapeIsCorrect(input)) {
                if (lengthIsCorrect(input, ship)) {
                    return positionIsCorrect(input, battleField);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static boolean shipsPresent(Player player) {
        for (int i = 0; i < player.getBattleField().length; i++) {
            for (int j = 0; j < player.getBattleField()[i].length; j++) {
                if ("O".equals(player.getBattleField()[i][j])) {
                    return true;
                }
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
        return false;
    }

    static String isShipDestroyed (String[] ship) {
        int counter = 0;
        for (String s : ship) {
            if ("X".equals(s)) {
                counter++;
            }
        }
        if (counter == ship.length) {
            return "You sank a ship!";
        }
        return "You hit a ship!";
    }

    static boolean inputIsCorrect(String input) {
        String[] inputArray = input.split(" ");
        int count = 0;
        if (inputArray.length == 2) {
            for (String s : inputArray) {
                for (int j = 1; j < BattleField.positionBattleField.length; j++) {
                    for (int k = 1; k < BattleField.positionBattleField[j].length; k++) {
                        if (s.equals(BattleField.positionBattleField[j][k])) {
                            count++;
                        }
                    }
                }
            }
            if (count == 2) {
                return true;
            }
        } else if (inputArray.length == 1) {
            for (String s : inputArray) {
                for (int j = 1; j < BattleField.positionBattleField.length; j++) {
                    for (int k = 1; k < BattleField.positionBattleField[j].length; k++) {
                        if (s.equals(BattleField.positionBattleField[j][k])) {
                            count++;
                        }
                    }
                }
            }
            if (count == 1) {
                return true;
            }
        }
        System.out.println("Error! Incorrect input. Range must be between A-J and 1-10! Try again:");
        return false;
    }

    static boolean shapeIsCorrect(String input){
        int[] positions = shipPositionArray(input);
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];
        if ((startRow == endRow) == (startColumn == endColumn)) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        return true;
    }

    static boolean lengthIsCorrect(String input, Fleet ship) {
        int[] positions = shipPositionArray(input);
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];


        if (startColumn == endColumn) {
            if ((endRow - startRow) + 1 == ship.length) {
                return true;
            } else {
                System.out.println("Error! Wrong length of " + ship.name + "! Try again:");
                return false;
            }
        } else {
            if ((endColumn - startColumn) + 1 == ship.length) {
                return true;
            } else {
                System.out.println("Error! Wrong length of " + ship.name + "! Try again:");
                return false;
            }
        }
    }

    static boolean positionIsCorrect(String input, BattleField battleField) {
        int[] positions = shipPositionArray(input);
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        String[][] field = battleField.getBattleField();

        if (startRow == endRow && startRow != 10 && endColumn != 10) {
            for (int i = startRow - 1; i <= startRow + 1; i++) {
                for (int j = startColumn - 1; j <= endColumn + 1; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startRow == endRow && startRow == 10 && endColumn != 10) {
            for (int i = startRow - 1; i <= startRow; i++) {
                for (int j = startColumn - 1; j <= endColumn + 1; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startRow == endRow && startRow != 10 && endColumn == 10) {
            for (int i = startRow - 1; i <= startRow + 1; i++) {
                for (int j = startColumn - 1; j <= endColumn; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startRow == endRow && startRow == 10 && endColumn == 10) {
            for (int i = startRow - 1; i <= startRow; i++) {
                for (int j = startColumn - 1; j <= endColumn; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startColumn == endColumn && startColumn != 10 && endRow != 10) {
            for (int i = startRow - 1; i <= endRow + 1; i++) {
                for (int j = startColumn - 1; j <= startColumn + 1; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startColumn == endColumn && startColumn == 10 && endRow != 10) {
            for (int i = startRow - 1; i <= endRow + 1; i++) {
                for (int j = startColumn - 1; j <= startColumn; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startColumn == endColumn && startColumn != 10 && endRow == 10) {
            for (int i = startRow - 1; i <= endRow; i++) {
                for (int j = startColumn - 1; j <= startColumn + 1; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        } else if (startColumn == endColumn && startColumn == 10 && endRow == 10) {
            for (int i = startRow - 1; i <= endRow; i++) {
                for (int j = startColumn - 1; j <= startColumn; j++) {
                    if ("O".equals(field[i][j])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // returns an array taken from input. Format is [Row1, Column1, Row2, Column2], where Row1<Row2 && Column1 < Column2
    static int[] shipPositionArray (String input) {
        int[] output = new int[4];
        String[] array = input.split(" ");
        int row1 = 0;
        int column1 = 0;
        int row2 = 0;
        int column2 = 0;

        for (int j = 1; j < BattleField.positionBattleField.length; j++) {
            for (int k = 1; k < BattleField.positionBattleField[j].length; k++) {
                if (array[0].equals(BattleField.positionBattleField[j][k])) {
                    row1 = j;
                    column1 = k;
                }
            }
        }

        for (int j = 1; j < BattleField.positionBattleField.length; j++) {
            for (int k = 1; k < BattleField.positionBattleField[j].length; k++) {
                if (array[1].equals(BattleField.positionBattleField[j][k])) {
                    row2 = j;
                    column2 = k;
                }
            }
        }
        output[0] = Math.min(row1, row2);
        output[1] = Math.min(column1, column2);
        output[2] = Math.max(row1, row2);
        output[3] = Math.max(column1, column2);

        return output;
    }

    // returns an array taken from input. Format is [Row1, Column1]
    static int[] shotPositionArray(String input) {
        int[] output = new int[2];

        for (int j = 1; j < BattleField.positionBattleField.length; j++) {
            for (int k = 1; k < BattleField.positionBattleField[j].length; k++) {
                if (input.equals(BattleField.positionBattleField[j][k])) {
                    output[0] = j;
                    output[1] = k;
                }
            }
        }
        return output;
    }
}