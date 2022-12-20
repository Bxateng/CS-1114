// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that represents individuals posts on
 *  social media.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.28
 */
public class Post
{
    private String name;
    private String message;
    private int day;
    private int hour;
    /**
     * Initializes a newly created Post object.
     * @param postN the name of the post
     * @param postM the post message
     * @param postD the day of the post
     * @param postH the hour of the post
     */
    public Post(String postN, String postM, int postD, int postH)
    {
        super();
        name = postN;
        message = postM;
        day = postD;
        hour = postH;
    }
    /**
     * Getter method for the name.
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Getter method for the message.
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }
    /**
     * Getter method for the day.
     * @return the day
     */
    public int getDay()
    {
        return day;
    }
    /**
     * Getter method for the hour.
     * @return the hour
     */
    public int getHour()
    {
        return hour;
    }
}
