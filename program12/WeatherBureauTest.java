import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for the WeatherBureau class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.06
 */
public class WeatherBureauTest
    extends TestCase
{
    private WeatherBureau bureau;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    /**
     * Creates a new WeatherBureauTest test object.
     */
    public WeatherBureauTest()
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
        bureau = new WeatherBureau();
    }
    /**
     * Tests if the bureau correctly records a summary.
     */
    public void testRecordDailySummary()
    {
        String text = "KE000063612 3.117 35.617 515 2/10/16 0.04" +
            "87 98 73";
        String text2 = "KE000063820    -4.033    39.617    55    4/25/16" +    
            "0 88 101 75";
        String text3 = "KE00063612 3.117 35.617 515 12/10/16 0.04" +
            "87 98 73";
            
        bureau.recordDailySummary(text);
        bureau.recordDailySummary(text2);
        bureau.recordDailySummary(text3);
        WeatherStation station1 = bureau.getStation("KE000063612");
        WeatherStation station2 = bureau.getStation("KE000063820");
        WeatherStation station3 = bureau.getStation("KE00063612");
        assertThat(station1.getAvgForMonth(2))
            .isEqualTo(0.04, within(0.01)); 
        assertThat(station2.getAvgForMonth(4)).isEqualTo(88.0);
        assertThat(station3.getAvgForMonth(12))
            .isEqualTo(0.04, within(0.01));
        assertThat(bureau.getStation("KE000063612")).isEqualTo(station1);
    }
    /**
     * Tests if the bureau correctly records multiple summaries.
     */
    public void testRecordDailySummaries()
    {
        setIn(
            "KE000063612    3.117    35.617    515    2/10/16" +    
            "0.04    87    98    73",
            "KE000063820    -4.033    39.617    55    4/25/16" +    
            "0    88    101    75"
        );
        bureau.recordDailySummaries(in());
        WeatherStation station1 = bureau.getStation("KE000063612");
        WeatherStation station2 = bureau.getStation("KE000063820");
        assertThat(station1.getAvgForMonth(2))
            .isEqualTo(87.0, within(0.001));
        assertThat(station2.getAvgForMonth(4))
            .isEqualTo(88.0); 
    }
    /**
     * Tests if the getStation method correctly returns the
     * corresponding WeatherStation object.
     */
    public void testGetStation()
    {
        assertThat(bureau.getStation("WTOP")).isEqualTo(null); 
    }
    /**
     * Tests for the station with the least average rainfall
     * in the specified month.
     */
    public void testLowestStationByMonth()
    {
        // Different months
        str1 = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        str2 = "KE000063820 -4.033 39.617 55 4/25/16 0 88 101 75";
        bureau.recordDailySummary(str1);
        bureau.recordDailySummary(str2);
        WeatherStation station1 = bureau.getStation("KE000063612");
        WeatherStation station2 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation(2)).isEqualTo(station1); 
        
        // Same month
        str3 = "KE000063612 3.117 35.617 515 3/10/16 0.04 87 98 73";
        str4 = "KE000063820 -4.033 39.617 55 3/25/16 0 88 101 75";
        bureau.recordDailySummary(str3);
        bureau.recordDailySummary(str4);
        WeatherStation station3 = bureau.getStation("KE000063612");
        WeatherStation station4 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation(3)).isEqualTo(station4);
        
        // Invalid rainfall
        str5 = "KE000063612 3.117 35.617 515 2/10/16 -1 87 98 73";
        str6 = "KE000063820 -4.033 39.617 55 4/25/16 -1 88 101 75";
        bureau.recordDailySummary(str5);
        bureau.recordDailySummary(str6);
        WeatherStation station5 = bureau.getStation("KE000063612");
        WeatherStation station6 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation(2)).isEqualTo(station5);
    }
    /**
     * Test for the station with the least average rainfall in
     * any month.
     */
    public void testLowestStation()
    {
        str1 = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        str2 = "KE000063820 -4.033 39.617 55 4/25/16 0 88 101 75";
        bureau.recordDailySummary(str1);
        bureau.recordDailySummary(str2);
        WeatherStation station1 = bureau.getStation("KE000063612");
        WeatherStation station2 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation()).isEqualTo(station2);
        
        str3 = "KE000063612 3.117 35.617 515 3/10/16 0.04 87 98 73";
        str4 = "KE000063820 -4.033 39.617 55 3/25/16 0.08 88 101 75";
        bureau.recordDailySummary(str3);
        bureau.recordDailySummary(str4);
        WeatherStation station3 = bureau.getStation("KE000063612");
        WeatherStation station4 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation()).isEqualTo(station4);
        
        str5 = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        str6 = "KE000063820 -4.033 39.617 55 4/25/16 -1 88 101 75";
        bureau.recordDailySummary(str5);
        bureau.recordDailySummary(str6);
        WeatherStation station5 = bureau.getStation("KE000063612");
        WeatherStation station6 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation()).isEqualTo(station6);
        
        String str7 = "KE000063612 3.117 35.617 515 2/10/16 -1 87 98 73";
        String str8 = "KE000063820 -4.033 39.617 55 4/25/16 -1 88 101 75";
        bureau.recordDailySummary(str7);
        bureau.recordDailySummary(str8);
        WeatherStation station7 = bureau.getStation("KE000063612");
        WeatherStation station8 = bureau.getStation("KE000063820");
        assertThat(bureau.lowestStation()).isEqualTo(station8);
    }
}
