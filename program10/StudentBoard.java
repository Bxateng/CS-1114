import student.tetris2.*;
//-------------------------------------------------------------------------
/**
 *  Class that implements several methods from the Board
 *  interface that manipulates Tetris pieces/boards.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.15
 */
public class StudentBoard
    implements Board
{
    private int height;
    private int width;
    private int[] columnHeights;
    private int[] blocksInAllRows;
    private boolean[][] grid;
    /**
     * Initializes a newly created StudentBoard object.
     * @param boardWidth the width of the board
     * @param boardHeight the height of the board
     */
    public StudentBoard(int boardWidth, int boardHeight)
    {
        super();
        width = boardWidth;
        height = boardHeight;
        columnHeights = new int[width];
        blocksInAllRows = new int[height];
        grid = new boolean[height][width];
    }
    /**
     * Getter method for the height of the board.
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }
    /**
     * Getter method for the width of the board.
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }
    /**
     * Getter method for the height of each board column.
     * @return an array of column heights
     */
    public int[] getColumnHeights()
    {
        return columnHeights;
    }
    /**
     * Getter method for the blocks in a specific column.
     * @return an array of ints representing blocks
     */
    public int[] getBlocksInAllRows()
    {
        return blocksInAllRows;
    }
    /**
     * Getter method for the 2D array of booleans of the entire board.
     * @return a 2D array of booleans
     */
    public boolean[][] getGrid()
    {
        return grid;
    }
    /**
     * Method that returns if a specific coordinate contains a block.
     * @return a boolean indicating if the coordinate is full or empty
     * @param point the coordinate being checked
     */
    public boolean hasBlockAt(Point point)
    {
        // Checks for out of bounds coordinates
        if (point.getX() < 0 || point.getX() >= width)
        {
            return true;
        }
        if (point.getY() < 0 || point.getY() >= height)
        {
            return true;
        }
        return grid[point.getY()][point.getX()];
    }
    /**
     * Method that places a piece into a specific coordinate on the board.
     * @param piece the piece being placed
     * @param point the location piece is being placed
     * @return the board placement
     */
    public int place(Piece piece, Point point)
    {
        Point[] pieceCoords = piece.getBody();
        for (Point pieceLoc : pieceCoords)
        {
            // Checks for out of bounds or occupied coordinates
            if (pieceLoc.getX() + point.getX() >= width 
                || pieceLoc.getY() + point.getY() >= height)
            {
                return Board.PLACE_OUT_BOUNDS;
            }
            else if (hasBlockAt(point))
            {
                return Board.PLACE_BAD;
            }
            else
            {
                // Sets the location of the piece to true
                // and updates columnHeights
                grid[pieceLoc.getY() + point.getY()]
                    [pieceLoc.getX() + point.getX()] = true;
                if (columnHeights[point.getX() + pieceLoc.getX()] 
                    <= point.getY() + pieceLoc.getY())
                {
                    columnHeights[point.getX() + pieceLoc.getX()] 
                        = point.getY()  + pieceLoc.getY() + 1;
                }
                blocksInAllRows[point.getY() + pieceLoc.getY()]++;
            }
        }
        // Checks if a row has been filled
        for (int i = 0; i < blocksInAllRows.length; i++)
        {
            if (blocksInAllRows[i] == width)
            {
                return Board.PLACE_ROW_FILLED;
            }
        }
        return Board.PLACE_OK;
    }
    /**
     * Method that removes a row if full and drops down every other row
     * above it.
     * @return true if a row was filled, false if otherwise
     */
    public boolean clearRows()
    {
        boolean rowCleared = false;
        int topRow = 0;
        for (int y = 0; y < blocksInAllRows.length; y++)
        {
            if (blocksInAllRows[y] == width)
            {
                rowCleared = true;
                // Moves all rows above the full row down one
                for (int rowHeight = y; rowHeight < 
                    blocksInAllRows.length - 1; rowHeight++)
                {
                    blocksInAllRows[rowHeight] = 
                        blocksInAllRows[rowHeight + 1];
                }
                // Clears the topmost row
                blocksInAllRows[height - 1] = topRow;
                // Updates the columnHeights to match the new value
                for (int x = 0; x < columnHeights.length; x++)
                {
                    if (columnHeights[x] > y - 1)
                    {
                        columnHeights[x]--;
                    } 
                    else 
                    {
                        for (int i = y - 1; i >= 0; i--)
                        {
                            Point point = new Point(x, i);
                            if (hasBlockAt(point))
                            {
                                columnHeights[i] = point.getY();
                                break;
                            }
                        }
                    }
                }
            }
        }
        // Initializes a new topmost row 
        boolean[] newRow = new boolean[width];
        grid[height - 1] = newRow;
        return rowCleared;
    }
}
