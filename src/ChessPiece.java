public abstract class ChessPiece {
    protected boolean isWhite;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(ChessBoard board, int x1, int y1, int x2, int y2);
}
