import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests the getter and setter methods in the EnhancedUnit class 
 *  as well as the constructor.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class EnhancedUnitTest
    extends TestCase
{
    private EnhancedUnit eUnit;
    /**
     * Creates a new EnhancedUnitTest test object.
     */
    public EnhancedUnitTest()
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
        eUnit = new EnhancedUnit("mage", 20);
    }
    /**
     * Tests the constructor to see if all values and objects
     * were properly intialized.
     */
    public void testEnhancedUnit()
    {
        assertThat(eUnit.getName()).isEqualTo("mage");
        assertThat(eUnit.getPoints()).isEqualTo(20);
        assertThat(eUnit.getQuality()).isEqualTo(2);
        assertThat(eUnit.getDefense()).isEqualTo(2);
    }
    /**
     * Tests the getter and setter methods for the unit's 
     * special ability.
     */
    public void testSetSpecialRule()
    {
        eUnit.setSpecialRule("Lightning Attack");
        assertThat(eUnit.getSpecialRule()).isEqualTo("Lightning Attack");
    }
}
