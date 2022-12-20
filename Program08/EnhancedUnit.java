// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Subclass of Unit that creates a unit with 
 *  a special condition.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class EnhancedUnit
    extends Unit
{
    private String specialRule = null;
    /**
     * Initializes a newly created EnhancedUnit object.
     * @param name the name of the enhanced unit
     * @param points the point value of the enhanced unit
     */
    public EnhancedUnit(String name, int points)
    {
        super(name, points);
    }
    /**
     * Returns the description of the unit's special ability.
     * @return the description of the special rule
     */
    public String getSpecialRule()
    {
        return specialRule;
    }
    /**
     * Creates a new description of the unit's special ability.
     * @param s the description of the special rule
     */
    public void setSpecialRule(String s)
    {
        specialRule = s;
    }
    /**
     * Overrides the toString method to return the 
     * special rule of the unit
     * @return the special rule of the unit
     */
    public String toString()
    {
        if (specialRule == null)
        {
            return super.toString();
        }
        else 
        {
            String euUpgrade = super.toString() + " " + 
            "special rule:[" + specialRule + "]";
            return euUpgrade;
        }
    }
}
