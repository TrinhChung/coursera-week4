public class Rook extends Piece {

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    /**canMove.*/
    @Override
    public boolean canMove(Board board, int x, int y) {
        if ((x != getCoordinatesX() && y != getCoordinatesY())
        || (x == getCoordinatesX() && y == getCoordinatesY())) {
            return false;
        } else {
            if (x == getCoordinatesX()) {
                int maxY = Math.max(y, getCoordinatesY());
                int minY = Math.min(y, getCoordinatesY());
                for (int i = minY + 1; i < maxY; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
                Piece a = board.getAt(x, y);
                if (a == null) {
                    return true;
                } else if (getColor().equals(a.getColor())) {
                    return false;
                } else {
                    return true;
                }

            } else {
                int maxX = Math.max(x, getCoordinatesX());
                int minX = Math.min(x, getCoordinatesX());
                for (int i = minX +1; i < maxX; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
                Piece a = board.getAt(x, y);
                if (getColor().equals(a.getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
