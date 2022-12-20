import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the WeatherStation class
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.06
 */
public class WeatherStationTest
    extends TestCase
{
    private WeatherStation station;
    /**
     * Creates a new WeatherStationTest test object.
     */
    public WeatherStationTest()
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
        station = new WeatherStation("WTOP");
    }
    /**
     * Tests if the ID was correctly returned with the
     * getId method.
     */
    public void testWeatherStation()
    {
        assertThat(station.getId()).isEqualTo("WTOP");
    }
    /**
     * Tests if the amount of rainfall and specified month
     * is being correctly recorded.
     */
    public void testRecordDailyRain()
    {
        station.recordDailyRain(4, 1);
        assertThat(station.getCountForMonth(4)).isEqualTo(1);
    }
    /**
     * Tests if the correct values are being returned 
     * in the specified month.
     */
    public void testGetCountForMonth()
    {
        assertThat(station.getCountForMonth(5)).isEqualTo(0);
    }
    /**
     * Tests if the correct average is being returned
     * in the specified month.
     */
    public void testGetAvgForMonth()
    {
        assertThat(station.getAvgForMonth(3)).isEqualTo(-1.0);
    }
    /**
     * Tests if the correct month with the lowest rainfall
     * is returned.
     */
    public void testGetLowestMonth()
    {
        assertThat(station.getLowestMonth()).isEqualTo(0);
    }
}
