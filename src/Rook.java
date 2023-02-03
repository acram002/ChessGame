public class Rook extends ChessPiece {

	public Rook(boolean isWhite) {

		super(isWhite);
	}

	@Override
	public boolean isValidMove(ChessBoard board, int x1, int y1, int x2, int y2) {
		if (x1 != x2 && y1 != y2) {
			return false;
		}
		return true;
	}
}