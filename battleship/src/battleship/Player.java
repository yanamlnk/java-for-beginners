package battleship;

class Player extends BattleField {
    String[] aircraftCarrier = new String[Fleet.AIRCRAFT.length];
    String[] battleship = new String[Fleet.BATTLESHIP.length];
    String[] submarine = new String[Fleet.SUBMARINE.length];
    String[] cruiser = new String[Fleet.CRUISER.length];
    String[] destroyer = new String[Fleet.DESTROYER.length];
    String[][] fleet = {aircraftCarrier, battleship, submarine, cruiser, destroyer};
    int numberOfPlayer;

    public Player(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    void setBattleShip(int[] positions, Fleet ship) {
        switch(ship) {
            case AIRCRAFT: setAircraftCarrier(positions); break;
            case SUBMARINE: setSubmarine(positions); break;
            case BATTLESHIP: setBattleship(positions); break;
            case CRUISER: setCruiser(positions); break;
            case DESTROYER: setDestroyer(positions); break;
        }
    }

    void shotShip(String input) {
        for (int i = 0; i < fleet.length; i++) {
            for (int j = 0; j < fleet[i].length; j++) {
                if (input.equals(fleet[i][j])) {
                    fleet[i][j] = "X";
                    System.out.println(Checker.isShipDestroyed(fleet[i]));
                }
            }
        }
    }

    void shot(String input) {
        int[] coordinates = Checker.shotPositionArray(input);
        int row = coordinates[0];
        int column = coordinates[1];

        if ("O".equals(battleField[row][column]) || "X".equals(battleField[row][column])) {
            foggyBattleField[row][column] = "X";
            battleField[row][column] = "X";
            shotShip(input);
        } else {
            foggyBattleField[row][column] = "M";
            battleField[row][column] = "M";
            System.out.println("You missed!");
        }
    }

    void setAircraftCarrier(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        int i = 0;
        if (startRow == endRow) {
            for (int j = startColumn; j <= endColumn; j++) {
                aircraftCarrier[i] = BattleField.positionBattleField[startRow][j];
                if (i < aircraftCarrier.length - 1) {
                    i++;
                }
            }
        } else {
            for (int j = startRow; j <= endRow; j++) {
                aircraftCarrier[i] = BattleField.positionBattleField[j][startColumn];
                if (i < aircraftCarrier.length - 1) {
                    i++;
                }
            }
        }
    }

    void setBattleship(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        int i = 0;
        if (startRow == endRow) {
            for (int j = startColumn; j <= endColumn; j++) {
                battleship[i] = BattleField.positionBattleField[startRow][j];
                if (i < battleship.length - 1) {
                    i++;
                }
            }
        } else {
            for (int j = startRow; j <= endRow; j++) {
                battleship[i] = BattleField.positionBattleField[j][startColumn];
                if (i < battleship.length - 1) {
                    i++;
                }
            }
        }
    }

    void setSubmarine(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        int i = 0;
        if (startRow == endRow) {
            for (int j = startColumn; j <= endColumn; j++) {
                submarine[i] = BattleField.positionBattleField[startRow][j];
                if (i < submarine.length - 1) {
                    i++;
                }
            }
        } else {
            for (int j = startRow; j <= endRow; j++) {
                submarine[i] = BattleField.positionBattleField[j][startColumn];
                if (i < submarine.length - 1) {
                    i++;
                }
            }
        }
    }

    void setCruiser(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        int i = 0;
        if (startRow == endRow) {
            for (int j = startColumn; j <= endColumn; j++) {
                cruiser[i] = BattleField.positionBattleField[startRow][j];
                if (i < cruiser.length - 1) {
                    i++;
                }
            }
        } else {
            for (int j = startRow; j <= endRow; j++) {
                cruiser[i] = BattleField.positionBattleField[j][startColumn];
                if (i < cruiser.length - 1) {
                    i++;
                }
            }
        }
    }

    void setDestroyer(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        int i = 0;
        if (startRow == endRow) {
            for (int j = startColumn; j <= endColumn; j++) {
                destroyer[i] = BattleField.positionBattleField[startRow][j];
                if (i < destroyer.length - 1) {
                    i++;
                }
            }
        } else {
            for (int j = startRow; j <= endRow; j++) {
                destroyer[i] = BattleField.positionBattleField[j][startColumn];
                if (i < destroyer.length - 1) {
                    i++;
                }
            }
        }
    }
}
