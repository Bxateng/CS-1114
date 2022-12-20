import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the Brick class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.02
 */
public class BrickTest
    extends TestCase
{
    private Brick brick;
    /**
     * Creates a new BrickTest test object.
     */
    public BrickTest()
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
        /*# Pick your own values instead of those used below */
        brick = new Brick(0, 0, 0);
    }
    /**
     * Test the basic accessors on a brand new Brick.
     */
    public void testBrickConstructor()
    {
        assertThat(brick.getHeight()).isEqualTo(0);
    }
    /**
     * Test method for the getSurfaceArea method.
     */
    public void testGetSurfaceArea()
    {
        assertThat(brick.getSurfaceArea()).isEqualTo(0);
    }
    /**
     * Test method for the getWeight method.
     */
    public void testGetWeight()
    {
        assertThat(brick.getWeight()).isEqualTo(0, within(0.01));
    }
    /**
     * Test method for the getVolume method.
     */
    public void testGetVolume()
    {
        assertThat(brick.getVolume()).isEqualTo(0);
    }
}
