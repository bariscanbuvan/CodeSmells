
public class Tile {
    Location location;
    Symbol symbol;

    public boolean isEmpty() {
        return this.symbol.value() == ' ';
    }

    public boolean isEqual(Tile tile) {
        return this.symbol.value() == tile.symbol.value();
    }
}