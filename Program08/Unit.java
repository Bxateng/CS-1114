import java.util.List;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Acts as the template for all available units.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class Unit
    implements GameElement
{
    private String name;
    private List<Upgrade> upgrades;
    private int points;
    private int quality = 2;
    private int defense = 2;
    /**
     * Initializes a newly created Unit object.
     * @param unitName the name of the unit
     * @param unitPoints the point value of the unit
     */
    public Unit(String unitName, int unitPoints)
    {
        super();
        name = unitName;
        points = unitPoints;
    }
    /**
     * Returns the name given to the unit.
     * @return the name of the unit
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
     * Returns the point value of the unit plus the sum
     * of the sum of all the upgrades
     * @return the point value of the unit
     */
    public int getPoints()
    {
        int counter = 0;
        for (Upgrade up : upgrades)
        {
            counter = counter + up.getPoints();
        }
        return points + counter;
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
     * Returns the quality of the unit.
     * @return the quality of the unit
     */
    public int getQuality() 
    {
        return quality;
    }
    /**
     * Creates a new value of quality for the unit.
     * @param q the new quality of the unit
     */
    public void setQuality(int q)
    {
        quality = q;
    }
    /**
     * Returns the defense of the unit.
     * @return the defense of the unit
     */
    public int getDefense() 
    {
        return defense;
    }
    /**
     * Creates a new value of defense for the unit.
     * @param d the new defense of the unit
     */
    public void setDefense(int d) 
    {
        defense = d;
    }
    /**
     * Returns an upgrade for the unit.
     * @return an upgrade
     */
    public List<Upgrade> getUpgrades()
    {
        return upgrades;
    }
    /**
     * Adds an upgrade to the list of upgrades.
     * @param up the new upgrade being added
     */
    public void addUpgrade(Upgrade up)
    {
        upgrades.add(up);
    }
    /**
     * Removes an upgrade from the list of upgrades.
     * @param up the upgrade being removed
     */
    public void removeUpgrade(Upgrade up)
    {
        upgrades.remove(up);
    }
    /**
     * Overrides the toString method to return 
     * the upgrades of the unit
     * @return the upgrades of the unit
     */
    @Override
    public String toString()
    {
        String description = (name + " (" + points + ", " + quality +
        ", " + defense + ")");
        if (upgrades.isEmpty())
        {
            return description;
        }
        else 
        {
            String unitUpgrade = description + " " + 
            upgrades.toString();
            return unitUpgrade;
        }
    }
}
