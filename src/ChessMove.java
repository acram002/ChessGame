public class ChessMove {
    public int x1, y1, x2, y2;

    public ChessMove(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ChessMove)) {
            return false;
        }
        ChessMove o = (ChessMove) other;
        return x1 == o.x1 && y1 == o.y1 && x2 == o.x2 && y2 == o.y2;
    }
}
