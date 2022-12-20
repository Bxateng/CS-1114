import java.util.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that performs oversight on the various stations
 *  from the WeatherStation class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.12.06
 */
public class WeatherBureau
{
    private Map<String, WeatherStation> state;
    /**
     * Initializes a newly created WeatherBureau object.
     */
    public WeatherBureau()
    {
        super();
        state = new HashMap<String, WeatherStation>();
    }
    /**
     * Takes a daily weather summary from a weather station and records
     * the rainfall onto the bureau map.
     * 
     * @param text the weather summary
     */
    public void recordDailySummary(String text)
    {
        // Records one daily summary 
        Scanner scan = new Scanner(text);
        String stationId = scan.next();
        scan.next();
        scan.next();
        scan.next();
        String s = scan.next();
        String month1 = s.substring(0, 1);
        String month2 = s.substring(0, 2);
        int m = 0;
        double r = scan.nextDouble();
        if (month2.endsWith("/"))
        {
            m = Integer.parseInt(month1);
        }
        else
        {
            m = Integer.parseInt(month2);
        }
        if (r != -1)
        {
            if (state.containsKey(stationId))
            {
                state.get(stationId).recordDailyRain(m, r);
            }
            else
            {
                WeatherStation weather = new WeatherStation(stationId);
                state.put(stationId, weather);
                weather.recordDailyRain(m, r);
            }
        }
    }
    /**
     * Records all the daily summaries from a data source input via 
     * a Scanner object.
     * 
     * @param input the source of daily summaries
     */
    public void recordDailySummaries(Scanner input)
    {
        // Records multiple daily summaries
        while (input.hasNextLine())
        {
            recordDailySummary(input.nextLine());
        }
    }
    /**
     * Returns a WeatherStation object for the ID of said station.
     * 
     * @param stationId the ID of the station
     * @return the weather station that corresponds 
     * with the ID
     */
    public WeatherStation getStation(String stationId)
    {
        return state.get(stationId);
    }
    /**
     * Returns the weather station with the lowest average 
     * recorded rainfall for the specified month. Returns
     * null if there are no records.
     * 
     * @param month the month being specified
     * @return the station with the lowest average rainfall
     * in the given month
     */
    public WeatherStation lowestStation(int month)
    {
        double lowestS = 10000; 
        String id = "";
        for (Map.Entry<String, WeatherStation> pair : state.entrySet())
        {
            if (pair.getValue().getAvgForMonth(month) < lowestS &&
                pair.getValue().getAvgForMonth(month) != -1)
            {
                lowestS = pair.getValue().getAvgForMonth(month);
                id = pair.getKey();
            }
        }
        return state.get(id);
    }
    /**
     * Returns the weather station with the lowest average 
     * rainfall recorded for any month. Returns the earliest 
     * finding of the lowest average if multiple stations 
     * are tied.
     * 
     * @return the weather station with the lowest rainfall
     * average
     */
    public WeatherStation lowestStation()
    {
        double lowestS = 10000;
        WeatherStation weather = null;
        for (Map.Entry<String, WeatherStation> pair : state.entrySet())
        {
            if (pair.getValue().getAvgForMonth(pair.getValue()
                .getLowestMonth()) < lowestS)
            {
                lowestS = pair.getValue()
                    .getAvgForMonth(pair.getValue().getLowestMonth());
                weather = pair.getValue();
            }
        }
        return weather; 
    }
}
