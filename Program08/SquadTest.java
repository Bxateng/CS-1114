import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your test class here.
 *  Summarize what your test objectives are.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class SquadTest
    extends TestCase
{
    private List<Unit> un;
    private Squad squad;
    /**
     * Creates a new SquadTest test object.
     */
    public SquadTest()
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
        squad = new Squad("Z Warriors");
        un = new ArrayList<>();
    }
    /**
     * Tests the getter methods and the constructor of
     * the Squad class
     */
    public void testSquad()
    {
        assertThat(squad.getUnits()).isEqualTo(null);
    }
    /**
     * text
     */
    public void testAddUnit()
    {
        Unit unit = new Unit("Gohan", 10);
        Unit unit2 = new Unit("Piccolo", 5);
        un.add(unit);
        un.add(unit2);
        assertThat(un.size()).isEqualTo(2);
    }
    /**
     * text
     */
    public void testRemoveUnit()
    {
        Unit unit = new Unit("Vegeta", 12);
        Unit unit2 = new Unit("Krillin", 4);
        Unit unit3 = new Unit("Tien", 3);
        un.add(unit);
        un.add(unit2);
        un.remove(unit);
        assertThat(un.size()).isEqualTo(1);
        un.remove(unit3);
        assertThat(un.size()).isEqualTo(1);
    }
    /**
     * text
     */
    public void testGetPoints()
    {
        
    }
}
