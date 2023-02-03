import java.util.Scanner;

public class ChessGame {

    private ChessBoard board;
    private boolean whiteTurn;

    public ChessGame() {
        board = new ChessBoard();
        board.initialize();
        whiteTurn = true;
    }

    public void play() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(board);
            System.out.println("Enter the coordinates of the piece you want to move (e.g. a2): ");
            String start = input.nextLine();
            int x1 = 8 - (start.charAt(1) - '0');
            int y1 = start.charAt(0) - 'a';
            System.out.println("Enter the coordinates of the square you want to move to (e.g. a3): ");
            String end = input.nextLine();
            int x2 = 8 - (end.charAt(1) - '0');
            int y2 = end.charAt(0) - 'a';
            ChessMove move = new ChessMove(x1, y1, x2, y2);
            if (!board.makeMove(move)) {
                System.out.println("Invalid move, try again");
                continue;
            }
            whiteTurn = !whiteTurn;
        }
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.play();
    }
}
