public class Bishop extends Piece {

    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    /**canMove.*/
    @Override
    public boolean canMove(Board board, int x, int y) {
        if ((getCoordinatesX() == x && getCoordinatesY() == y)
                || ((getCoordinatesX() + getCoordinatesY() != x + y)
                && Math.abs(getCoordinatesX() - getCoordinatesY()) != Math.abs(x - y))) {
            return false;
        } else {
            if (getCoordinatesX() + getCoordinatesY() == x + y) {
                int maxY = Math.max(y, getCoordinatesY());
                int minY = Math.min(y, getCoordinatesY());
                int minX = Math.min(x, getCoordinatesX());
                for (int i = 1; i < maxY - minY; i++) {
                    if (board.getAt(minX + i, maxY - i) != null) {
                        return false;
                    }
                }
                Piece a = board.getAt(x, y);
                if (a == null) {
                    return true;
                } else if (a.getColor().equals(getColor())) {
                    return false;
                } else {
                    return true;
                }
            } else {
                int maxY = Math.max(y, getCoordinatesY());
                int minY = Math.min(y, getCoordinatesY());
                for (int i = 1; i < maxY - minY; i++) {
                    if (board.getAt(maxY - i, maxY - i) != null) {
                        return false;
                    }
                }
                Piece a = board.getAt(x, y);
                if (a == null) {
                    return true;
                } else if (a.getColor().equals(getColor())) {
                    return false;
                } else {
                    return true;
                }
            }

        }
    }
}
