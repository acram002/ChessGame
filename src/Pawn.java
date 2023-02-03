public class Pawn extends ChessPiece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean isValidMove(ChessBoard board, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (isWhite) {
            if (x2 > x1) {
                return false;
            }
            if (x1 - x2 > 2) {
                return false;
            }
            if (x1 - x2 == 2 && x1 != 6) {
                return false;
            }
            if (y1 - y2 > 1 || y1 - y2 < -1) {
                return false;
            }
            if (y1 - y2 == 0 && board.getPiece(x2, y2) != null) {
                return false;
            }
            if (y1 - y2 != 0 && board.getPiece(x2, y2) == null) {
                return false;
            }
        } else {
            if (x2 < x1) {
                return false;
            }
            if (x2 - x1 > 2) {
                return false;
            }
            if (x2 - x1 == 2 && x1 != 1) {
                return false;
            }
            if (y1 - y2 > 1 || y1 - y2 < -1) {
                return false;
            }
            if (y1 - y2 == 0 && board.getPiece(x2, y2) != null) {
                return false;
            }
            if (y1 - y2 != 0 && board.getPiece(x2, y2) == null) {
                return false;
            }
        }
        return true;
    }
}
