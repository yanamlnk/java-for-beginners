package battleship;

enum Fleet {
    AIRCRAFT("Aircraft Carrier", 5, 1),
    BATTLESHIP("Battleship", 4, 2),
    SUBMARINE("Submarine", 3, 3),
    CRUISER("Cruiser", 3, 4),
    DESTROYER("Destroyer", 2, 5);

    String name;
    int length;
    int position;

    Fleet(String name, int length, int position) {
        this.name = name;
        this.length = length;
        this.position = position;
    }

    public static Fleet getShipByPosition(int position) {
        for (Fleet value: values()) {
            if (value.position == position) {
                return value;
            }
        }
        return null;
    }
}

