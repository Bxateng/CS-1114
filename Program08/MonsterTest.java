import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests the getter and setter methods in the Monster class 
 *  as well as the constructor.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class MonsterTest
    extends TestCase
{
    private Monster monster;
    /**
     * Creates a new MonsterTest test object.
     */
    public MonsterTest()
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
        monster = new Monster("goblin", 12);
    }
    /**
     * Tests the constructor to see if all values and 
     * objects were properly intialized.
     */
    public void testMonster()
    {
        assertThat(monster.getName()).isEqualTo("goblin");
        assertThat(monster.getPoints()).isEqualTo(12);
        assertThat(monster.getQuality()).isEqualTo(4);
        assertThat(monster.getDefense()).isEqualTo(4);
    }
}
