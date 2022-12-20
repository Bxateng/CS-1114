// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that attributes upgrades to 
 *  specific units.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class Upgrade
    implements GameElement
{
    private String name;
    private int points;
    /**
     * Initializes a newly created Upgrade object.
     * @param upName the name of the upgrade
     * @param upPoints the point value of the upgrade
     */
    public Upgrade(String upName, int upPoints)
    {
        super();
        name = upName;
        points = upPoints;
    }
    /**
     * Get this GameElement's name.
     *
     * @return This object's name as a string.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Creates a new name for the unit.
     * @param n the new name of the unit
     */
    public void setName(String n)
    {
        name = n;
    }
    /**
     * Get this GameElement's cost in points.
     *
     * @return The number of points for this object.
     */
    public int getPoints()
    {
        return points;
    }
    /**
     * Creates a new point value for the unit.
     * @param p the new point value of the unit
     */
    public void setPoints(int p) 
    {
        points = p;
    }
    /**
     * Overrides the toString method to return a string
     * detailing the name of the upgrade and the point value.
     * @return the name of the upgrade and point value
     */
    @Override
    public String toString()
    {
        String upgrade = name + " (" + points + ")";
        return upgrade;
    }
}
