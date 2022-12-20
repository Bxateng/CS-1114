// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that collects the data necessary for weather observation.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.06
 */
public class WeatherStation
{
    private String id;
    private int[] monthsArr;
    private double[] rainfall;
    /**
     * Initializes a newly created WeatherStation object.
     * 
     * @param stationId the ID of the weather station
     */
    public WeatherStation(String stationId)
    {
        super();
        id = stationId;
        monthsArr = new int[13];
        rainfall = new double[13];
    }
    /**
     * Returns the weather station ID.
     * 
     * @return the ID of the station
     */
    public String getId()
    {
        return id;
    }
    /**
     * Records one daily summary and adds the rainfall to
     * the specified month.
     * 
     * @param month the month of rain being added on
     * @param rain the amount of rain being added
     */
    public void recordDailyRain(int month, double rain)
    {
        // Records a daily summary and adds rainfall
        // to the specified month
        monthsArr[month] = monthsArr[month] + 1;
        rainfall[month] = rainfall[month] + rain;
    }
    /**
     * Returns the daily rainfall values for the 
     * specified month. Returns zero if no values
     * have been recorded.
     * 
     * @param month the month of rain being retrieved
     * @return the daily rainfall values 
     */
    public int getCountForMonth(int month)
    {
        return monthsArr[month];
    }
    /**
     * Returns the average daily rainfall for the specified
     * month. Returns -1 if no values have been recorded.
     * 
     * @param month the month of rain being averaged
     * @return the average of the daily rainfall
     */
    public double getAvgForMonth(int month)
    {
        if (monthsArr[month] != 0)
        {
            double avg = rainfall[month] / monthsArr[month];
            return avg;
        }
        return -1.0;
    }
    /**
     * Returns the month with the lowest average of rainfall.
     * If two have the same amount, the first is returned.
     * If no values have been recorded for any month,
     * 1 (January) is returned.
     * 
     * @return the month with the lowest rainfall average
     */
    public int getLowestMonth()
    {
        double lowestR = 6900;
        int lowestM = 0;
        for (int i = 1; i < 13; i++)
        {
            if (getAvgForMonth(i) < lowestR && getAvgForMonth(i) >= 0)
            {
                lowestR = getAvgForMonth(i);
                lowestM = i;
            }
        }
        return lowestM;
    }
}
