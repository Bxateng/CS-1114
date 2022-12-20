import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris.*;
// -------------------------------------------------------------------------
/**
 *  Test class for the CleverBrain class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.08
 */
public class CleverBrainTest
    extends TestCase
{
    private CleverBrain cr;
    private Board b;
    private double score;
    private Piece piece;
    private Move move;
    /**
     * Creates a new CleverBrainTest test object.
     */
    public CleverBrainTest()
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
    
    }
    /**
     * Test method for the bestMove method.
     */
    public void testBestMove()
    {
        cr = new CleverBrain();
        b = new Board(10, 24,
        "#### #####"
            );
        piece = Piece.getPiece(Piece.LEFT_L, 0);
        move = cr.bestMove(b, piece, 5);
        assertThat(move.getLocation()).isEqualTo(new Point(4, 0));
        assertThat(move.getPiece()).isEqualTo(Piece.getPiece
            (Piece.LEFT_L, 0)); 
    }
    /**
     * Test method for the rateBoard method.
     */
    public void testRateBoard()
    {
        cr = new CleverBrain();
        b = new Board(10, 24,
        "#### #####"
            );
        score = cr.rateBoard(b);
        assertThat(score).isEqualTo(9.0);   
    }
    /**
     * Test method for the bestLocation method.
     */
    public void testBestLocation()
    {
        b = new Board(10, 24,
        "#### #####"
            );
        CleverBrain cr2 = new CleverBrain();
        piece = Piece.getPiece(Piece.LEFT_L, 0);
        assertThat(piece.getStyle()).isEqualTo(Piece.LEFT_L);
    }
}
