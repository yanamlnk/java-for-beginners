package battleship;

class BattleField {

    String[][] battleField = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
    };

    String[][] foggyBattleField = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
    };

    static final String[][] positionBattleField = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"},
            {"B", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10"},
            {"C", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"},
            {"D", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10"},
            {"E", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10"},
            {"F", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10"},
            {"G", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10"},
            {"H", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10"},
            {"I", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10"},
            {"J", "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"},
    };

    String[][] getBattleField() {
        return this.battleField;
    }

    void setBattleField(int[] positions) {
        int startRow = positions[0];
        int endRow = positions[2];
        int startColumn = positions[1];
        int endColumn = positions[3];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                this.battleField[i][j] = "O";
            }
        }
    }

    public void outputBattleField() {
        for (int i = 0; i < this.battleField.length; i++) {
            if (i != 0) {
                System.out.print('\n');
            }
            for (int j = 0; j < this.battleField[i].length; j++) {
                if (j == this.battleField[i].length - 1) {
                    System.out.print(this.battleField[i][j]);
                } else {
                    System.out.print(this.battleField[i][j] + " ");
                }
            }
        }
        System.out.print('\n');
    }

    public void outputFoggyBattleField () {
        for (int i = 0; i < foggyBattleField.length; i++) {
            if (i != 0) {
                System.out.print('\n');
            }
            for (int j = 0; j < foggyBattleField[i].length; j++) {
                if (j == foggyBattleField[i].length - 1) {
                    System.out.print(foggyBattleField[i][j]);
                } else {
                    System.out.print(foggyBattleField[i][j] + " ");
                }
            }
        }
        System.out.print('\n');
    }
}