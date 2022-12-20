import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests the getter and setter methods in the Upgrade class 
 *  as well as the constructor.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class UpgradeTest
    extends TestCase
{
    private Upgrade upgrade;
    /**
     * Creates a new UpgradeTest test object.
     */
    public UpgradeTest()
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
        upgrade = new Upgrade("armor", 3);
    }
    /**
     * Tests the constructor to see if all values and objects
     * were properly intialized.
     */
    public void testUpgrade()
    {
        assertThat(upgrade.getName()).isEqualTo("armor");
        assertThat(upgrade.getPoints()).isEqualTo(3);
    }
}
