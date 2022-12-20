import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris2.*;
// -------------------------------------------------------------------------
/**
 *  Test class that checks for correct 
 *  syntax and coding for the 
 *  StudentBoard class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.15
 */
public class StudentBoardTest
    extends TestCase
{
    /**
     * Creates a new StudentBoardTest test object.
     */
    public StudentBoardTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        // Empty  
    }
    /**
     * Tests the StudentBoard constructor and getter methods.
     */
    public void testStudentBoard()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "#### #####"
            );
        StudentBoard board2 = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "#### #####"
            );
        assertThat(board.getWidth()).isEqualTo(10);
        assertThat(board.getHeight()).isEqualTo(3);
        assertThat(board.getBlocksInAllRows())
            .isEqualTo(board2.getBlocksInAllRows());
        assertThat(board.getColumnHeights())
            .isEqualTo(board2.getColumnHeights());
        assertThat(board.getGrid()).isEqualTo(board2.getGrid());
    }
    /**
     * Tests the hasBlockAt method for irregular Point cases.
     */
    public void testHasBlockAt()
    {
        StudentBoard start = BoardUtilities.newBoard(StudentBoard.class,
            10, 4,
            "          ",
            "          ",
            "          ",
            "#### #####"
            ); 
        assertThat(start.hasBlockAt(new Point(4, 0))).isEqualTo(false);
        assertThat(start.hasBlockAt(new Point(-2, 2))).isEqualTo(true);
        assertThat(start.hasBlockAt(new Point(3, -5))).isEqualTo(true);
        assertThat(start.hasBlockAt(new Point(0, 10))).isEqualTo(true);
        assertThat(start.hasBlockAt(new Point(10, 0))).isEqualTo(true);
    }
    /**
     * Tests the place method to check if the row is filled
     * and if columnHeights are updated.
     */
    public void testPlace()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
        StudentBoard board2 = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "###  #####",
            "#### #####"
            );
        StudentBoard board3 = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int[] blocksAllRows = board.getBlocksInAllRows();
        assertThat(blocksAllRows[0]).isEqualTo(board.getWidth() - 1);
        int result = board.place(piece, new Point(4, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        assertThat(blocksAllRows[1]).isEqualTo(3);
        assertThat(board.getColumnHeights())
            .isEqualTo(new int[] {1, 1, 1, 1, 2, 2, 2, 1, 1, 1});
        int result2 = board.place(piece, new Point(1, 0));
        int result3 = board.place(piece, new Point(10, 0));
        int result4 = board2.place(piece, new Point(3, 1));
        int result5 = board3.place(piece, new Point(0, 4));
        assertThat(result2).isEqualTo(Board.PLACE_BAD);
        assertThat(result3).isEqualTo(Board.PLACE_OUT_BOUNDS);
        assertThat(result4).isEqualTo(Board.PLACE_OK);
        assertThat(result5).isEqualTo(Board.PLACE_OUT_BOUNDS);
    }
    /**
     * Tests the clearRows method to check if the blocksInAllRows,
     * columnHeights, and topmost row are correctly updated.
     */
    public void testClearRows()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "#   #   # ",
            "# # # # # ",
            "##########"
            );    
        StudentBoard board2 = BoardUtilities.newBoard(StudentBoard.class,
            10, 3,
            "          ",
            "#   #   # ",
            "# # # # # "
            );
        assertThat(board.clearRows()).isTrue();
        assertThat(board2.clearRows()).isFalse();
        board.clearRows();
        assertThat(board.getColumnHeights()).isEqualTo(board2.getColumnHeights());
        assertThat(board.getBlocksInAllRows()).isEqualTo(board2.getBlocksInAllRows());
    }
}
