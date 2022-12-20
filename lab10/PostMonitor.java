// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that represents a monitor that tracks
 *  information about social media posts.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.28
 */
public class PostMonitor
{
    private int postCount;
    private int[] hourCounts;
    private int[] dayCounts;
    /**
     * Initializes a newly created PostMonitor object.
     */
    public PostMonitor()
    {
        super();
        postCount = 0;
        hourCounts = new int[24];
        dayCounts = new int[7];
    }
    /**
     * Getter method for the post count.
     * @return the post count
     */
    public int getPostCount()
    {
        return postCount;
    }
    /**
     * Getter method for the hour count.
     * @return the hour count
     */
    public int[] getHourCounts()
    {
        return hourCounts;
    }
    /**
     * Getter method for the day count.
     * @return the day count
     */
    public int[] getDayCounts()
    {
        return dayCounts;
    }
    /**
     * Records the day and hour when the post was
     * published.
     * @param p the post
     */
    public void recordPost(Post p)
    {
        hourCounts[p.getHour()]++;
        dayCounts[p.getDay()]++;
        postCount++;
    }
    /**
     * Returns an integer representing the index of the array
     * where the largest value is.
     * @return the index position
     * @param array the array being checked
     */
    public int getIndexOfLargest(int[] array)
    {
        int val = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i] > val) 
            {
                val = array[i];
                index = i;
            }
        }
        return index;
    }
    /**
     * Returns an integer representing the hour
     * with the largest count.
     * @return the busiest hour
     */
    public int getBusiestHour()
    {
        return getIndexOfLargest(hourCounts);
    }
    /**
     * Returns an integer representing the day
     * with the largest count.
     * @return the busiest day
     */
    public int getBusiestDay()
    {
        return getIndexOfLargest(dayCounts);
    }
    /**
     * Returns an integer representing the index
     * position with the smallest value.
     * @return the index position
     * @param array the array being checked
     */
    public int getIndexOfSmallest(int[] array)
    {
        int val = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] < val)
            {
                val = array[i];
                index = i;
            }
        }
        return index;
    }
    /**
     * Returns an integer representing the hour
     * with the smallest count.
     * @return the smallest hour count
     */
    public int getSlowestHour()
    {
        return getIndexOfSmallest(hourCounts);
    }
    /**
     * Returns an integer representing the day 
     * with the smallest count.
     * @return the smallest day count
     */
    public int getSlowestDay()
    {
        return getIndexOfSmallest(dayCounts);
    }
}
