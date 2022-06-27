public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (!_board.TileAt(x, y).isEmpty()) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        for (int row = 0; row < 3; row++) {
            Symbol symbol = getWinnerSymbol(row);
            if (symbol != null)
                return symbol;
        }

        return new Symbol(' ');
    }

    private Symbol getWinnerSymbol(int x) {
        if (!_board.TileAt(x, 0).isEmpty() &&
                !_board.TileAt(x, 1).isEmpty() &&
                !_board.TileAt(x, 2).isEmpty()) {
            //if first row is full with same symbol
            if (_board.TileAt(x, 0).isEqual(
                    _board.TileAt(x, 1)) &&
                    _board.TileAt(x, 2).isEqual(_board.TileAt(x, 1))) {
                return _board.TileAt(x, 0).symbol;
            }
        }
        return null;
    }
}

