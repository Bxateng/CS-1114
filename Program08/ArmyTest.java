import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your test class here.
 *  Summarize what your test objectives are.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class ArmyTest
    extends TestCase
{
    private String pn;
    private String fact;
    private Army army;
    /**
     * Creates a new ArmyTest test object.
     */
    public ArmyTest()
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
        army = new Army("Saiyans", "Namek", "Goku");
    }
    /**
     * Tests the getter methods and the constructor.
     */
    public void testArmy()
    {
        assertThat(army.getPlayerName()).isEqualTo("Goku");
        assertThat(army.getFaction()).isEqualTo("Namek");
    }
    /**
     * Tests the setter method for playerName.
     * @param pn the player's new name
     */
    public void testSetPlayerName()
    {
        army.setPlayerName("Jesus");
        assertThat(army.getPlayerName()).isEqualTo("Jesus");
    }
    /**
     * Tests the setter method for faction.
     * @param the faction name
     */
    public void testSetFaction()
    {
        army.setFaction("Earth");
        assertThat(army.getFaction()).isEqualTo("Earth");
    }
    /**
     * Tests the toString method for the Army class.
     */
    public void testToString()
    {
        
    }
}
