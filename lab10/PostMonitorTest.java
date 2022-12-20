import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the PostMonitor class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.28
 */
public class PostMonitorTest
    extends TestCase
{
    private PostMonitor pm;
    private int[] dc;
    private int[] hc;
    private Post post;
    /**
     * Creates a new PostMonitorTest test object.
     */
    public PostMonitorTest()
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
        pm = new PostMonitor();
        dc = new int[7];
        hc = new int[24];
        dc[4] = 1;
        hc[9] = 1;
    }
    /**
     * Test method for the PostMonitor constructor.
     */
    public void testPostMonitor()
    {
        int[] emptyDc = new int[7];
        int[] emptyHc = new int[24];
        assertThat(pm.getDayCounts()).isEqualTo(emptyDc);
        assertThat(pm.getHourCounts()).isEqualTo(emptyHc);
    }
    /**
     * Test method for the recordPost method.
     */
    public void testRecordPost()
    {
        pm.recordPost(post);
        assertThat(pm.getHourCounts()).isEqualTo(hc);
        assertThat(pm.getDayCounts()).isEqualTo(dc);
        assertThat(pm.getPostCount()).isEqualTo(1);
    }
    /**
     * Test method for the getIndexOfLargest method.
     */
    public void testGetIndexOfLargest()
    {
        int[] bruh = {1, 4, 2, 3, 8};
        assertThat(pm.getIndexOfLargest(bruh)).isEqualTo(4);
    }
    /**
     * Test method for the gestBusiestHour method.
     */
    public void testGetBusiestHour()
    {
        assertThat(pm.getBusiestHour()).isEqualTo(0);
    }
    /**
     * Test method for the getBusiestDay method.
     */
    public void testGetBusiestDay()
    {
        assertThat(pm.getBusiestDay()).isEqualTo(0);
    }
    /**
     * Test method for the getIndexOfSmallest method.
     */
    public void testGetIndexOfSmallest()
    {
        int[] bruh = {4, 1, 2, 3, 8};
        assertThat(pm.getIndexOfSmallest(bruh)).isEqualTo(1); 
    }
    /**
     * Test method for the getSlowestHour method.
     */
    public void testGetSlowestHour()
    {
        for (int i = 0; i < hc.length; i++)
        {
            hc[i] = i;
        }
        assertThat(pm.getSlowestHour()).isEqualTo(0);
    }
    /**
     * Test method for the getSlowestDay method.
     */
    public void testGetSlowestDay()
    {
        for (int i = 0; i < hc.length; i++) 
        {
            hc[i] = i;
        }
        assertThat(pm.getSlowestDay()).isEqualTo(0);
    }
}
