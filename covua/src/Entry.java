import java.util.List;

public class Entry {
    public static void main(String[] args) {
        Bishop xe = new Bishop(2, 7 , "white");
        Piece a11 = new Bishop(1, 8 , "white");
        Move a = new Move(1, 2, 7, 7, xe);
        Board board = new Board();
        board.addPiece(a11);
        Game game = new Game(board);
        game.movePiece(a11, 8, 1);
        List<Move> b = game.getMoveHistory();
        System.out.println(xe.canMove(board,1,8));
        System.out.println(b.size());
    }
}
