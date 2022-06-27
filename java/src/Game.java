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

    public char Winner() {
        //if the positions in first row are taken
        if (!_board.TileAt(0, 0).isEmpty() &&
                !_board.TileAt(0, 1).isEmpty() &&
                !_board.TileAt(0, 2).isEmpty()) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).isEqual(
                    _board.TileAt(0, 1)) &&
                    _board.TileAt(0, 2).isEqual(_board.TileAt(0, 1))) {
                return _board.TileAt(0, 0).symbol.value();
            }
        }

        //if the positions in first row are taken
        if (!_board.TileAt(1, 0).isEmpty() &&
                !_board.TileAt(1, 1).isEmpty() &&
                !_board.TileAt(1, 2).isEmpty()) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).isEqual(_board.TileAt(1, 1)) &&
                    _board.TileAt(1, 2).isEqual(_board.TileAt(1, 1))) {
                return _board.TileAt(1, 0).symbol.value();
            }
        }

        //if the positions in first row are taken
        if (!_board.TileAt(2, 0).isEmpty() &&
                !_board.TileAt(2, 1).isEmpty() &&
                !_board.TileAt(2, 2).isEmpty()) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).isEqual(_board.TileAt(2, 1)) &&
                    _board.TileAt(2, 2).isEqual(_board.TileAt(2, 1))) {
                return _board.TileAt(2, 0).symbol.value();
            }
        }

        return ' ';
    }
}

