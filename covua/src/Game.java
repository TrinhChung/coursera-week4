import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**move.*/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                Move m = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                moveHistory.add(m);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            } else {
                Move m = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece, board.getAt(x, y));
                moveHistory.add(m);
                board.removeAt(x, y);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }

}
