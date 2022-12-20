import java.util.List;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that gathers several units into a squad.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class Squad
    extends EnhancedUnit
{
    private List<Unit> units;
    private String name;
    /**
     * Initializes a newy created Squad object.
     */
    public Squad(String name)
    {
        super(name, 0);
    }
    /**
     * Returns the list of units.
     * @return the list of units
     */
    public List<Unit> getUnits()
    {
        return units;
    }
    /**
     * Adds a unit to the list of units.
     * @param u the unit being added
     */
    public void addUnit(Unit u)
    {
        units.add(u);
    }
    /**
     * Removes a unit from the list of units.
     * @param u the unit being removed
     */
    public void removeUnit(Unit u)
    {
        units.remove(u);
    }
    /**
     * Overrides the getPoints method to return the 
     * sum of the points of all units in the squad
     * plus the sum of the upgrades that have been
     * added to the squad.
     * @return the sum of points and upgrades
     */
    @Override
    public int getPoints()
    {
        int counter = super.getPoints();
        for (Unit u : units)
        {
            counter = counter + u.getPoints();
        }
        return counter;
    }
    /**
     * Overrides the toString method to return the upgrade
     * of the squad
     * @return the upgrade of the squad
     */
    @Override 
    public String toString()
    {
        String squad = super.toString() + " " + "units: " +
        units.toString();
        return squad;
    }
}
