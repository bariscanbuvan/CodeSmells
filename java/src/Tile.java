
public class Tile {

    Location location;
    char Symbol;

    Symbol symbol;



    public boolean isEmpty() {
        return this.symbol.value() != ' ';
    }
}