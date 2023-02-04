import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ChessBoardDisplay extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int TILE_SIZE = 80;
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;
    private ChessBoard board;
	private int squareSize = 50;

    private Color lightTileColor = Color.decode("#FFFACD");
    private Color darkTileColor = Color.decode("#593E1A");

    private ArrayList<Point> highlights = new ArrayList<>();

    public ChessBoardDisplay() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	//System.out.print("Select piece to move");
                int x = e.getX() / TILE_SIZE;
                int y = 7 - e.getY() / TILE_SIZE;

               // System.out.print("Select piece to move");
                Point clickedTile = new Point(x, y);
                
               // ChessMove move = new ChessMove(x1, y1, x2, y2);
               // if (!board.makeMove(move)) {
               //     System.out.println("Invalid move, try again");
              //      continue;
             //   }
             //   whiteTurn = !whiteTurn;
                System.out.println("Clicked tile: " + clickedTile);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH * TILE_SIZE, BOARD_HEIGHT * TILE_SIZE);
    }

    public void addHighlight(Point highlight) {
        highlights.add(highlight);
        repaint();
    }

    public void clearHighlights() {
        highlights.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                int x = i * TILE_SIZE;
                int y = j * TILE_SIZE;

                Color color = (i + j) % 2 == 0 ? lightTileColor : darkTileColor;
                g.setColor(color);
                g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }

        for (Point highlight : highlights) {
            int x = highlight.x * TILE_SIZE;
            int y = (7 - highlight.y) * TILE_SIZE;

            g.setColor(Color.RED);
            g.fillRect(x + TILE_SIZE / 4, y + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
        }
        
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Board Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChessBoard board = new ChessBoard();
		board.initialize();
		ChessBoardDisplay display = new ChessBoardDisplay();

        frame.add(display);

        frame.pack();
        frame.setVisible(true);
    }
}

   










/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessBoardDisplay extends JPanel implements MouseListener {
	private ChessBoard board;
	private int squareSize = 50;

	public ChessBoardDisplay(ChessBoard board) {
		this.board = board;
		setPreferredSize(new Dimension(8 * squareSize, 8 * squareSize));
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		// Paint the background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 8 * squareSize, 8 * squareSize);

		// Paint the squares
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					g.setColor(Color.GRAY);
				} else {
					g.setColor(Color.LIGHT_GRAY);
				}
				g.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
			}
		}

		// Paint the pieces
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ChessPiece piece = board.getPiece(i, j);
				if (piece != null) {
					int x = i * squareSize;
					int y = j * squareSize;
					if (piece instanceof King) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						g.fillOval(x + squareSize / 4, y + squareSize / 4, squareSize / 2, squareSize / 2);
					} else if (piece instanceof Queen) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						g.fillOval(x + squareSize / 4, y + squareSize / 4, squareSize / 2, squareSize / 2);
					} else if (piece instanceof Bishop) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						g.fillOval(x + squareSize / 4, y + squareSize / 4, squareSize / 2, squareSize / 2);
					} else if (piece instanceof Knight) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						int[] xPoints = { x + squareSize / 4, x + squareSize / 2, x + squareSize * 3 / 4 };
						int[] yPoints = { y + squareSize * 3 / 4, y + squareSize / 4, y + squareSize * 3 / 4 };
						g.fillPolygon(xPoints, yPoints, 3);
					} else if (piece instanceof Rook) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						g.fillRect(x + squareSize / 4, y + squareSize / 4, squareSize / 2, squareSize / 2);
					} else if (piece instanceof Pawn) {
						g.setColor(piece.isWhite() ? Color.WHITE : Color.BLACK);
						g.fillOval(x + squareSize / 4, y + squareSize / 4, squareSize / 2, squareSize / 2);
					}
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Handle mouse clicks on the board
		int x = e.getX() / squareSize;
		int y = e.getY() / squareSize;
		System.out.println("Clicked on square " + x + ", " + y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessBoardDisplay display = new ChessBoardDisplay(board);
		JFrame frame = new JFrame("Chess Board");
		frame.add(display);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}*/
