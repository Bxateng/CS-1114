// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Subclass of EnhancedUnit that creates
 *  a special Hero unit.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public class Hero
    extends EnhancedUnit
{
    /**
     * Initializes a newly created Hero object.
     * @param name the name of the hero
     * @param points the point value of the hero
     */
    public Hero(String name, int points)
    {
        super(name, points);
        this.setQuality(5);
        this.setDefense(5);
    }
}
