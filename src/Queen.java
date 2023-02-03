public class Queen extends ChessPiece {
	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(ChessBoard board, int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x1 - x2);
		int dy = Math.abs(y1 - y2);

		if (dx == dy || x1 == x2 || y1 == y2) {
			return true;
		}
		return false;
	}
}