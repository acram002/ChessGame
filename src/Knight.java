public class Knight extends ChessPiece {
	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(ChessBoard board, int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x1 - x2);
		int dy = Math.abs(y1 - y2);

		if (dx == 2 && dy == 1 || dx == 1 && dy == 2) {
			return true;
		}
		return false;
	}
}