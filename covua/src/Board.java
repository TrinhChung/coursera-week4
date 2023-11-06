import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**kiem tra .*/
    public boolean validate(int x, int y) {
        if ((x >= 1 && x <= 8)  && (y >= 1 && y <= 8)) {
            return true;
        } else {
            return false;
        }
    }

    /**them quan co.*/
    public void addPiece(Piece piece) {
        boolean check = true;
        if (pieces != null) {
            for (int i = 0; i < pieces.size(); i++) {
                if (piece.getCoordinatesY() == pieces.get(i).getCoordinatesY()
                        && piece.getCoordinatesX() == pieces.get(i).getCoordinatesX()) {
                    check = false;
                    break;
                }
            }
        }
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY()) && check
        ) {
            pieces.add(piece);
        }
    }

    /**tra ve quan co tai x, y.*/
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                return  pieces.get(i);
            }
        }
        return null;
    }

    /** xoa co tai x, y.*/
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }


}
