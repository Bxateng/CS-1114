import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests the getter and setter methods in the Unit class 
 *  as well as the constructor.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class UnitTest
    extends TestCase
{
    private Unit unit;
    /**
     * Creates a new UnitTest test object.
     */
    public UnitTest()
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
        unit = new Unit("devin", 10);
    }
    /**
     * Tests the constructor to see if all values and objects
     * were properly intialized.
     */
    public void testUnit()
    {
        assertThat(unit.getName()).isEqualTo("devin");
        assertThat(unit.getPoints()).isEqualTo(10);
        assertThat(unit.getQuality()).isEqualTo(2);
        assertThat(unit.getDefense()).isEqualTo(2);
    }
    /**
     * Tests the setter method for the unit's name.
     */
    public void testSetName()
    {
        unit.setName("bob");
        assertThat(unit.getName()).isEqualTo("bob");
    }
    /**
     * Tests the setter method for the unit's point value.
     */
    public void testSetPoints()
    {
        unit.setPoints(20);
        assertThat(unit.getPoints()).isEqualTo(20);
    }
    /**
     * Tests the setter method for the unit's quality.
     */
    public void testSetQuality()
    {
        unit.setQuality(7);
        assertThat(unit.getQuality()).isEqualTo(7);
    }
    /**
     * Tests the setter method for the unit's defense.
     */
    public void testSetDefense()
    {
        unit.setDefense(9);
        assertThat(unit.getDefense()).isEqualTo(9);
    }
}
