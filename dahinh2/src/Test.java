public class Test {
    public boolean canMove(Board board, int x, int y) {
        if(board.getAt(x, y) != null &&
                this.getColor().equals(board.getAt(x, y).getColor())) {
            return false;
        }
        if (this.getCoordinatesX() == x && this.getCoordinatesY() == y) {
            return false;
        }
        if (Math.abs(this.getCoordinatesX() - x) != Math.abs(this.getCoordinatesY() - y)) {
            return false;
        } else {
            if ((this.getCoordinatesX() - x) * (this.getCoordinatesY() - y) > 0) {
                int max_x = Math.max(this.getCoordinatesX(), x);
                int max_y = Math.max(this.getCoordinatesY(), y);
                int min_y = Math.min(this.getCoordinatesY(), y);
                while (max_y != min_y) {
                    if(board.getAt(max_x, max_y) != null) {
                        if(board.getAt(max_x, max_y).getColor().equals(this.getColor()) &&
                                max_x != this.getCoordinatesX() && max_y != this.getCoordinatesY()) {
                            return false;
                        }
                    }
                    max_y--;
                    max_x--;
                }
            } else {
                int max_x = Math.max(this.getCoordinatesX(), x);
                int max_y = Math.max(this.getCoordinatesY(), y);
                int min_y = Math.min(this.getCoordinatesY(), y);
                while (min_y != max_y) {
                    if(board.getAt(max_x, min_y) != null) {
                        if(board.getAt(max_x, min_y).getColor().equals(this.getColor()) &&
                                max_x != this.getCoordinatesX() && min_y != this.getCoordinatesY()) {
                            return false;
                        }
                    }
                    max_x--;
                    min_y++;
                }
            }
        }
        return true;
    }
}
