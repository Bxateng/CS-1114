import student.tetris.*;
//-------------------------------------------------------------------------
/**
 *  Class that acts as the Tetris brain.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.08
 */
public class CleverBrain
    implements Brain
{
    private Point point;
    private int bestCol = 0;
    private int bestRot = 0;
    double lowestRating;
    /**
     * Initializes a newly created CleverBrain object.
     */
    public CleverBrain()
    {
        super();
    }
    /**
     * Places the piece in the most favorable position on the board.
     * @param board The board being used
     * @param piece The piece being placed
     * @param heightLimit The highest point a piece can go
     * @return the most favorable move
     */
    public Move bestMove(Board board, Piece piece, int heightLimit)
    {
        Move move = new Move(piece);
        Piece[] p = piece.getRotations();
        bestLocation(board, piece);
        int x = bestCol - 1;
        int y = board.rowAfterDrop(piece, x);
        point = new Point(x, y);
        move.setScore(lowestRating);
        move.setPiece(p[bestRot]);
        move.setLocation(point);
        int location = board.place(piece, point);
        if (location == Board.PLACE_ROW_FILLED)
        {
            board.clearRows();
        }
        return move;
    }
    /**
     * Determines the difficulty of the board. The higher
     * the score,the more difficult it is.
     * @param board The board being rated
     * @return the rating of the board
     */
    public double rateBoard(Board board)
    {
        double rating = 0.0;
        for (int i = 0; i < board.getColumnHeights().length; i++)
        {
            rating += board.getColumnHeights()[i];
        }
        return rating;
    }
    /**
     * Finds the best possible location for the piece
     * on the board.
     * @param board The board being used
     * @param piece The piece being placed
     */
    public void bestLocation(Board board, Piece piece)
    {
        double[][] pieceR = new double[board.getWidth()][piece.numRotations()];
        lowestRating = pieceR[0][0];
        for (int x = 0; x < board.getWidth(); x++)
        {
            for (int i = 0; i < piece.numRotations(); 
                i++)
            {
                point = new Point(x, 0);
                pieceR[x][i] = rateBoard(board);
                if (pieceR[x][i] < lowestRating)
                {
                    lowestRating = pieceR[x][i];
                    bestCol = x;
                    bestRot = i;
                }
            }
        }
    }
}
