import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the Pallet class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.02
 */
public class PalletTest
    extends TestCase
{
    private Pallet pallet;
    /**
     * Creates a new PalletTest test object.
     */
    public PalletTest()
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
        pallet = new Pallet(1, 1);
    }
    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor()
    {
        assertThat(pallet.getHeight()).isEqualTo(23);
        
        // Tests if the bricks in plane is zero
        Pallet pallet2 = new Pallet(0, 0);
        assertThat(pallet2.getHeight()).isEqualTo(15);
    }
    /**
     * Tests the getWeight() method.
     */
    public void testGetWeight()
    {
        assertThat(pallet.getWeight()).isEqualTo(10.34, within(0.01));
    }
}
