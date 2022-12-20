import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests the getter and setter methods in the Hero class 
 *  as well as the constructor.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class HeroTest
    extends TestCase
{
    private Hero hero;
    /**
     * Creates a new HeroTest test object.
     */
    public HeroTest()
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
        hero = new Hero("knight", 15);
    }
    /**
     * Tests the constructor to see if all values and objects
     * were properly intialized.
     */
    public void testHero()
    {
        assertThat(hero.getName()).isEqualTo("knight");
        assertThat(hero.getPoints()).isEqualTo(15);
        assertThat(hero.getQuality()).isEqualTo(5);
        assertThat(hero.getDefense()).isEqualTo(5);
    }
}
