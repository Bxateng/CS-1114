import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the Post class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.28
 */
public class PostTest
    extends TestCase
{
    private Post post;
    /**
     * Creates a new PostTest test object.
     */
    public PostTest()
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
        post = new Post("Aaron", "I hate Mondays!", 4, 9);
    }
    /**
     * Test method for the getName method.
     */
    public void testGetName()
    {
        assertThat(post.getName()).isEqualTo("Aaron");
    }
    /**
     * Test method for the getMessage method.
     */
    public void testGetMessage()
    {
        assertThat(post.getMessage()).isEqualTo("I hate Mondays!");
    }
}
