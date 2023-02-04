import java.util.ArrayList;

public class ChessBoard {

    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    public void initialize() {
        // Initialize the board with the starting positions of the pieces
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);

        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
            board[6][i] = new Pawn(false);
        }
    }
    
    public ArrayList<ChessMove> getValidMoves(int x, int y) {
        ArrayList<ChessMove> moves = new ArrayList<ChessMove>();
        ChessPiece piece = board[x][y];
        if (piece == null) {
            return moves;
        }
        // Get the valid moves for the piece at the given position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (piece.isValidMove(this, x, y, i, j)) {
                    moves.add(new ChessMove(x, y, i, j));
                }
            }
        }
        return moves;
    }

    public boolean makeMove(ChessMove move) {
        // Check if the move is valid, and if so, make the move
        ArrayList<ChessMove> validMoves = getValidMoves(move.x1, move.y1);
        if (validMoves.contains(move)) {
            board[move.x2][move.y2] = board[move.x1][move.y1];
            board[move.x1][move.y1] = null;
            printBoard();
            return true;
        } else {
            return false;
        }
    }
    
    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }


    
    public void printBoard() {
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece == null) {
                    System.out.print("- ");
                } else {
                    if (piece instanceof King) {
                        System.out.print((piece.isWhite() ? "K " : "k "));
                    } else if (piece instanceof Queen) {
                        System.out.print((piece.isWhite() ? "Q " : "q "));
                    } else if (piece instanceof Rook) {
                        System.out.print((piece.isWhite() ? "R " : "r "));
                    } else if (piece instanceof Bishop) {
                        System.out.print((piece.isWhite() ? "B " : "b "));
                    } else if (piece instanceof Knight) {
                        System.out.print((piece.isWhite() ? "N " : "n "));
                    } else if (piece instanceof Pawn) {
                        System.out.print((piece.isWhite() ? "P " : "p "));
                    }
                }
            }
            System.out.println();
        }
    }

}
